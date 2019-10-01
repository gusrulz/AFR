package com.afr.service;

import java.util.List;

import com.afr.model.Role;
import com.afr.model.UserRole;

public interface UserRoleService {
	void saveUserRole(UserRole userRole);
	
	void deleteUserRoleByID(int id);
	
	List<UserRole> findUserRolesByRole(Role role);
	
	List<UserRole> findUserRolesByRoles(List<Role> roles);
}
