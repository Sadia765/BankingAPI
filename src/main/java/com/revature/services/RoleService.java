package com.revature.services;

import com.revature.models.Role;
import com.revature.repos.IRoleDAO;
import com.revature.repos.RoleDAO;

public class RoleService {

	IRoleDAO rdao = new RoleDAO();
	
	public Role findByRoleId(int roleId) {

		return rdao.findByRoleId(roleId);
	}

}
