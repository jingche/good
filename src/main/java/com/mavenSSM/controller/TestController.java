  package com.mavenSSM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mavenSSM.model.User;
import com.mavenSSM.service.TestService;

@Controller
@RequestMapping("/")
public class TestController {
	@Autowired
	private TestService ts;
	
	/*@RequestMapping(value="", method=RequestMethod.GET)
	public String toTest(){
		return "test";
	}*/
	@RequestMapping(value="")
	public String toIndex() {
		return "index";
	}
	 
	 
	 
	@RequestMapping(value="about-us")
	public String toAbout() {
		return "about-us";
	}
	
	@RequestMapping(value="getUser")
	@ResponseBody
	public User getUser(){
		return ts.getUser();
	}
}
