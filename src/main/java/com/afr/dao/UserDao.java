package com.afr.dao;

import java.util.List;

import com.afr.model.User;

public interface UserDao {
	void saveUser(User user);
	
	List<User> findAllUsers();
	
	void deleteUserByID(int id);
	
	User findByID(int id);

	void updateUser(User user);
}