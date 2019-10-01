package com.afr.web.controller.request;

import java.util.List;
import java.util.Map;

public class ResultJsonRequest {
	private List<Map<String, String>> results;
	private String raceId;

	public List<Map<String, String>> getResults() {
		return this.results;
	}
	
	public void setResults(List<Map<String, String>> results) {
		this.results = results;
	}

	public String getRaceId() {
		return raceId;
	}

	public void setRaceId(String raceId) {
		this.raceId = raceId;
	}
}