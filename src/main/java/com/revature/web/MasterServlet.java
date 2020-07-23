package com.revature.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controllers.AccountController;
import com.revature.controllers.AccountStatusController;
import com.revature.controllers.AccountTypeController;
import com.revature.controllers.LoginController;
import com.revature.controllers.RoleController;
import com.revature.controllers.UserController;

public class MasterServlet extends HttpServlet{

	private static final ObjectMapper om = new ObjectMapper();
	private static final AccountController ac = new AccountController();
	
	private static final AccountStatusController asc = new AccountStatusController();
	private static final AccountTypeController atc = new AccountTypeController();
	
	private static final RoleController rc = new RoleController();
	private static final UserController uc = new UserController();
	
	private static final LoginController lc = new LoginController();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		//set default to 200, OK.
		res.setStatus(200);

		final String URI = req.getRequestURI().replace("/rocp-project/", "");
		
		String[] portions = URI.split("/");

		System.out.println(Arrays.toString(portions));
		
		try {
			switch(portions[0]) {
			case "login":
				lc.login(req,res);
				//String json = om.writeValueAsString(lc.login(req,res));
				//res.getWriter().println(json);
				break;
			case "logout":
				lc.logout(req,res);
			
			
			}
			
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
			res.getWriter().println("The id you provided is not an integer");
			res.setStatus(400);
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	

		
		
		
		doGet(req, res);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	

		
		
		
		
		doGet(req, res);
	}

}
