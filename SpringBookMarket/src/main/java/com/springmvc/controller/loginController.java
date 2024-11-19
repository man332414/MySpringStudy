package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController 
{
	@GetMapping("/login")
	public String login() 
	{
		System.out.println("controller.login() 입장");
		return "login";
	}
	
	@GetMapping("/loginfailed")
	public String loginerror(Model model)
	{
		model.addAttribute("error", "true");
		System.out.println("controller.loginerror 입장 ");
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(Model model)
	{
		System.out.println("controller.logout 입장 ");
		return "login";
	}
}
