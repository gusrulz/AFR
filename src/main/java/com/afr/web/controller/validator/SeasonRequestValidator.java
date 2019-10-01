package com.afr.web.controller.validator;

import java.util.HashMap;
import java.util.Map;

import com.afr.exceptions.JsonValidationException;
import com.afr.web.controller.request.SeasonJsonRequest;

public class SeasonRequestValidator {
	
	public static void validate(SeasonJsonRequest json) throws JsonValidationException {
		Map<String, String> errors = new HashMap<String, String>();
		Boolean valid = true;
		
		if (json.getNumber() == null || json.getNumber().length() == 0) 
			errors.put("number", "Is null or empty");
		
		if (json.getGame() == null || json.getGame().length() == 0) 
			errors.put("game", "Is null or empty");
		
		if (json.getTierId() == null || json.getTierId().length() == 0) 
			errors.put("tier", "Is null or empty");
		
		if (!errors.isEmpty())
			valid = false;
		
		if (!valid) {
			JsonValidationException e = new JsonValidationException();
			e.setValidationErrors(errors);
			throw e;
		}
	}
}
