package com.afr.dao;

import java.util.List;

import com.afr.model.Role;

public interface RoleDao {
	void saveRole(Role role);
	
	List<Role> findAllRoles();
	
	void deleteRoleByID(int id);
	
	Role findByID(int id);
	
	Role findRoleByCode(String code);
	
	List<Role> findRolesByOrg(String orgCode);

	void updateRole(Role role);
}