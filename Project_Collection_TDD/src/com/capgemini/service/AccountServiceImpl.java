package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.AccountAlreadyExistException;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.repo.AccountRepository;
import com.capgemini.repo.AccountRepositoryImpl;

public class AccountServiceImpl implements AccountService {
	

	AccountRepository accountRepository=new AccountRepositoryImpl();
	Account account=new Account();
	boolean isAccountCreated = false;

	public AccountServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public boolean createAccount(int accountNumber,int amount) throws InsufficientOpeningBalanceException, AccountAlreadyExistException
	{
		Account account = new Account();
		if(amount<500) { 
			isAccountCreated=false; 
			throw new InsufficientOpeningBalanceException();
			}
		
		if(accountRepository.searchAccount(accountNumber)==null) {
				account.setAccountNumber(accountNumber);
				account.setAmount(amount);
				accountRepository.save(accountNumber, account);
				isAccountCreated=true;
		}
		else {
			isAccountCreated=false;
			throw new AccountAlreadyExistException();
		}	
		return isAccountCreated;
		
	}


	@Override
	public Account withdrawAmount(int accountNumber, int withdrawAmount) throws InsufficientBalanceException, InvalidAccountNumberException {
	
		account=accountRepository.searchAccount(accountNumber);
		if(account==null) {
			throw new InvalidAccountNumberException();
		}else {
			if(account.getAmount()>withdrawAmount) {
				account.setAmount( account.getAmount()-withdrawAmount);
			} else {
				throw new InsufficientBalanceException();
			}
			accountRepository.save(accountNumber, account);
		}
		return account;
	}

}
