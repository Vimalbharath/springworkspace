package com.example.demosecurity.entity;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="team")
public class Team {
	@Id
	@Column(name="teamid")
	private int teamid;
	private String name;
	
	@OneToMany(mappedBy="team")
	@JsonManagedReference
	Set<Player> players;
//	@OneToOne(mappedBy = "team")  // MappedBy points to the field name in PointsTable
//    private PointsTable pointsTable;
	
//	 // Option 2: One Team to Many Matches (for Team 1 or Team 2)
//    @OneToMany(mappedBy="team1")  // Descriptive name for Team 1 relationship
//    private Set<Match> matchesAsTeam1;
//
//    @OneToMany(mappedBy="team2")  // Descriptive name for Team 2 relationship
//    private Set<Match> matchesAsTeam2;

	

	public Team() {
		super();
	}

	public Team(int teamid, String name) {
		super();
		this.teamid = teamid;
		this.name = name;
	}

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

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

//	@Override
//	public String toString() {
//		return "Team [teamid=" + teamid + ", name=" + name + ", players=\" + players + \"]";
//	}
	
	
}