package com.example.demosecurity.rest.dto;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class TeamDTO {
	@Nonnull
	@Min(1)
	@Max(10)
	private int teamid;
	@NotBlank(message="Name required")
	@Size(min=2,max=12,message="name must be between 2 and 12 character long")
	private String name;
	
	@OneToMany(mappedBy="team")
	@JsonManagedReference
	Set<PlayerDTO> players;

	

	public TeamDTO() {
		super();
	}

	public TeamDTO(int teamid, String name) {
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

//	public Set<PlayerDTO> getPlayerDTOs() {
//		return players;
//	}
//
//	public void setPlayerDTOs(Set<PlayerDTO> players) {
//		this.players = players;
//	}

	public Set<PlayerDTO> getPlayers() {
		return players;
	}

	public void setPlayers(Set<PlayerDTO> players) {
		this.players = players;
	}


	
}