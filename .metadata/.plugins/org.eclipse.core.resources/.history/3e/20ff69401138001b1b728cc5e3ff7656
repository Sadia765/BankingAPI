package com.revature.services;

import com.revature.models.AccountStatus;
import com.revature.repos.AccountStatusDAO;
import com.revature.repos.IAccountStatusDAO;

public class AccountStatusService {

	private final IAccountStatusDAO asdao = new AccountStatusDAO();
	
	public AccountStatus findById(int statusId) {
		return asdao.findById(statusId);
	}
}
