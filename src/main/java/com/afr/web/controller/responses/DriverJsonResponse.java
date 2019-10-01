package com.afr.web.controller.responses;

import java.util.Map;

import com.afr.model.Driver;

public class DriverJsonResponse {
   private Driver driver;
   private boolean validated;
   private Map<String, String> errorMessages;
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
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