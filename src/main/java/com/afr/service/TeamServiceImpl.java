package com.afr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.afr.dao.TeamDao;
import com.afr.model.Team;

@Service("teamService")
@Transactional
public class TeamServiceImpl implements TeamService {
	@Autowired
	private TeamDao dao;
	
	@Override
	public void saveTeam(Team team) {
		dao.saveTeam(team);
	}

	@Override
	public List<Team> findAllTeams() {
		return dao.findAllTeams();
	}

	@Override
	public void deleteTeamByID(int id) {
		dao.deleteTeamByID(id);
	}

	@Override
	public Team findByID(int id) {
		return dao.findByID(id);
	}

	@Override
	public void updateTeam(Team team) {
		dao.updateTeam(team);
	}
}