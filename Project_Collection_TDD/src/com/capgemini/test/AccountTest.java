package com.capgemini.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.AccountAlreadyExistException;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.repo.AccountRepository;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;

public class AccountTest {

	AccountService accountService;

	@Mock
	AccountRepository accountRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		accountService = new AccountServiceImpl();

	}

	@Test(expected = InsufficientOpeningBalanceException.class)
	public void whenTheAmountIsLessThan500SystemShouldThrowException()
			throws InsufficientOpeningBalanceException, AccountAlreadyExistException {
		accountService.createAccount(101, 400);
	}

	@Test
	public void whenTheValidInfoIsPassedAccountShouldBeCreatedSuccessfully()
			throws InsufficientOpeningBalanceException, AccountAlreadyExistException {
		Account account = new Account();
		account.setAccountNumber(102);
		account.setAmount(5000);
		when(accountRepository.save(account.getAccountNumber(), account)).thenReturn(true);
		assertTrue(accountService.createAccount(102, 5000));
	}

	@Test(expected = AccountAlreadyExistException.class)
	public void whenTheAccountNumberAlreadyExistThenAccountShouldThrowException()
			throws InsufficientOpeningBalanceException, AccountAlreadyExistException {
		assertTrue(accountService.createAccount(101, 5000));
		assertFalse(accountService.createAccount(101, 4000));
	}

	@Test(expected = InsufficientBalanceException.class)
	public void whenWithdrawlAmountIsGreaterThanBalanceThenAccountShouldThrowException()
			throws InsufficientOpeningBalanceException, AccountAlreadyExistException, InsufficientBalanceException,
			InvalidAccountNumberException {
		accountService.createAccount(103, 600);
		when(accountService.withdrawAmount(103, 700)).thenReturn(null);
		assertTrue(accountService.createAccount(103, 600));

	}
	
	

}
