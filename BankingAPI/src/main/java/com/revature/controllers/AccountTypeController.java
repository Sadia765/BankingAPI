package main.java.com.revature.controllers;

import main.java.com.revature.models.AccountType;
import main.java.com.revature.services.AccountTypeService;

public class AccountTypeController {

	private final AccountTypeService ats = new AccountTypeService();
	
	public AccountType findById(int typeId) {
		return ats.findById(typeId);
	}
	
}
