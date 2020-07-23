package com.revature.services;

import java.util.List;

import com.revature.models.User;
import com.revature.repos.IUserDAO;
import com.revature.repos.UserDAO;

public class UserService {
	
	private final IUserDAO udao = new UserDAO();

	public List<User> findAll() {
		return udao.findAll();
	}

	public User updateUser(User u) {
		return udao.updateUser(u);
	}

	public User addUser(User u) {
		List<User> list = findAll();
		for(User auser: list) {
			if(auser.getUsername().equals(u.getUsername()) || auser.getEmail().equals(u.getEmail())) {
				return null; //usernames should be unique!!
			}
		}
		
		User b = udao.addUser(u);
		System.out.println("User is AS = " + b);
		return b;
	}

	public User findById(int userId) {
		return udao.findById(userId);
	}
}
