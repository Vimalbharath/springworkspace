package com.htc.springbootdatajpa.model;



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
@Table(name="employee1")
public class Employee {
	
	@Id
	@Column(name="empid")
	private int empId;
	
	private String empname;
	private int age;
	private String location;
	
	@ManyToOne
	@JoinColumn(name="deptid")
	Department department;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="empskill",
			joinColumns=@JoinColumn(name="empid"),
			inverseJoinColumns=@JoinColumn(name="skillid")
			)
	Set<Skill> skill;
	
	public Employee(int empId, String empname, int age, String location) {
		super();
		this.empId = empId;
		this.empname = empname;
		this.age = age;
		this.location = location;
	}
	public Employee() {
		super();
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
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
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empname=" + empname + ", age=" + age + ", location=" + location + "]";
	}
	@JsonBackReference
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Set<Skill> getSkill() {
		return skill;
	}
	public void setSkill(Set<Skill> skill) {
		this.skill = skill;
	}
	
	
	
}