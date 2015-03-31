package com.mybus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class ApiDocController{	
	public ApiDocController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(value = {"/apidocs"}, method = RequestMethod.GET)
    public  String getDocs() {
		return "jsondoc";		
	}
}
