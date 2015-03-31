package com.mybus.security.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.mybus.dto.User;
import com.mybus.security.model.sdk.StormpathService;
import com.mybus.security.util.PermissionUtil;
import com.mybus.security.validator.LoginValidator;
import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.authc.AuthenticationRequest;
import com.stormpath.sdk.authc.AuthenticationResult;
import com.stormpath.sdk.authc.UsernamePasswordRequest;
import com.stormpath.sdk.resource.ResourceException;

@Controller
@RequestMapping("/login")
public class LoginController {

    private LoginValidator loginValidator;

    @Autowired
    private StormpathService stormpath;

    @Autowired
    PermissionUtil permissionUtil;

    @Autowired
    public LoginController(LoginValidator loginValidator) {
        this.loginValidator = loginValidator;
    }

    @SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.POST)
    public String processSubmit(@ModelAttribute("customer") User customer,
                                BindingResult result,
                                SessionStatus status,
                                HttpSession session) {

        loginValidator.validate(customer, result);

        String returnStr = "redirect:/login/message?loginMsg=invalidcredentials";

        if (!result.hasErrors()) {

            try {

                // For authentication the only thing we need to do is call Application.authenticate(),
                // instantiating the proper AuthenticationRequest (UsernamePasswordRequest in this case),
                // providing the account's credentials.
                AuthenticationRequest request = new UsernamePasswordRequest(customer.getUserName(), customer.getPassword());
                AuthenticationResult authcResult = stormpath.getApplication().authenticateAccount(request);
               
               

                Account account = authcResult.getAccount();
                
                User accountDTO = new User(account);
                // If the customer queried from the database does not exist
                // we create it in the application's internal database,
                // so we don't have to go through the process of signing a user up
                // that has already been authenticated in the previous call to the Stormpath API.
                // This is because the application uses an in-memory database (HSQLDB)
                // that only persists while the application is up.
               
                session.setAttribute("sessionUser", accountDTO);
                session.setAttribute("permissionUtil", permissionUtil);

                returnStr = "redirect:/console";

                status.setComplete();
            } catch (ResourceException re) {
                result.addError(new ObjectError("userName", re.getMessage()));
                re.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return returnStr;
    }

    @RequestMapping(method = RequestMethod.POST, value = "message")
    public String processSubmitMsg(@ModelAttribute("customer") User customer,
                                   BindingResult result,
                                   SessionStatus status,
                                   HttpSession session) {
        return processSubmit(customer, result, status, session);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String initForm(@ModelAttribute("customer") User customer, BindingResult result, ModelMap model) {
        try {
            stormpath.getTenant();
        } catch (Throwable t) {
            result.addError(new ObjectError("userName",
                    "You have not finished configuring this sample application. " +
                            "Please follow the <a href=\"https://github.com/stormpath/stormpath-spring-samples/wiki/Tooter\">" +
                            "Set-up Instructions</a>"));
            t.printStackTrace();
        }

        model.addAttribute("customer", customer);

        //return form view
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/message")
    public String initMessage(@RequestParam("loginMsg") String messageKey,
                              @ModelAttribute("customer") User customer,
                              BindingResult result,
                              ModelMap model) {

        model.addAttribute("customer", customer);
        model.addAttribute("messageKey", messageKey);

        //return form view
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/emailVerificationTokens")
    public String accountVerification(@RequestParam("sptoken") String token,
                                      @ModelAttribute("customer") User customer,
                                      BindingResult result) {

        String returnStr = "login";

        try {

            stormpath.getTenant().verifyAccountEmail(token);
            returnStr = "redirect:/login/message?loginMsg=accVerified";

        } catch (RuntimeException re) {

            result.addError(new ObjectError("userName", re.getMessage()));
            re.printStackTrace();
        }

        return returnStr;

    }


}
