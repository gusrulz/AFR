package com.afr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.afr.model.Driver;

@Repository("driverDao")
public class DriverDaoImpl extends AbstractDao implements DriverDao {

	@Override
	public void saveDriver(Driver driver) {
		persist(driver);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Driver> findAllDrivers() {
		Criteria criteria = getSession().createCriteria(Driver.class);
		criteria.addOrder(Order.asc("name"));
		return (List<Driver>)criteria.list();
	}

	@Override
	public void deleteDriverByID(int id) {
		Query query = getSession().createSQLQuery("delete from Driver where id = :id");
		query.setLong("id", id);
		query.executeUpdate();
	}

	@Override
	public Driver findByID(int id) {
		Criteria criteria = getSession().createCriteria(Driver.class);
		criteria.add(Restrictions.eq("id", id));
		return (Driver)criteria.uniqueResult();
	}

	@Override
	public void updateDriver(Driver driver) {
		getSession().update(driver);
	}
}