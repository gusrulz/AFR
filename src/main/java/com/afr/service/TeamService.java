package com.afr.service;

import java.util.List;

import com.afr.model.Team;

public interface TeamService {
	void saveTeam(Team team);
	
	List<Team> findAllTeams();
	
	void deleteTeamByID(int id);
	
	Team findByID(int id);
	
	void updateTeam(Team team);
}
