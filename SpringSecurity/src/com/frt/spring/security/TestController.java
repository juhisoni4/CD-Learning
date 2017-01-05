package com.frt.spring.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;
		
	}

	@RequestMapping(value = "/")
	public String list() {
		return "index";
	}
	
}
