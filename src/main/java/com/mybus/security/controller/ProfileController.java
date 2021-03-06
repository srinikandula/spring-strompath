package com.mybus.security.controller;

import javax.servlet.http.HttpSession;

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

import com.mybus.dto.GWCGroupMembership;
import com.mybus.dto.User;
import com.mybus.security.model.sdk.StormpathService;
import com.mybus.security.validator.ProfileValidator;
import com.stormpath.sdk.group.Group;
import com.stormpath.sdk.resource.ResourceException;

/**
 * @author Elder Crisostomo
 */
@Controller
@RequestMapping("/profile")
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ProfileController {

    ProfileValidator profileValidator;

    
    @Autowired
    StormpathService stormpath;

    @Value("${stormpath.sdk.administrator.rest.url}")
    private String administratorGroupURL;

    @Value("${stormpath.sdk.premium.rest.url}")
    private String premiumGroupURL;

    public ProfileController() {
    }

    @Autowired
    public ProfileController(ProfileValidator profileValidator) {
        this.profileValidator = profileValidator;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(@ModelAttribute("user") User user,
                                BindingResult result,
                                SessionStatus status,
                                HttpSession session,
                                ModelMap model) {

        model.addAttribute("ADMINISTRATOR_URL", administratorGroupURL);
        model.addAttribute("PREMIUM_URL", premiumGroupURL);

        profileValidator.validate(user, result);

        if (!result.hasErrors()) {

            try {

                // For account update, we just retrieve the current account and
                // call Account.save() after setting the modified properties.
                // An account can also be retrieved from the DataStore,
                // like the way we do it to get an Application or Directory object,
                // if the account's Rest URL is known to the application.

            	User sessionUser = (User) session.getAttribute("sessionUser");
                
                String existingGroupUrl = null;
                if (sessionUser.getGroupMemberships().iterator().hasNext()) {
                    GWCGroupMembership groupMembership = sessionUser.getGroupMemberships().iterator().next();
                    existingGroupUrl = groupMembership.getGroup().getHref();
                    if (!existingGroupUrl.equals(user.getGroupUrl())) {
                        groupMembership.delete();
                        existingGroupUrl = null;
                    }
                }

                if (user.getGroupUrl() != null && !user.getGroupUrl().isEmpty() && existingGroupUrl == null) {
                	sessionUser.addGroup(stormpath.getDataStore().getResource(user.getGroupUrl(), Group.class));
                }

                sessionUser.save();

              
                user.setUserName(sessionUser.getUserName());

                model.addAttribute("messageKey", "updated");
                model.addAttribute("user", user);
            } catch (ResourceException re) {
                ObjectError error = new ObjectError("user", re.getMessage());
                result.addError(error);
                re.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            status.setComplete();
        }
        return "profile";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String initForm(ModelMap model, HttpSession session) {
    	User user = (User) session.getAttribute("sessionUser");

        model.addAttribute("user", user);
        model.addAttribute("ADMINISTRATOR_URL", administratorGroupURL);
        model.addAttribute("PREMIUM_URL", premiumGroupURL);

        return user == null ? "redirect:/login" : "profile";
    }
}