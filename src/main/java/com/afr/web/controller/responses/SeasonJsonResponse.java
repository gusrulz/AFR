package com.afr.web.controller.responses;

import java.util.Map;

import com.afr.model.Season;

public class SeasonJsonResponse {
   private Season season;
   private boolean validated;
   private Map<String, String> errorMessages;
   
   public Season getSeason() {
		return season;
	}
	public void setSeason(Season season) {
		this.season = season;
	}
	public boolean isValidated() {
		return validated;
	}
	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	public Map<String, String> getErrorMessages() {
		return errorMessages;
	}
	public void setErrorMessages(Map<String, String> errorMessages) {
		this.errorMessages = errorMessages;
	}
}