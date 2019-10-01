package com.afr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.afr.dao.ResultDao;
import com.afr.model.Race;
import com.afr.model.Result;

@Service("resultService")
@Transactional
public class ResultServiceImpl implements ResultService {
	@Autowired
	private ResultDao dao;
	
	@Override
	public void saveResult(Result result) {
		dao.saveResult(result);
	}

	@Override
	public List<Result> findAllResults() {
		return dao.findAllResults();
	}

	@Override
	public void deleteResultByID(int id) {
		dao.deleteResultByID(id);
	}

	@Override
	public Result findByID(int id) {
		return dao.findByID(id);
	}

	@Override
	public void updateResult(Result result) {
		dao.updateResult(result);
	}
	
	@Override
	public List<Result> findResultsByRace(Race race) {
		return dao.findResultsByRace(race);
	}
}