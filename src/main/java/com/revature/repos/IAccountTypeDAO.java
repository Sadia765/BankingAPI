package com.revature.repos;

import com.revature.models.AccountType;
import com.revature.models.User;

public interface IAccountTypeDAO {
	public AccountType findById(int typeId);
}
