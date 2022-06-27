package com.in28minutes.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springboot.web.service.LoginService;



@Controller
@SessionAttributes("Name")
public class LoginController {
	
	//dependency injectioin = LoginService is the depedency of this class
	//Injected automatically
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginMessage(ModelMap model) {
		model.put("errormessege", "Invalid Credenetial");
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String showWelcomeMessage(@RequestParam String name, @RequestParam String password,ModelMap model) {
		boolean isValidUser = service.validateUser(name, password);
		if(!isValidUser) {
			return "login";
		}
		else {
			model.put("Name", name);
			model.put("Password", password);
			return "home";
		}
		
	}

}
