package com.afr.model;

import java.time.Duration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "result")
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="race_id", nullable = false)
	private Race race;
	
	@ManyToOne()
	@JoinColumn(name="driver_id", nullable = false)
	private Driver driver;
	
	@ManyToOne()
	@JoinColumn(name="team_id", nullable = false)
	private Team team;
	
	@Column(name = "qualifying", nullable = true)
	private Duration qualifying;
	
	@Column(name = "fastestlap", nullable = true)
	private Duration fastestlap;
	
	@Column(name = "racetime", nullable = true)
	private Duration racetime;
	
	@Column(name = "position", nullable = false)
	private String position;
	
	@Column(name = "timepenalty", nullable = true)
	private int timepenalty;
	
	@Column(name = "positionpenalty", nullable = true)
	private int positionpenalty;
	
	@Column(name = "points", nullable = false)
	private double points;

	public Integer getId() {
		return id;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Duration getFastestlap() {
		return fastestlap;
	}

	public void setFastestlap(Duration fastestlap) {
		this.fastestlap = fastestlap;
	}

	public Duration getRacetime() {
		return racetime;
	}

	public void setRacetime(Duration racetime) {
		this.racetime = racetime;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getTimepenalty() {
		return timepenalty;
	}

	public void setTimepenalty(int timepenalty) {
		this.timepenalty = timepenalty;
	}

	public int getPositionpenalty() {
		return positionpenalty;
	}

	public void setPositionpenalty(int positionpenalty) {
		this.positionpenalty = positionpenalty;
	}

	public Duration getQualifying() {
		return qualifying;
	}

	public void setQualifying(Duration qualifying) {
		this.qualifying = qualifying;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}
}
