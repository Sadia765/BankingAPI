package main.java.com.revature.repos;

import main.java.com.revature.models.AccountType;
import main.java.com.revature.models.User;

public interface IAccountTypeDAO {
	public AccountType findById(int typeId);
}
