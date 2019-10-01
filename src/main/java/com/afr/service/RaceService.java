package com.afr.service;

import java.util.List;

import com.afr.model.Race;

public interface RaceService {
	void saveRace(Race race);
	
	List<Race> findAllRaces();
	
	void deleteRaceByID(int id);
	
	Race findByID(int id);
	
	void updateRace(Race race);
	
	Race getNextRace();
	
	Race getLastRace();
}
