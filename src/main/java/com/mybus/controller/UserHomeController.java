package com.mybus.controller;

import com.mybus.controller.utils.ControllerUtils;
import com.mybus.dto.User;
import com.mybus.model.GWCGroup;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/api/v1/")
public class UserHomeController {
	
	
	@ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "appconfig", method = RequestMethod.GET, produces = ControllerUtils.JSON_UTF8)
    @ResponseBody
    @ApiResponseObject
    public String getAppConfig() {
		String appConfigs = "{\"conditions.enabled\":false,\"procedures.enabled\":false}";
		// TODO get appConfig
		return appConfigs;
	}
	
	@ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "user/me", method = RequestMethod.GET, produces = ControllerUtils.JSON_UTF8)
    @ResponseBody
    @ApiResponseObject
    public User getUserInfo(HttpSession session) {
		User account = (User)session.getAttribute("sessionUser");
		return account;
	}
	
	@ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "user/groups", method = RequestMethod.GET, produces = ControllerUtils.JSON_UTF8)
    @ResponseBody
    @ApiResponseObject
    public List<GWCGroup> getUserGroups(HttpSession session) {
		User account = (User)session.getAttribute("sessionUser");
		return account.getGroups();
	}

}
