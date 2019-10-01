package com.afr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.afr.dao.UserDao;
import com.afr.model.Role;
import com.afr.model.User;
import com.afr.model.UserRole;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private RoleService roleService; 
	
	@Autowired
	public UserServiceImpl() {
		
	}
	
	public void saveUser(User user) {
		userDao.saveUser(user);
	}
	
	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}
	
	public List<User> findUsersByRole(String roleCode) {
		Role role = roleService.findRoleByCode(roleCode);
		List<UserRole> userRoles = userRoleService.findUserRolesByRole(role);
		List<User> users = new ArrayList<User>();
		for (UserRole userRole : userRoles) {
			users.add(userRole.getUser());
		}
		return users;
	}
	
	public List<User> findUsersByOrg(String orgCode) {
		List<Role> roles = roleService.findRolesByOrg(orgCode);
		List<UserRole> userRoles = userRoleService.findUserRolesByRoles(roles);
		List<User> users = new ArrayList<User>();
		for (UserRole userRole : userRoles) {
			if (!users.contains(userRole.getUser()))
				users.add(userRole.getUser());
		}
		return users;
	}
	
	public void deleteUserByID(int id) {
		userDao.deleteUserByID(id);
	}
	
	public User findByID(int id) {
		return userDao.findByID(id);
	}
	
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
}