package com.afr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.afr.dao.SeasonDao;
import com.afr.model.Season;

@Service("seasonService")
@Transactional
public class SeasonServiceImpl implements SeasonService {
	@Autowired
	private SeasonDao dao;
	
	@Override
	public void saveSeason(Season season) {
		dao.saveDriver(season);
	}

	@Override
	public List<Season> findAllSeasons() {
		return dao.findAllSeasons();
	}

	@Override
	public void deleteSeasonByID(int id) {
		dao.deleteSeasonByID(id);
	}

	@Override
	public Season findByID(int id) {
		return dao.findByID(id);
	}

	@Override
	public void updateSeason(Season season) {
		dao.updateSeason(season);
	}
}