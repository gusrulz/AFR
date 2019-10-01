package com.afr.exceptions;

import java.util.Map;

public class JsonValidationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String, String> validationErrors;

	public Map<String, String> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(Map<String, String> validationErrors) {
		this.validationErrors = validationErrors;
	}
}
