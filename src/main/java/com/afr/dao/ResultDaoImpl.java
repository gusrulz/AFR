package com.afr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.afr.model.Race;
import com.afr.model.Result;

@Repository("resultDao")
public class ResultDaoImpl extends AbstractDao implements ResultDao {

	@Override
	public void saveResult(Result result) {
		persist(result);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Result> findAllResults() {
		Criteria criteria = getSession().createCriteria(Result.class);
		return (List<Result>)criteria.list();
	}

	@Override
	public void deleteResultByID(int id) {
		Query query = getSession().createSQLQuery("delete from Result where id = :id");
		query.setLong("id", id);
		query.executeUpdate();
	}

	@Override
	public Result findByID(int id) {
		Criteria criteria = getSession().createCriteria(Result.class);
		criteria.add(Restrictions.eq("id", id));
		return (Result)criteria.uniqueResult();
	}

	@Override
	public void updateResult(Result result) {
		getSession().update(result);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Result> findResultsByRace(Race race) {
		Criteria criteria = getSession().createCriteria(Result.class);
		criteria.add(Restrictions.eq("race", race));
		criteria.addOrder(Order.desc("points"));
		
		return (List<Result>)criteria.list();
	}

}
