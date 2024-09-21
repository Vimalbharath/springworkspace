package com.htc.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="skill")
public class Skill {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="skillid")
	private int skillId;
	
	private String name;

	

	public Skill(String name) {
		super();
		this.name = name;
	}

	public Skill() {
		super();
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", name=" + name + "]";
	}
	
	
}