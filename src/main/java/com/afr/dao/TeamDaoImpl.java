package com.afr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.afr.model.Team;

@Repository("teamDao")
public class TeamDaoImpl extends AbstractDao implements TeamDao {

	@Override
	public void saveTeam(Team team) {
		persist(team);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Team> findAllTeams() {
		Criteria criteria = getSession().createCriteria(Team.class);
		criteria.addOrder(Order.asc("name"));
		return (List<Team>)criteria.list();
	}

	@Override
	public void deleteTeamByID(int id) {
		Query query = getSession().createSQLQuery("delete from Team where id = :id");
		query.setLong("id", id);
		query.executeUpdate();
	}

	@Override
	public Team findByID(int id) {
		Criteria criteria = getSession().createCriteria(Team.class);
		criteria.add(Restrictions.eq("id", id));
		return (Team)criteria.uniqueResult();
	}

	@Override
	public void updateTeam(Team team) {
		getSession().update(team);
	}
}