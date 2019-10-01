package com.afr.web.controller.request;

public class LocationJsonRequest {
	private Integer id;
	private String name;
	private String altName;
	private String map;

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
	
	public String getAltName() {
		return altName;
	}

	public void setAltName(String altName) {
		this.altName = altName;
	}
	
	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}
}
