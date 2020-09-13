package com.capgemini.repo;

import com.capgemini.beans.Account;

public interface AccountRepository{
	boolean save(int accountNumber,Account account);
	
	Account searchAccount(int accountNumber);

}
