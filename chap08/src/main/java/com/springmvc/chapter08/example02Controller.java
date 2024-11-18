package com.springmvc.chapter08;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class example02Controller 
{
	@GetMapping("/exam02")
	public String requestMethod(Model model)
	{
		System.out.println("Controller.requestMethod1 입장");
		return "webpage08_02";
	}
	
	@GetMapping("/manager/tag")
	public String requestMethod2(Model model)
	{
		System.out.println("Controller.requestMethod2 입장");
		return "webpage08_02";
	}
}
