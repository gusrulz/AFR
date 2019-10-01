package com.afr.dao;

import java.util.List;

import com.afr.model.Race;

public interface RaceDao {
	void saveRace(Race race);
	
	List<Race> findAllRaces();
	
	void deleteRaceByID(int id);
	
	Race findByID(int id);

	void updateRace(Race race);
	
	Race getNextRace();
	
	Race getLastRace();
}