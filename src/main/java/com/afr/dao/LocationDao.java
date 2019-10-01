package com.afr.dao;

import java.util.List;

import com.afr.model.Location;

public interface LocationDao {
	void saveLocation(Location location);
	
	List<Location> findAllLocations();
	
	void deleteLocationByID(int id);
	
	Location findByID(int id);

	void updateLocation(Location location);
}