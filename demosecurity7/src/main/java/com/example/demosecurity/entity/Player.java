package com.example.demosecurity.entity;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="player")
public class Player {
	@Id
	@Column(name="playerid")
	private int playerId;
	
	private String name;
	private int age;
	
	@ManyToOne
	@JoinColumn(name="teamid")
	Team team;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="playerskill",
			joinColumns=@JoinColumn(name="playerid"),
			inverseJoinColumns=@JoinColumn(name="skillid")
			)
	Set<Skill> skill;

	public Set<Skill> getSkill() {
		return skill;
	}

	public void setSkill(Set<Skill> skill) {
		this.skill = skill;
	}

	public Player() {
		super();
	}

	public Player(int playerId, String name, int age) {
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
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", name=" + name + ", age=" + age + "]";
	}
	
	
}