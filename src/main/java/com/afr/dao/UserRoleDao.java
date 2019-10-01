package com.afr.dao;

import java.util.List;

import com.afr.model.Role;
import com.afr.model.UserRole;

public interface UserRoleDao {
	List<UserRole> findUserRolesByRole(Role role);
	
	List<UserRole> findUserRolesByRoles(List<Role> roles);
	
	void saveUserRole(UserRole userRole);
	
	void deleteUserRoleByID(int id);
	
	UserRole findUserRoleByID(int id);
}