package com.afr.web.controller.responses;

import java.util.Map;

import com.afr.model.Team;

public class TeamJsonResponse {
   private Team team;
   private boolean validated;
   private Map<String, String> errorMessages;
   
   public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
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