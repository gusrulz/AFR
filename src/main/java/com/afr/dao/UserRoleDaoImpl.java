package com.afr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.afr.dao.AbstractDao;
import com.afr.model.Role;
import com.afr.model.UserRole;

@Repository("userRoleDao")
public class UserRoleDaoImpl extends AbstractDao implements UserRoleDao {

	@SuppressWarnings("unchecked")
	public List<UserRole> findUserRolesByRole(Role role) {
		Criteria criteria = getSession().createCriteria(UserRole.class);
		criteria.add(Restrictions.eq("role", role));
		return (List<UserRole>)criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<UserRole> findUserRolesByRoles(List<Role> roles) {
		Criteria criteria = getSession().createCriteria(UserRole.class);
		criteria.add(Restrictions.in("role", roles));
		return (List<UserRole>)criteria.list();
	}

	public void saveUserRole(UserRole userRole) {
		persist(userRole);
	}

	public void deleteUserRoleByID(int id) {
		Query query = getSession().createSQLQuery("delete from UserRole where id = :id");
		query.setLong("id", id);
		query.executeUpdate();
	}

	public UserRole findUserRoleByID(int id) {
		Criteria criteria = getSession().createCriteria(UserRole.class);
		criteria.add(Restrictions.eq("id", id));
		return (UserRole)criteria.uniqueResult();
	}
}
