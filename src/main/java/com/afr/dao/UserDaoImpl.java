package com.afr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.afr.dao.AbstractDao;
import com.afr.model.User;


@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao {

	public void saveUser(User user) {
		persist(user);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria = getSession().createCriteria(User.class);
		return (List<User>)criteria.list();
	}

	public void deleteUserByID(int id) {
		Query query = getSession().createSQLQuery("delete from User where id = :id");
		query.setLong("id", id);
		query.executeUpdate();
	}

	public User findByID(int id) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("id", id));
		return (User)criteria.uniqueResult();
	}
	
	public void updateUser(User user) {
		getSession().update(user);
	}
}