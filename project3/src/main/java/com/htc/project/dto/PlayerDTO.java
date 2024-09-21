package com.htc.project.dto;



import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PlayerDTO {
	@Nonnull
	@Min(1)
	@Max(100)
	private int playerId;
	
	@NotBlank(message=" Name required")
	@Size(min=3,max=20,message="name must be between 3 and 12 character long")
	private String name;
	
	@Nonnull
	@Min(1)
	@Max(100)
	private int age;
	
	
	TeamDTO team;

	public PlayerDTO() {
		super();
	}

	public PlayerDTO(int playerId, String name, int age) {
		super();
		this.playerId = playerId;
		this.name = name;
		this.age = age;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	@JsonBackReference
	public TeamDTO getTeamDTO() {
		return team;
	}

	public void setTeamDTO(TeamDTO team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "PlayerDTO [playerId=" + playerId + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
