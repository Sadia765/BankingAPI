package main.java.com.revature.services;

import main.java.com.revature.models.AccountType;
import main.java.com.revature.repos.AccountTypeDAO;
import main.java.com.revature.repos.IAccountTypeDAO;

public class AccountTypeService {

	private final IAccountTypeDAO acdao = new AccountTypeDAO();
	public AccountType findById(int typeId) {
		return acdao.findById(typeId);
	}

}
