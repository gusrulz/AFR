package com.afr.service;

import java.util.List;

import com.afr.model.Tier;

public interface TierService {
	void saveTier(Tier tier);
	
	List<Tier> findAllTiers();
	
	void deleteTierByID(int id);
	
	Tier findByID(int id);
	
	void updateTier(Tier tier);
}
