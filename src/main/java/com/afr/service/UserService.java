package com.afr.service;

import java.util.List;

import com.afr.model.User;

public interface UserService {
	void saveUser(User user);
	
	List<User> findAllUsers();
	
	List<User> findUsersByRole(String role);
	
	List<User> findUsersByOrg(String org);
	
	void deleteUserByID(int id);
	
	User findByID(int id);
	
	void updateUser(User user);
}