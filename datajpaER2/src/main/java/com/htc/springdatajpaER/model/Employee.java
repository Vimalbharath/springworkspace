package com.htc.springdatajpaER.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="employee1")
public class Employee {
	
	@Id
	@Column(name="empid")
	private int empId;
	
	private String name;
	private int age;
	private String address;
	
	@Column(name="startdate")
	@Temporal(TemporalType.DATE)
	private Date startdate;
	
	@ManyToOne
	@JoinColumn(name="deptid")
	Department department;
	//private int deptid;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="empskill1",
			joinColumns=@JoinColumn(name="empid"),
			inverseJoinColumns=@JoinColumn(name="skillid")
			)
	Set<Skill> skill;

	public Set<Skill> getSkill() {
		return skill;
	}
	public void setSkill(Set<Skill> skill) {
		this.skill = skill;
	}
	public Employee() {
		super();
	}
	public Employee(int empId, String name, int age, String address, Date startdate) {
		super();
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.address = address;
		this.startdate = startdate;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", age=" + age + ", address=" + address + ", startdate="
				+ startdate + ", department=" + department + "]";
	}
	
	
}
