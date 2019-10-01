package com.afr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.afr.model.Location;

@Repository("locationDao")
public class LocationDaoImpl extends AbstractDao implements LocationDao {

	@Override
	public void saveLocation(Location location) {
		persist(location);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> findAllLocations() {
		Criteria criteria = getSession().createCriteria(Location.class);
		criteria.addOrder(Order.asc("name"));
		return (List<Location>)criteria.list();
	}

	@Override
	public void deleteLocationByID(int id) {
		Query query = getSession().createSQLQuery("delete from Location where id = :id");
		query.setLong("id", id);
		query.executeUpdate();
	}

	@Override
	public Location findByID(int id) {
		Criteria criteria = getSession().createCriteria(Location.class);
		criteria.add(Restrictions.eq("id", id));
		return (Location)criteria.uniqueResult();
	}

	@Override
	public void updateLocation(Location location) {
		getSession().update(location);
	}

}
