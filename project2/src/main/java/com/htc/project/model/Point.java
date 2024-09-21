package com.htc.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="points")
public class Point {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @OneToOne
    @JoinColumn(name="teamid")
    private Team team;

    private int points;
    private int matchplayed;
    private int matchwon;
    private int matchlost;

	public Point(Team team) {
		super();
		this.team = team;
		
	}

	public Point() {
		super();
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getMatchplayed() {
		return matchplayed;
	}

	public void setMatchplayed(int matchplayed) {
		this.matchplayed = matchplayed;
	}

	public int getMatchwon() {
		return matchwon;
	}

	public void setMatchwon(int matchwon) {
		this.matchwon = matchwon;
	}

	public int getMatchlost() {
		return matchlost;
	}

	public void setMatchlost(int matchlost) {
		this.matchlost = matchlost;
	}

	@Override
	public String toString() {
		return "Points [team=" + team + ", points=" + points + "]";
	}

}
