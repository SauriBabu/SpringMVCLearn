package com.ws;

import java.util.List;

import javax.jws.WebService;

import com.model.Account;
import com.services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@WebService(endpointInterface="com.ws.AccountWebService")
public class AccountWebServiceImpl implements AccountWebService {

	@Autowired
	private AccountService service;
	@Override
	public List<Account> getAccounts()
	{
		return service.getAccounts();
	}

	/* (non-Javadoc)
	 * @see com.ws.AccountWebService#saveAccount(com.model.Account)
	 */
	@Override
	public void saveAccount(Account acc)
	{
		service.saveAccount(acc);
	}

}

