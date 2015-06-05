package com.asiantech.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/account")
public class AccountSpring {
	@RequestMapping("")
	public String getLogin(){
		return "succses";
		
	}
}
