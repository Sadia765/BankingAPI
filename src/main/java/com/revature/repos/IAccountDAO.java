package com.revature.repos;

import java.util.List;

import com.revature.models.Account;
import com.revature.models.AccountStatus;

public interface IAccountDAO {

	public List<Account> findAll(); //finds all a user's accounts
	public Account findById(int id); //find an account by its id
	public List<Account> findByStatus(AccountStatus status); //find all accounts with same status
	public List<Account> findByUser(int user_fk); //find all accounts for a given user.
	
	public boolean addAccount(Account a); 
	public boolean updateAccount(Account a);
	
	public boolean withdraw(int accountId, double amount);
	public boolean deposit(int accountId, double amount);
	public boolean transfer(int sourceAccountId, int targetAccountId, double amount);
	
	
}
