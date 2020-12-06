package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

public static Connection getConnection() throws SQLException{
		
		try {
			Class.forName("org.postgresql.Driver"); //checks for the location of something.
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//copied from jdbc demo
		String url = "jdbc:postgresql://localhost:5432/bankingapi";
		String username = "postgres";
		String password = "password";
		
		return DriverManager.getConnection(url, username, password);
		
	}
	
}
