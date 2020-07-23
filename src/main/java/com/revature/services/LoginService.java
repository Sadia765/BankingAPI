package com.revature.services;

import java.util.List;

import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.repos.IUserDAO;
import com.revature.repos.UserDAO;

public class LoginService {
	
	private final IUserDAO udao = new UserDAO();

	public User login(LoginDTO l) {
		List<User> list = udao.findAll();
		//System.out.println("All users: " + udao.findAll());
		for(User auser: list) {
			boolean b =auser.getUsername().equals(l.username) && auser.getPassword().equals(l.password);
			//System.out.println("b: "+ b);
			if(b) {
				//System.out.println("auser is "+auser);
				return auser; //user whose username and password are that of l.
			}
		}

		return null;
	}

}
