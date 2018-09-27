package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/home")

public class HomeController {
	
	@RequestMapping
	public String handleRequest()
	{
		System.out.println("HomeController.handleRequest()");
		return "index";
	}

//	@RequestMapping("/message")
//	public String handleMessageRequest(@RequestParam("msg") String message)
//	{	System.out.println("HomeController.handleMessageRequest"+message);
//		return "index";
//	}
	
	//  /home/message?msg=abc
	@RequestMapping("/message")
	public ModelAndView handleMessageRequest(@RequestParam("msg") String message)
	{	System.out.println("HomeController.handleMessageRequest"+message);
		
		String formatterMessage="Hello "+message;
		return new ModelAndView("index","formatterMessage",formatterMessage);	
	}

	// /home/path/100/oracle
	@RequestMapping("/path/{id}/{name}")
	public String handlePathRequest(@PathVariable("id") int id,
			@PathVariable("name") String name,
			Model model)
	{
		System.out.println("HomeController.handlePathRequest() "+id);
		model.addAttribute("name", name);
		return "index";
	}
	
	// /home/json
	
	@RequestMapping("/json")
	@ResponseBody
	public String handleJsonRequest() {
		System.out.println("HomeController.handleJsonRequest()");
		return "Hello World";

	}
}

