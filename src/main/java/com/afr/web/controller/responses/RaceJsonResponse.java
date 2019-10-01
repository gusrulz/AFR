package com.afr.web.controller.responses;

import java.util.Map;

import com.afr.model.Race;

public class RaceJsonResponse {
   private Race race;
   private boolean validated;
   private Map<String, String> errorMessages;
   
   public Race getRace() {
		return race;
	}
	public void setRace(Race race) {
		this.race = race;
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