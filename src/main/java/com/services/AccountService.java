package com.services;

import java.util.List;

import com.model.Account;

public interface AccountService {

	public List<Account> getAccounts();

	public void saveAccount(Account acc);

	void transfer(int fromId, int toId, double amt) throws Exception;

}