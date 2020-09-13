package com.capgemini.repo;

import java.util.HashMap;

import com.capgemini.beans.Account;

public class AccountRepositoryImpl implements AccountRepository {
	HashMap map;
	Account account=new Account();
	
	public AccountRepositoryImpl() {
		map=new HashMap();
	}

	@Override
	public boolean save(int accountNumber,Account account) {
		map.put(accountNumber,account);
		return true;
	}

	@Override
	public Account searchAccount(int accountNumber) {
		if(map.containsKey(accountNumber)) {
			account=(Account) map.get(accountNumber);
			return account;
		}
		else 
			return null;
	}

}
