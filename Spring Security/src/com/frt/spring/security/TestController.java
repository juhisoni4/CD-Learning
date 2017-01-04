package com.frt.spring.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping(value="login")
	public String login(){
		
		return "login";
	}

	@RequestMapping(value="list")
	public String list(){
		return "index";
	}
}
