package com.htc.springbootdatajpa.dto;

import java.util.Date;

import java.util.Set;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;




public class EmployeeDTO {

	@Nonnull
	@Min(100)
	@Max(400)
	private int empId;
	
	@NotBlank(message="Employee Name required")
	@Size(min=3,max=20,message="Username must be between 3 and 12 character long")
	private String empname;
	
	private int age;
	@NotBlank(message="Location required")
	@Size(min=3,max=10,message="Designation must be between 3 and 10 character long")
	private String location;
	
	
	DepartmentDTO department;
	Set<SkillDTO> skills;
	
	public EmployeeDTO() {}

	

	

	public EmployeeDTO(int empId, String empname, int age, String location) {
		super();
		this.empId = empId;
		this.empname = empname;
		this.age = age;
		this.location = location;
	}





	public int getEmpId() {
		return empId;
	}





	public void setEmpId(int empId) {
		this.empId = empId;
	}





	public int getAge() {
		return age;
	}





	public void setAge(int age) {
		this.age = age;
	}





	public String getLocation() {
		return location;
	}





	public void setLocation(String location) {
		this.location = location;
	}





	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}




	@JsonBackReference
	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}

	public Set<SkillDTO> getSkills() {
		return skills;
	}

	public void setSkills(Set<SkillDTO> skills) {
		this.skills = skills;
	}

	
	
}
