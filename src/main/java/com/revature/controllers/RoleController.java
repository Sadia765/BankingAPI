package com.revature.controllers;

import com.revature.models.Role;
import com.revature.services.RoleService;

public class RoleController {

	private final RoleService rs = new RoleService();
	
	public Role findByRoleId(int roleId) {
		return rs.findByRoleId(roleId);
	}
}
