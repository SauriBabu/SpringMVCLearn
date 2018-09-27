package com.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.Account;
import com.repository.helpers.AccountMapper;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

	private List<Account> allAccounts = new ArrayList<>();
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Account> getAllAccount()
	{
		System.out.println("AccountRepositoryImpl.getAllAccount()");
		
		String query="select * from accounts";
		List<Account> accounts=jdbcTemplate.query(query,new AccountMapper());
		return accounts;
		
		
	}
	
	/* (non-Javadoc)
	 * @see com.repository.AccountService#saveAccount(com.model.Account)
	 */
	@Override
	public void saveAccount(Account acc)
	{
		this.allAccounts.add(acc);
		System.out.println("AccountRepositoryImpl.saveAccount()" + allAccounts.size());
		String insertCmd="insert into accounts (id,name,balance,city,state,pincode)"+ "values(?,?,?,?,?,?)";
		int rowsAffected=jdbcTemplate.update(insertCmd,acc.getId(),
				
											acc.getName(),
											acc.getBalance(),
											acc.getMailingAddress().getCity(),
											acc.getMailingAddress().getState(),
											acc.getMailingAddress().getPincode());
		
		if(rowsAffected==1)
		{
			System.out.println("AccountRepositoryImpl.saveAccount() completed");
		}
		else {
			System.out.println("AccountRepositoryImpl.saveAccount() failed");
		}
	
	
	
	
	}
	
	
	/* (non-Javadoc)
	 * @see com.repository.AccountService#deposit(int, double)
	 */
	@Override
//	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void deposit(int id,double amt)throws Exception
	{
		String upCmd="update accounts set balance=balance+? where id=?";
		try {
			int rowsAffected = jdbcTemplate.update(upCmd, amt, id);
			if(rowsAffected!=1)
			{
				throw new Exception("deposit failed...");
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.repository.AccountService#withdraw(int, double)
	 */
	@Override
//	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void withdraw(int id,double amt)throws Exception
	{
		String query="select balance from accounts where id=?";
		System.out.println(id);
		
		try {
			Double balance=jdbcTemplate.queryForObject(query,Double.class,id); 
			if(balance > amt)
			{
				String upCmd="update accounts set balance=balance-? where id=?";
				System.out.println(upCmd);
				int rowsAffected=jdbcTemplate.update(upCmd,amt,id);
				if(rowsAffected!=1)
					throw new Exception("withdraw failed");
			}
			else{
				 throw new Exception("no sufficient balance");
			}
		} catch (Exception e) {
			throw e;
		}
		
	}
	
}
