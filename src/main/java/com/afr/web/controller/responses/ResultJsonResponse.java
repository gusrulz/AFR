package com.afr.web.controller.responses;

import java.util.List;
import java.util.Map;

import com.afr.model.Result;

public class ResultJsonResponse {
   private List<Result> results;
   private boolean validated;
   private Map<String, String> errorMessages;
   
   public List<Result> getResults() {
		return results;
	}
	public void setResults(List<Result> results) {
		this.results = results;
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