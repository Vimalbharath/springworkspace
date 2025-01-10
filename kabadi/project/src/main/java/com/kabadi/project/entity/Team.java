package com.kabadi.project.entity;

import java.util.Set;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="team")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="teamid")
	private int teamid;
	private String name;
	private String village;
	
	private String captain;
	private String number;
	
	@OneToMany(mappedBy="team")
	@JsonManagedReference
	Set<Player> players;

	public int getTeamid() {
		return teamid;
	}

	public void setTeamid(int teamid) {
		this.teamid = teamid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getCaptain() {
		return captain;
	}

	public void setCaptain(String captain) {
		this.captain = captain;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return "Team [teamid=" + teamid + ", name=" + name + ", village=" + village + ", captain=" + captain
				+ ", number=" + number + "]";
	}

	public Team(String name, String village, String captain, String number) {
		super();
		this.name = name;
		this.village = village;
		this.captain = captain;
		this.number = number;
	}

	public Team() {
		super();
	}
	
	
	
	

}
