package com.repository;

import java.util.List;

import com.model.Account;

public interface AccountRepository {

	public List<Account> getAllAccount();

	public void saveAccount(Account acc);

	public void deposit(int id, double amt) throws Exception;

	public void withdraw(int id, double amt) throws Exception;

}