package com.htc.springdatajpaER.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="skill1")
public class Skill {
	
	@Id
	@Column(name="skillid")
	private int skillId;
	
	private String name;

	public Skill(int skillId, String name) {
		super();
		this.skillId = skillId;
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
	
}
