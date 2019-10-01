package com.afr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.afr.dao.LocationDao;
import com.afr.model.Location;

@Service("locationService")
@Transactional
public class LocationServiceImpl implements LocationService {
	@Autowired
	private LocationDao dao;
	
	@Override
	public void saveLocation(Location location) {
		dao.saveLocation(location);
	}

	@Override
	public List<Location> findAllLocations() {
		return dao.findAllLocations();
	}

	@Override
	public void deleteLocationByID(int id) {
		dao.deleteLocationByID(id);
	}

	@Override
	public Location findByID(int id) {
		return dao.findByID(id);
	}

	@Override
	public void updateLocation(Location location) {
		dao.updateLocation(location);
	}
}