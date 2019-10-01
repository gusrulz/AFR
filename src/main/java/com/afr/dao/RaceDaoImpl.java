package com.afr.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.afr.model.Race;

@Repository("raceDao")
public class RaceDaoImpl extends AbstractDao implements RaceDao {

	@Override
	public void saveRace(Race race) {
		persist(race);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Race> findAllRaces() {
		Criteria criteria = getSession().createCriteria(Race.class);
		return (List<Race>)criteria.list();
	}

	@Override
	public void deleteRaceByID(int id) {
		Query query = getSession().createSQLQuery("delete from Race where id = :id");
		query.setLong("id", id);
		query.executeUpdate();
	}

	@Override
	public Race findByID(int id) {
		Criteria criteria = getSession().createCriteria(Race.class);
		criteria.add(Restrictions.eq("id", id));
		
		return (Race)criteria.uniqueResult();
	}

	@Override
	public void updateRace(Race race) {
		getSession().update(race);
	}
	
	@Override
	public Race getNextRace() {
		Criteria criteria = getSession().createCriteria(Race.class);
		criteria.add(Restrictions.gt("date", new Date()));
		criteria.addOrder(Order.asc("date"));
		
		return (Race)criteria.list().get(0);
	}

	@Override
	public Race getLastRace() {
		Criteria criteria = getSession().createCriteria(Race.class);
		criteria.add(Restrictions.lt("date", new Date()));
		criteria.addOrder(Order.desc("date"));
		
		return (Race)criteria.list().get(0);
	}
}
