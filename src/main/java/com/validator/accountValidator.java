package com.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.model.Account;

@Component
public class accountValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz)
	{
		return clazz.equals(Account.class);
	}
	
	
	@Override
	public void validate(Object obj,Errors err)
	{
	Account acc=(Account)obj;
	if(acc.getId()<=0)
	{
		err.rejectValue("id","account.err.id","account id can not be 0 or negative");
	}
	
	if(acc.getName().isEmpty())
	{
		err.rejectValue("name","account.err.name","name can not be empty");
	}
	
	if(acc.getBalance()<1000)
	{
		err.rejectValue("balance","account.err.balance","balance can not be less than 1000");
	}
	}


	
}
