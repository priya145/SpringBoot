package com.in28minutes.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class homeController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String homePage() {
		return "homepage";
	}
	


}
