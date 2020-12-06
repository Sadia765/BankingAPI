package main.java.com.revature.services;

import main.java.com.revature.models.Role;
import main.java.com.revature.repos.IRoleDAO;
import main.java.com.revature.repos.RoleDAO;

public class RoleService {

	IRoleDAO rdao = new RoleDAO();
	
	public Role findByRoleId(int roleId) {

		return rdao.findByRoleId(roleId);
	}

}
