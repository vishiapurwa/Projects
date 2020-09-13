package com.capgemini.ui;

import java.util.Scanner;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.AccountAlreadyExistException;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;


public class AccountUI {

	public static void main(String[] args) throws InsufficientOpeningBalanceException, AccountAlreadyExistException, InsufficientBalanceException, InvalidAccountNumberException {
		Scanner sc=new Scanner(System.in);
		AccountService accountService=new AccountServiceImpl();
		Account account;
		boolean result;
		while(true) {
		System.out.println("------------Welcome to Capgemini Bank----------");
		System.out.println("Press 1 to Create Account");
		System.out.println("Press 2 to Withdraw");
		System.out.println("Press 3 to Exit");

		System.out.println("Enter Choice");
		int choice = sc.nextInt();
		switch(choice) {
			case 1: System.out.println("Enter account number");
					int accountNumber=sc.nextInt();
					System.out.println("Enter amount");
					int amount=sc.nextInt();
					result=accountService.createAccount(accountNumber, amount);
					if (result == true) {
						System.out.println("Account Created Successfully !!!");
						} else {
						System.out.println("Cannot Create Account");
					}
					break;
			case 2: System.out.println("Enter account number");
					int accountNum=sc.nextInt();
					System.out.println("Enter amount to withdraw");
					int withdrawAmount=sc.nextInt();
					account=accountService.withdrawAmount(accountNum, withdrawAmount);
					if(account==null) {
						System.out.println("Account does not exist");
					}
					else {
						System.out.println(account.toString());
					}
					break;
			default: break;
		}
		}
	}

}
