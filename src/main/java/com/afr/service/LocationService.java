package com.afr.service;

import java.util.List;

import com.afr.model.Location;

public interface LocationService {
	void saveLocation(Location location);
	
	List<Location> findAllLocations();
	
	void deleteLocationByID(int id);
	
	Location findByID(int id);
	
	void updateLocation(Location location);
}
