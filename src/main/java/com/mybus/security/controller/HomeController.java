package com.mybus.security.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.mybus.dto.User;
import com.mybus.security.model.sdk.StormpathService;


@Controller
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class HomeController {

    

    @Autowired
    private StormpathService stormpath;


    public HomeController() {
    }


    @RequestMapping(method = RequestMethod.POST, value = "/console")
    public String processSubmit(@ModelAttribute("user") User user,
                                BindingResult result,
                                SessionStatus status,
                                HttpSession session) {
    	User sessionUser = (User) session.getAttribute("sessionUser");
        if (!result.hasErrors()) {
        }
        status.setComplete();
        //form success
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/console")
    public String initForm(ModelMap model,
                           @ModelAttribute("user") User user,
                           BindingResult result,
                           HttpSession session) {
        try {
           user = (User) session.getAttribute("sessionUser");
            if (user == null || user.getId() == null) {
                // if they're not in the session, they're probably not logged in
                return "redirect:/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

}