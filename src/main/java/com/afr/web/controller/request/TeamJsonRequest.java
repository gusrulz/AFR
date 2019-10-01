package com.afr.web.controller.request;

public class TeamJsonRequest {
	private Integer id;
	private String name;
	private String colour;
	private String car;
	private String logo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}
	
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
}
