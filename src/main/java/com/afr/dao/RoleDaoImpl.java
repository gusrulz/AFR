package com.afr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.afr.dao.AbstractDao;
import com.afr.model.Role;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao implements RoleDao {

	public void saveRole(Role role) {
		persist(role);
	}

	@SuppressWarnings("unchecked")
	public List<Role> findAllRoles() {
		Criteria criteria = getSession().createCriteria(Role.class);
		return (List<Role>)criteria.list();
	}

	public void deleteRoleByID(int id) {
		Query query = getSession().createSQLQuery("delete from Role where id = :id");
		query.setLong("id", id);
		query.executeUpdate();
	}

	public Role findByID(int id) {
		Criteria criteria = getSession().createCriteria(Role.class);
		criteria.add(Restrictions.eq("id", id));
		return (Role)criteria.uniqueResult();
	}
	
	public Role findRoleByCode(String code) {
		Criteria criteria = getSession().createCriteria(Role.class);
		criteria.add(Restrictions.eq("code", code));
		return (Role)criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Role> findRolesByOrg(String orgCode) {
		Criteria criteria = getSession().createCriteria(Role.class);
		criteria.add(Restrictions.like("code", orgCode, MatchMode.START));
		return (List<Role>)criteria.list();
	}

	public void updateRole(Role role) {
		getSession().update(role);
	}
}
