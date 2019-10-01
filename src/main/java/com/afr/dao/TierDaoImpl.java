package com.afr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.afr.model.Tier;

@Repository("tierDao")
public class TierDaoImpl extends AbstractDao implements TierDao {

	@Override
	public void saveTier(Tier tier) {
		persist(tier);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tier> findAllTiers() {
		Criteria criteria = getSession().createCriteria(Tier.class);
		criteria.addOrder(Order.asc("name"));
		return (List<Tier>)criteria.list();
	}

	@Override
	public void deleteTierByID(int id) {
		Query query = getSession().createSQLQuery("delete from Tier where id = :id");
		query.setLong("id", id);
		query.executeUpdate();
	}

	@Override
	public Tier findByID(int id) {
		Criteria criteria = getSession().createCriteria(Tier.class);
		criteria.add(Restrictions.eq("id", id));
		return (Tier)criteria.uniqueResult();
	}

	@Override
	public void updateTier(Tier tier) {
		getSession().update(tier);
	}
}