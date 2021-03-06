package main.java.com.revature.controllers;

import main.java.com.revature.models.AccountStatus;
import main.java.com.revature.repos.AccountStatusDAO;
import main.java.com.revature.repos.IAccountStatusDAO;
import main.java.com.revature.services.AccountStatusService;

public class AccountStatusController {

	private final AccountStatusService asservice = new AccountStatusService();
	
	public AccountStatus findById(int statusId) {
		return asservice.findById(statusId);
	}
	
}
