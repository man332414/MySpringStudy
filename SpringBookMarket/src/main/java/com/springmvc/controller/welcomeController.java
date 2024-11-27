package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.DAO.service.BookService;
import com.springmvc.DTO.Book;

@Controller("/")
public class welcomeController 
{
	@GetMapping
	public String basePage(Model model)
	{
		System.out.println("Welcome! I'm basePage");
		model.addAttribute("greeting", "Welcome to BookMarket");
		model.addAttribute("strapline", "Welcome to Web Shopping Mall!");
		System.out.println("basePage : Goodbye! My friend. Have a great day! ");
		return "welcome";
	}	
	
	@GetMapping(value="/home")
	public String welcome(Model model)
	{
		System.out.println("Welcome! I'm Controller");
		model.addAttribute("greeting", "Welcome to BookMarket");
		model.addAttribute("strapline", "Welcome to Web Shopping Mall!");
		System.out.println("Controller : Goodbye! My friend. Have a great day! ");
		return "welcome";
	}
}
