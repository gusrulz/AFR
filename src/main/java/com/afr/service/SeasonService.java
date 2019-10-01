package com.afr.service;

import java.util.List;

import com.afr.model.Season;

public interface SeasonService {
	void saveSeason(Season season);
	
	List<Season> findAllSeasons();
	
	void deleteSeasonByID(int id);
	
	Season findByID(int id);
	
	void updateSeason(Season season);
}
