package com.afr.model;

public class DriverStanding implements Comparable<DriverStanding> {

	public DriverStanding(){}
	
	private Driver driver;
	
	private Team team;
	
	private int position;
	
	private Double points;
	
	public Driver getDriver() {
		return driver;
	}
	
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public Double getPoints() {
		return points;
	}
	
	public void setPoints(Double points) {
		this.points = points;
	}
	
	public void updatePoints(Double points) {
		this.points += points;
	}
	
	public Team getTeam() {
		return team;
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}
	
	@Override
	public int compareTo(DriverStanding o) {
		return this.getPoints().compareTo(o.getPoints());
	}
}