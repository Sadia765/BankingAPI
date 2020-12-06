package com.revature.services;

import java.util.List;

import com.revature.models.Account;
import com.revature.models.AccountStatus;
import com.revature.repos.AccountDAO;
import com.revature.repos.IAccountDAO;

public class AccountService {

	private final IAccountDAO dao = new AccountDAO();
	
	public List<Account> findAll() {
		return dao.findAll();
	}

	public Account findById(int id) {
		return dao.findById(id);
	}

	public List<Account> findByStatus(AccountStatus status) {
		return dao.findByStatus(status);
	}

	public List<Account> findByUser(int user_fk) {
		return dao.findByUser(user_fk);
	}

	public boolean addAccount(Account a) {
		return dao.addAccount(a);
	}

	public boolean updateAccount(Account a) { //do I implement this only in the dao?
		return dao.updateAccount(a);
	}

	public boolean withdraw(int accountId, double amount) {
		return dao.withdraw(accountId, amount);
	}

	public boolean deposit(int accountId, double amount) {
		return dao.deposit(accountId, amount);
	}

	public boolean transfer(int sourceAccountId, int targetAccountId, double amount) {
		return dao.transfer(sourceAccountId, targetAccountId, amount);
	}


}
