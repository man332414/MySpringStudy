package com.springmvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class homeController 
{
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale Locale, Model model)
	{
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale);
	      
		String formattedDate = dateFormat.format(date);
	      
		model.addAttribute("serverTime", formattedDate);
	      
		// /WEB-INF/views/		.jsp
		return "home";
	}
}
