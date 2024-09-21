package com.htc.springbootdatajpa.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class SkillDTO {
	

	private int skillId;
	
	private String name;

	

	public SkillDTO(String name) {
		super();
		this.name = name;
	}

	public SkillDTO() {
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