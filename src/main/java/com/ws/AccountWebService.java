package com.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.model.Account;


@WebService(serviceName="AccountWebService", targetNamespace="http://rave.com/service",
portName="AccountWebServicePort"
			)
public interface AccountWebService {

	@WebMethod
	public List<Account> getAccounts();

	@WebMethod
	public void saveAccount(Account acc);

}