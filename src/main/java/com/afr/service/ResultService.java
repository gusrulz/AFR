package com.afr.service;

import java.util.List;

import com.afr.model.Race;
import com.afr.model.Result;

public interface ResultService {
	void saveResult(Result result);
	
	List<Result> findAllResults();
	
	void deleteResultByID(int id);
	
	Result findByID(int id);
	
	void updateResult(Result result);
	
	List<Result> findResultsByRace(Race race);
}
