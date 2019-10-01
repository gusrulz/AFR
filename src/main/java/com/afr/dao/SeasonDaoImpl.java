package com.afr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.afr.model.Season;

@Repository("seasonDao")
public class SeasonDaoImpl extends AbstractDao implements SeasonDao {

	@Override
	public void saveDriver(Season season) {
		persist(season);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Season> findAllSeasons() {
		Criteria criteria = getSession().createCriteria(Season.class);
		criteria.addOrder(Order.asc("number"));
		return (List<Season>)criteria.list();
	}

	@Override
	public void deleteSeasonByID(int id) {
		Query query = getSession().createSQLQuery("delete from Season where id = :id");
		query.setLong("id", id);
		query.executeUpdate();
	}

	@Override
	public Season findByID(int id) {
		Criteria criteria = getSession().createCriteria(Season.class);
		criteria.add(Restrictions.eq("id", id));
		return (Season)criteria.uniqueResult();
	}

	@Override
	public void updateSeason(Season season) {
		getSession().update(season);
	}

}
