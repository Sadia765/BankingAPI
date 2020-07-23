package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.LoginDTO;
import com.revature.services.LoginService;

public class LoginController {

	private static final LoginService ls = new LoginService();
	private static final ObjectMapper om = new ObjectMapper();
	
	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException{
		if(req.getMethod().equals("POST")) {
			System.out.println("In POST for login");
			BufferedReader reader = req.getReader();
			
			StringBuilder  s = new StringBuilder();
			
			String line = reader.readLine();
			
			while(line != null) {
				s.append(line);
				line = reader.readLine();
			}
			
			String body = new String(s);
			
			System.out.println(body);
			
			LoginDTO l = om.readValue(body, LoginDTO.class);
			//System.out.println("ls(login(l) returns " + ls.login(l));
			if(ls.login(l) != null) {
				
				HttpSession ses = req.getSession();
				ses.setAttribute("user", l);
				ses.setAttribute("loggedin", true);
				res.setStatus(200);
				res.getWriter().println(ls.login(l));
			}
			else {
				//will only return a session if one is already associated with the request, will not create a new one. 				
				HttpSession ses = req.getSession(false);
				
				if(ses != null) {
					ses.invalidate();
				}
				res.setStatus(400);
				res.getWriter().println("Invalid Credentials");
			}
	
		}
		else if(req.getMethod().equals("GET") && (req.getParameterMap().containsKey("username") && (req.getParameterMap().containsKey("password")))) {
			LoginDTO l = new LoginDTO();
			l.username = req.getParameter("username");
			l.password = req.getParameter("password");
			
			if(ls.login(l) != null) {
				
				HttpSession ses = req.getSession();
				ses.setAttribute("user", l);
				ses.setAttribute("loggedin", true);
				res.setStatus(200);
				res.getWriter().println(ls.login(l));
				
			}
			else {
				
				HttpSession ses = req.getSession(false);
				
				if(ses!=null) {
					ses.invalidate();
				}
				res.setStatus(400);
				res.getWriter().println("Invalid Credentials");
			}
			
		}
	}
	
	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession ses = req.getSession(false);
		
		if(ses != null) {
			LoginDTO l = (LoginDTO) ses.getAttribute("user");
			ses.invalidate();
			res.setStatus(200);
			
			res.getWriter().println("You have successfully logged out "+l.username);
		}
		else {
			res.setStatus(400);
			res.getWriter().println("There was no user logged into the session");
		}
		
	}
	
	
	
}
