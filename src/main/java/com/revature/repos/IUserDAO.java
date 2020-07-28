package com.revature.repos;

import java.util.List;

import com.revature.models.User;

public interface IUserDAO {

	public List<User> findAll();
	public User updateUser(User u);
	public boolean addUser(User u);
	public User findById(int userId);
	
	
}
