package com.revature.services;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.models.UserDTO;
import com.revature.repos.IUserDAO;
import com.revature.repos.UserDAO;

public class LoginService {
	
	private final IUserDAO udao = new UserDAO();
	//private static final ObjectMapper om = new ObjectMapper();

	public User login(LoginDTO l) {
		List<User> list = udao.findAll();
		//System.out.println("All users: " + udao.findAll());ß
		for(User auser: list) {
			boolean b =auser.getUsername().equals(l.username) && auser.getPassword().equals(l.password);
			if(b) {
				
				return auser; //user whose username and password are that of l.
			}
		}

		return null;
	}

}
