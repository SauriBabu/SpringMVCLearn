package com.repository.helpers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.model.Account;
import com.model.Address;

public class AccountMapper implements RowMapper<Account> {

	

	@Override
	public Account mapRow(ResultSet rs, int index) throws SQLException {
		
		Account account=new Account();
		account.setId(rs.getInt("id"));
		account.setName(rs.getString("name"));
		account.setBalance(rs.getDouble("balance"));
		account.setMailingAddress(new Address());
		account.getMailingAddress().setCity("city");
		account.getMailingAddress().setState("state");
		account.getMailingAddress().setPincode("pincode");
		return account;
	}
}
