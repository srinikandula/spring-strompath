package com.mybus.security.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.mybus.dto.User;
import com.mybus.security.model.sdk.StormpathService;
import com.mybus.security.validator.SignUpValidator;
import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.directory.Directory;
import com.stormpath.sdk.group.Group;

/**
 * @author Elder Crisostomo
 */
@Controller
@RequestMapping("/signUp")
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class SignUpController {

  

    SignUpValidator singUpValidator;

    @Autowired
    StormpathService stormpath;

    @Value("${stormpath.sdk.administrator.rest.url}")
    private String administratorGroupURL;

    @Value("${stormpath.sdk.premium.rest.url}")
    private String premiumGroupURL;

    public SignUpController() {
    }

    @Autowired
    public SignUpController(SignUpValidator signUpValidator) {
        this.singUpValidator = signUpValidator;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(@ModelAttribute("user") User user, ModelMap model, BindingResult result, SessionStatus status) {

        singUpValidator.validate(user, result);

        Map<String, String> groupMap = null;

        try {

            if (result.hasErrors()) {

                model.addAttribute("ADMINISTRATOR_URL", administratorGroupURL);
                model.addAttribute("PREMIUM_URL", premiumGroupURL);
                setGroupsToModel(groupMap, model);

                return "signUp";
            }

            String userName = user.getUserName();

            // For account creation, we should get an instance of Account from the DataStore,
            // set the account properties and create it in the proper directory.
            Account account = stormpath.getDataStore().instantiate(Account.class);
            account.setEmail(user.getEmail());
            account.setGivenName(user.getFirstName());
            account.setSurname(user.getLastName());
            account.setPassword(user.getPassword());
            account.setUsername(userName);

            // Saving the account to the Directory where the getwell application belongs.
            Directory directory = stormpath.getDirectory();
            directory.createAccount(account);

            if (user.getGroupUrl() != null && !user.getGroupUrl().isEmpty()) {
                account.addGroup(stormpath.getDataStore().getResource(user.getGroupUrl(), Group.class));
            }

            user.setUserName(userName);
          
            status.setComplete();

        } catch (RuntimeException re) {

            model.addAttribute("ADMINISTRATOR_URL", administratorGroupURL);
            model.addAttribute("PREMIUM_URL", premiumGroupURL);
            setGroupsToModel(groupMap, model);

            result.addError(new ObjectError("password", re.getMessage()));
            re.printStackTrace();
            return "signUp";

        } catch (Exception e) {
            e.printStackTrace();
        }

        //form success
        return "redirect:/login/message?loginMsg=registered";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String initForm(ModelMap model) {

    	User cust = new User();

        Map<String, String> groupMap = null;

        setGroupsToModel(groupMap, model);

        model.addAttribute("customer", cust);
        model.addAttribute("ADMINISTRATOR_URL", administratorGroupURL);
        model.addAttribute("PREMIUM_URL", premiumGroupURL);

        //return form view
        return "signUp";
    }

    private void setGroupsToModel(Map<String, String> groupMap, ModelMap model) {

        groupMap = new HashMap<String, String>();

        for (Group group : stormpath.getDirectory().getGroups()) {
            groupMap.put(group.getHref(), group.getName());
        }

        model.addAttribute("groupMap", groupMap);

    }

}
