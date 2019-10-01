package com.afr.web.controller.responses;

import java.util.Map;

import com.afr.model.Tier;

public class TierJsonResponse {
   private Tier tier;
   private boolean validated;
   private Map<String, String> errorMessages;
   
   public Tier getTier() {
		return tier;
	}
	public void setTier(Tier tier) {
		this.tier = tier;
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