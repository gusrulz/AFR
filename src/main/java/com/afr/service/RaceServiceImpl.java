package com.afr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.afr.dao.RaceDao;
import com.afr.model.Race;

@Service("raceService")
@Transactional
public class RaceServiceImpl implements RaceService {
	@Autowired RaceDao dao;
	
	@Override
	public void saveRace(Race race) {
		dao.saveRace(race);
	}

	@Override
	public List<Race> findAllRaces() {
		return dao.findAllRaces();
	}

	@Override
	public void deleteRaceByID(int id) {
		dao.deleteRaceByID(id);
	}

	@Override
	public Race findByID(int id) {
		return dao.findByID(id);
	}

	@Override
	public void updateRace(Race race) {
		dao.updateRace(race);
	}
	
	@Override
	public Race getNextRace() {
		return dao.getNextRace();
	}
	
	@Override
	public Race getLastRace() {
		return dao.getLastRace();
	}
}