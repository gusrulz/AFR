package com.afr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.afr.dao.UserRoleDao;
import com.afr.model.Role;
import com.afr.model.UserRole;

@Service("userRoleService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	private UserRoleDao dao;
	
	public void saveUserRole(UserRole userRole) {
		dao.saveUserRole(userRole);
	}

	public void deleteUserRoleByID(int id) {
		dao.deleteUserRoleByID(id);
	}

	public List<UserRole> findUserRolesByRole(Role role) {
		return dao.findUserRolesByRole(role);
	}
	
	public List<UserRole> findUserRolesByRoles(List<Role> roles) {
		return dao.findUserRolesByRoles(roles);
	}
}
