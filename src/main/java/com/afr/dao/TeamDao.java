package com.afr.dao;

import java.util.List;

import com.afr.model.Team;

public interface TeamDao {
	void saveTeam(Team team);
	
	List<Team> findAllTeams();
	
	void deleteTeamByID(int id);
	
	Team findByID(int id);

	void updateTeam(Team team);
}