package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controllers.AccountController;
import com.revature.controllers.AccountStatusController;
import com.revature.controllers.AccountTypeController;
import com.revature.controllers.LoginController;
import com.revature.controllers.RoleController;
import com.revature.controllers.UserController;
import com.revature.models.Account;
import com.revature.models.AccountDTO;
import com.revature.models.Role;
import com.revature.models.WithdrawDepositDTO;
import com.revature.models.TransferDTO;
import com.revature.models.User;
import com.revature.models.UserDTO;

public class MasterServlet extends HttpServlet {

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
		// set default to 200, OK.
		res.setStatus(200);

		final String URI = req.getRequestURI().replace("/rocp-project/", "");

		String[] portions = URI.split("/");

		System.out.println(Arrays.toString(portions));

		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		//set default to 200, OK.
		res.setStatus(200);

		final String URI = req.getRequestURI().replace("/rocp-project/", "");
		
		String[] portions = URI.split("/");

		System.out.println(Arrays.toString(portions));
		
		try {
			System.out.println(portions[0]);
			switch(portions[0]) {
			case "register":
				System.out.println("In POST for register");
				HttpSession ses = req.getSession(false);
				if (ses != null && ((Boolean) ses.getAttribute("loggedin"))) {					
					if(ses.getAttribute("userRole").equals("Admin")) {
						System.out.println("you are an Admin!");
						BufferedReader reader = req.getReader();

						StringBuilder s = new StringBuilder();

						String line = reader.readLine();

						while (line != null) {
							s.append(line);
							line = reader.readLine();
						}

						String body = new String(s);

						System.out.println(body);
						User u = om.readValue(body, User.class);
						
						

						
						
						if(uc.addUser(u)) {
							System.out.println("let's add this user!");
							u.setUserId(uc.findAll().size());
						}
						String newUser = om.writeValueAsString(u);
						//User currentUser = om.readValue(ls.login(l), UserDTO.class);
						//res.getWriter().println(currentUser);//ls.login(l));
						res.getWriter().println(newUser);
//						res.getWriter().println(u);
						res.setStatus(201);
					}
					else {//You don't have Admin privileges, so you can't register a user.
						res.setStatus(401);
						res.getWriter().println("Invalid fields");
					}
				}
				else {
					res.setStatus(401);
					res.getWriter().println("You must be logged in to do that!");
				}
				break;
				
		
			case "accounts":
//				HttpSession
				ses = req.getSession(false);
				if (ses != null && ((Boolean) ses.getAttribute("loggedin"))) {
					
					BufferedReader reader = req.getReader();

					StringBuilder s = new StringBuilder();

					String line = reader.readLine();

					while (line != null) {
						s.append(line);
						line = reader.readLine();
					}

					String body = new String(s);
					System.out.println(body);
//					ses.getAttribute("userId");
					if(portions.length == 2) {
						if(portions[1].equals("withdraw")) {
							System.out.println("In doPost withdraw section to remove money!");
							WithdrawDepositDTO wdDTO = om.readValue(body, WithdrawDepositDTO.class);
							double toMove = wdDTO.amount;
							int accountId = wdDTO.accountId;							
							if((ses.getAttribute("userRole").equals("Admin")) || (ses.getAttribute("userId").equals(ac.findById(accountId).getUser_fk()))) {
								ac.withdraw(accountId, toMove);
								res.getWriter().println("$"+ toMove + " has been withdrawn from Account #"+accountId);
							}
							else {//not authorized
								res.setStatus(403);
								res.getWriter().println("Sorry, based on your credentials, you do not have the ability to withdraw $ " + toMove + " into Account #" + accountId +".");
							}
																
						}
						else if(portions[1].equals("deposit")) {
							System.out.println("In doPost deposit section to add money!");
							WithdrawDepositDTO wdDTO = om.readValue(body, WithdrawDepositDTO.class);
							double toMove = wdDTO.amount;
							int accountId = wdDTO.accountId;
							if((ses.getAttribute("userRole").equals("Admin")) || (ses.getAttribute("userId")).equals(ac.findById(accountId).getUser_fk())) {
//								should the above be .equals?? because that is what I used for transfer...
								ac.deposit(accountId, toMove);
								res.getWriter().println("$"+ toMove + " has been deposited to Account #"+accountId +".");
							}
//							res.getWriter().println();
							else {//not authorized
								res.setStatus(403);
								res.getWriter().println("Sorry, based on your credentials, you do not have the ability to deposit $ " + toMove + " into Account #" + accountId);
							}
						}
						
						else if(portions[1].equals("transfer")) {
							TransferDTO transferDTO = om.readValue(body, TransferDTO.class);
							int sourceAccountId = transferDTO.sourceAccountId;
							int targetAccountId = transferDTO.targetAccountId;
							double toTransfer = transferDTO.amount;
							System.out.println("In doPost transfer section !");
							
							if((ses.getAttribute("userRole").equals("Admin")) || (ses.getAttribute("userId")).equals(ac.findById(sourceAccountId).getUser_fk())) {
								ac.transfer(sourceAccountId, targetAccountId, toTransfer);
								res.getWriter().println("$"+ toTransfer + " has been transferred from Account #"+sourceAccountId+" to Account #"+targetAccountId);
							}
							else {//not authorized
								res.setStatus(403);
								res.getWriter().println("Sorry, based on your credentials, you do not have the ability to transfer $ " + toTransfer + " from Account #" + sourceAccountId +
										" to Account #"	+ targetAccountId);
							}
							
							
						}
						else {//not authorized
							res.setStatus(401);
							res.getWriter().println("Invalid fields");
						}

					}
					
					
					else { //add new user
						AccountDTO accountDTO = om.readValue(body, AccountDTO.class);
						int userId = accountDTO.user_fk;
						System.out.println("The userId is " + userId);
						if((ses.getAttribute("userRole") == "Admin") || (ses.getAttribute("userRole") == "Employee")||
								(ses.getAttribute("userId")).equals(userId)){//len is one and is accounts
							System.out.println("The user either wants to open their own account or is an Admin or Employee");
							Account account = om.readValue(body, Account.class);
							if(ac.addAccount(account)) {
								res.setStatus(201);
								account.setAccountId(ac.findAll().size());
								
							}
							String newAccount = om.writeValueAsString(account);
							res.getWriter().println(newAccount);
						}
						else {//not authorized
							res.setStatus(401);
							res.getWriter().println("Invalid fields");
						}
						
					}
							
				
				}
				else {
					res.setStatus(401);
					res.getWriter().println("You must be logged in to do that!");
				}
				break;
	
			case "login":
				lc.login(req,res);
				//String json = om.writeValueAsString(lc.login(req,res));
				//res.getWriter().println(json);
				break;
			case "logout":
				lc.logout(req,res);
			}
		}catch(NumberFormatException e)	{
			e.printStackTrace();
			res.getWriter().println("The id you provided is not an integer");
			res.setStatus(400);
		}

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
