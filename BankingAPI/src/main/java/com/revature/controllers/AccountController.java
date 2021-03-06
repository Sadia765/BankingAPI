package main.java.com.revature.controllers;

import java.util.List;

import main.java.com.revature.models.Account;
import main.java.com.revature.models.AccountStatus;
import main.java.com.revature.services.AccountService;

public class AccountController {

	private final AccountService as = new AccountService();
	
	//finds all a user's accounts
	public List<Account> findAll(){
		return as.findAll();
	}
	
	//find an account by its id
	public Account findById(int id) {
		return as.findById(id);
	}
	
	//find all accounts with same status
	public List<Account> findByStatus(AccountStatus status){
		return as.findByStatus(status);
	}
	
	//find all accounts for a given user.
	public List<Account> findByUser(int user_fk){
		return as.findByUser(user_fk);
	}
	
	public boolean addAccount(Account a) {
		return as.addAccount(a);
	}
	public boolean updateAccount(Account a) {
		return as.updateAccount(a);
	}
	
	public boolean withdraw(int accountId, double amount) {
		return as.withdraw(accountId, amount);
	}
	public boolean deposit(int accountId, double amount) {
		return as.deposit(accountId, amount);
	}
	public boolean transfer(int sourceAccountId, int targetAccountId, double amount) {
		return as.transfer(sourceAccountId, targetAccountId, amount);
	}
	
	
	
}
