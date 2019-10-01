package com.afr.web.controller.request;

public class SeasonJsonRequest {
	private Integer id;
	private String number;
	private String game;
	private String tierId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}
	
	public String getTierId() {
		return tierId;
	}

	public void setTierId(String tierId) {
		this.tierId = tierId;
	}
}
