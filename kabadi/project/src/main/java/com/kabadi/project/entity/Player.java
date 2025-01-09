package com.kabadi.project.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="player")
public class Player {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playerid")
	private int playerid;
	@Column
	private String name;
	@Column
	private int age;
	@Column
	private String image;
	@Column
	private int weight;
	@Column
	private String address;
	
	@ManyToOne
	@JoinColumn(name="teamid")
	Team team;

	

	public int getPlayerid() {
		return playerid;
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
		return "Player [playerid=" + playerid + ", name=" + name + ", age=" + age + ", image=" + image + ", weight="
				+ weight + ", address=" + address + ", team=" + team + "]";
	}

	public Player(String name, int age, String image, int weight, String address) {
		super();
		this.name = name;
		this.age = age;
		this.image = image;
		this.weight = weight;
		this.address = address;
	}

	public Player() {
		super();
	}

	
	
}
