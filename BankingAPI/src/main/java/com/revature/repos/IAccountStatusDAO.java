package main.java.com.revature.repos;

import main.java.com.revature.models.AccountStatus;

public interface IAccountStatusDAO {
	public AccountStatus findById(int statusId);
}
