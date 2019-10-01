package com.afr.web.controller.responses;

import java.util.Map;

import com.afr.model.Location;

public class LocationJsonResponse {
   private Location location;
   private boolean validated;
   private Map<String, String> errorMessages;
   
   public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
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