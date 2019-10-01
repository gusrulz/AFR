package com.afr.web.controller.validator;

import java.util.HashMap;
import java.util.Map;

import com.afr.exceptions.JsonValidationException;
import com.afr.web.controller.request.ResultJsonRequest;

public class ResultRequestValidator {
	
	public static void validate(ResultJsonRequest json) throws JsonValidationException {
		Map<String, String> errors = new HashMap<String, String>();
		Boolean valid = true;
		
		if (json.getRaceId() == null)
			errors.put("raceId", "Is null");
		
		if (json.getResults() == null) 
			errors.put("results", "Is null");
		
		if (!valid) {
			JsonValidationException e = new JsonValidationException();
			e.setValidationErrors(errors);
			throw e;
		}
	}
}
