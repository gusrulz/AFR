package com.afr.web.controller.validator;

import java.util.HashMap;
import java.util.Map;

import com.afr.exceptions.JsonValidationException;
import com.afr.web.controller.request.LocationJsonRequest;

public class LocationRequestValidator {
	
	public static void validate(LocationJsonRequest json) throws JsonValidationException {
		Map<String, String> errors = new HashMap<String, String>();
		Boolean valid = true;
		
		if (json.getName() == null || json.getName().length() == 0) 
			errors.put("name", "Is null or empty");
		
		if (json.getAltName() == null || json.getAltName().length() == 0)
			errors.put("altName", "Is null or empty");
		
		if (json.getMap() == null || json.getMap().length() == 0)
			errors.put("map", "Is null or empty");
		
		if (!errors.isEmpty())
			valid = false;
		
		if (!valid) {
			JsonValidationException e = new JsonValidationException();
			e.setValidationErrors(errors);
			throw e;
		}
	}
}
