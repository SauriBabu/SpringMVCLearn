package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.print.resources.serviceui;

import com.model.Account;
import com.services.AccountService;
import com.validator.accountValidator;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private accountValidator accountValid;
	
	@Autowired
	private AccountService acccountService;

	@RequestMapping(value="/add" ,method=RequestMethod.GET)
	public String addAccount(Model model)
	{
		System.out.println("AccountController.addAccount");
		model.addAttribute("acc", new Account());
		return "addAccount";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveAccount(@ModelAttribute("acc") Account a,BindingResult bindingResult)
	{
		System.out.println("time is save");
		accountValid.validate(a,bindingResult);
		if(bindingResult.hasErrors())
		{
			return "addAccount";
		}
		
		System.out.println("AccountController.saveAccount");
		acccountService.saveAccount(a);
		return "index";
	}
	//   /tranfer/1/2/1000
	
	@RequestMapping("/transfer/{fromId}/{toId}/{amt}")
	@ResponseBody
	public String transfer(	@PathVariable("fromId") int fromId,
		@PathVariable("toId") int toId,
		@PathVariable("amt") double amt)
		
		{
			try {
				System.out.println("AccountController.transfer()");
				acccountService.transfer(fromId, toId, amt);
				return "Transfer success";
				
			} catch (Exception e) {
				
				System.out.println("transfer failed");
				return "Transfer failed";
			}
		}
		
		
	}
	

