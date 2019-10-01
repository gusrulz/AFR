package com.afr.web.controller.validator;

import java.util.HashMap;
import java.util.Map;

import com.afr.exceptions.JsonValidationException;
import com.afr.web.controller.request.RaceJsonRequest;

public class RaceRequestValidator {
	
	public static void validate(RaceJsonRequest json) throws JsonValidationException {
		Map<String, String> errors = new HashMap<String, String>();
		Boolean valid = true;
		
		if (json.getDate() == null) 
			errors.put("date", "Is null");
		
		if (json.getLocationId() == null || json.getLocationId().length() == 0) 
			errors.put("locationId", "Is null or empty");
		
		if (!errors.isEmpty())
			valid = false;
		
		if (!valid) {
			JsonValidationException e = new JsonValidationException();
			e.setValidationErrors(errors);
			throw e;
		}
	}
}
