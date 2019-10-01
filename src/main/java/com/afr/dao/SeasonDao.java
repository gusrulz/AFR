package com.afr.dao;

import java.util.List;

import com.afr.model.Season;

public interface SeasonDao {
	void saveDriver(Season season);
	
	List<Season> findAllSeasons();
	
	void deleteSeasonByID(int id);
	
	Season findByID(int id);

	void updateSeason(Season season);
}