package com.afr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.afr.dao.DriverDao;
import com.afr.model.Driver;

@Service("driverService")
@Transactional
public class DriverServiceImpl implements DriverService {
	@Autowired
	private DriverDao dao;
	
	@Override
	public void saveDriver(Driver driver) {
		dao.saveDriver(driver);
	}

	@Override
	public List<Driver> findAllDrivers() {
		return dao.findAllDrivers();
	}

	@Override
	public void deleteDriverByID(int id) {
		dao.deleteDriverByID(id);
	}

	@Override
	public Driver findByID(int id) {
		return dao.findByID(id);
	}

	@Override
	public void updateDriver(Driver driver) {
		dao.updateDriver(driver);
	}
}