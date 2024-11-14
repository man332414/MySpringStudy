package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class welcomeController 
{
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String welcome(Model model)
	{
		System.out.println("Welcome! I'm Controller");
		model.addAttribute("greeting", "Welcome to BookMarket");
		model.addAttribute("strapline", "Welcome to Web Shopping Mall!");
		System.out.println("Controller : Goodbye! My friend. Have a great day! ");
		return "welcome";
	}
}
