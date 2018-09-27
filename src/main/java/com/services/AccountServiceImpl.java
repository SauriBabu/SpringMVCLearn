package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.Account;
import com.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository repository;
	
	/* (non-Javadoc)
	 * @see com.services.AcccountService#getAccounts()
	 */
	@Override
	public List<Account> getAccounts()
	{
		System.out.println("AccountServiceImpl.getAccounts()");
		return repository.getAllAccount();
	}
	
	/* (non-Javadoc)
	 * @see com.services.AcccountService#saveAccount(com.model.Account)
	 */
	@Override
	public void saveAccount(Account acc) {
		
		System.out.println("AccountServiceImpl.saveAccount()");
		repository.saveAccount(acc);
		
	}
	
	@Override
//	@Transactional(propagation=Propagation.REQUIRES_NEW,rollbackFor={Exception.class})
	public  void transfer(int fromId,int toId,double amt)throws Exception {
		try {
			repository.deposit(toId, amt);
			repository.withdraw(fromId, amt);
			System.out.println("AccountServiceImpl.transfer() : success");
		} catch (Exception e) {
			System.out.println("AccountServiceImpl.transfer() : fail");
			throw e;
		}

	}
}
