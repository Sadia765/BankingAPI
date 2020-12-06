package main.java.com.revature.services;

import main.java.com.revature.models.AccountStatus;
import main.java.com.revature.repos.AccountStatusDAO;
import main.java.com.revature.repos.IAccountStatusDAO;

public class AccountStatusService {

	private final IAccountStatusDAO asdao = new AccountStatusDAO();
	
	public AccountStatus findById(int statusId) {
		return asdao.findById(statusId);
	}
}
