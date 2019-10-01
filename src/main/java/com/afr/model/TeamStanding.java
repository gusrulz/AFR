package com.afr.model;

import java.util.List;

public class TeamStanding implements Comparable<TeamStanding> {

	public TeamStanding(){}
	
	private Team team;
	
	private List<Driver> drivers;
	
	private int position;
	
	private double points;
	
	public Team getTeam() {
		return team;
	}
	
	public void setTeam(Team team) {
		this.team = team;
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
	
	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}
	
	public List<Driver> getDrivers() {
		return this.drivers;
	}
	
	@Override
	public int compareTo(TeamStanding o) {
		return this.getPoints().compareTo(o.getPoints());
	}
}