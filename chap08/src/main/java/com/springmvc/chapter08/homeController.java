package com.springmvc.chapter08;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController 
{
	@GetMapping("/")
	public String gohome(Model model)
	{
		System.out.println("Controller.gohome 입장");
		return "home";
	}
	
}
