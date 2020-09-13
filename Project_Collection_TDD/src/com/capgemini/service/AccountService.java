package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.AccountAlreadyExistException;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;

public interface AccountService {
	public boolean createAccount(int accountNumber,int amount) throws InsufficientOpeningBalanceException, AccountAlreadyExistException;
	public Account withdrawAmount(int accountNumber,int withdrawAmount)throws InsufficientBalanceException, InvalidAccountNumberException;

}