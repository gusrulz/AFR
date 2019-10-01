package com.afr.service;

import java.util.List;

import com.afr.model.Driver;

public interface DriverService {
	void saveDriver(Driver driver);
	
	List<Driver> findAllDrivers();
	
	void deleteDriverByID(int id);
	
	Driver findByID(int id);
	
	void updateDriver(Driver driver);
}
