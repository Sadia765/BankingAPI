package main.java.com.revature.services;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.com.revature.models.LoginDTO;
import main.java.com.revature.models.User;
import main.java.com.revature.models.UserDTO;
import main.java.com.revature.repos.IUserDAO;
import main.java.com.revature.repos.UserDAO;

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
