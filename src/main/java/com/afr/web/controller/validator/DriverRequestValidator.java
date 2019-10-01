package com.afr.web.controller.validator;

import java.util.HashMap;
import java.util.Map;

import com.afr.exceptions.JsonValidationException;
import com.afr.web.controller.request.DriverJsonRequest;

public class DriverRequestValidator {
	
	public static void validate(DriverJsonRequest json) throws JsonValidationException {
		Map<String, String> errors = new HashMap<String, String>();
		Boolean valid = true;
		
		if (json.getName() == null || json.getName().length() == 0) 
			errors.put("name", "Is null or empty");
		
		if (json.getNumber() == null || json.getNumber().length() == 0)
			errors.put("number", "Is null or empty");
		
		if (json.getAvatar() == null || json.getAvatar().length() == 0)
			errors.put("avatar", "Is null or empty");
		
		if (!errors.isEmpty())
			valid = false;
		
		if (!valid) {
			JsonValidationException e = new JsonValidationException();
			e.setValidationErrors(errors);
			throw e;
		}
	}
}
