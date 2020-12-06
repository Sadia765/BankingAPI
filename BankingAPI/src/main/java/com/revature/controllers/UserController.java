package main.java.com.revature.controllers;

import java.util.List;

import main.java.com.revature.models.User;
import main.java.com.revature.services.UserService;

public class UserController {

	private final UserService us = new UserService();
	
	public List<User> findAll(){
		return us.findAll();
	}
	public User updateUser(User u) {
		return us.updateUser(u);
	}
	public boolean addUser(User u) {
		return us.addUser(u);
	}
	public User findById(int userId) {
		return us.findById(userId);
	}
	
}