package com.htc.project.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class SkillDTO {
	

	private int skillId;
	@NotBlank(message=" Name required")
	@Size(min=3,max=20,message="name must be between 3 and 12 character long")
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