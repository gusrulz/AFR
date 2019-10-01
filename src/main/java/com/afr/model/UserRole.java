package com.afr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userrole")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="user_id", nullable = false)
	private User user;
	
	@ManyToOne()
	@JoinColumn(name="role_id", nullable = false)
	private Role role;

	public UserRole() {
		
	}
	
	public UserRole(User user, Role role) {
		this.user = user;
		this.role = role;
	}
	
	public User getUser() {
		return user;
	}

	public Role getRole() {
		return role;
	}
}
