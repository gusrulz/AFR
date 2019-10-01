package com.afr.web.controller.validator;

import java.util.HashMap;
import java.util.Map;

import com.afr.exceptions.JsonValidationException;
import com.afr.web.controller.request.TeamJsonRequest;

public class TeamRequestValidator {
	
	public static void validate(TeamJsonRequest json) throws JsonValidationException {
		Map<String, String> errors = new HashMap<String, String>();
		Boolean valid = true;
		
		if (json.getName() == null || json.getName().length() == 0) 
			errors.put("name", "Is null or empty");
		
		if (json.getColour() == null || json.getColour().length() == 0)
			errors.put("colour", "Is null or empty");
		
		if (json.getCar() == null || json.getCar().length() == 0)
			errors.put("car", "Is null or empty");
		
		if (json.getLogo() == null || json.getLogo().length() == 0)
			errors.put("logo", "Is null or empty");
		
		if (!errors.isEmpty())
			valid = false;
		
		if (!valid) {
			JsonValidationException e = new JsonValidationException();
			e.setValidationErrors(errors);
			throw e;
		}
	}
}
