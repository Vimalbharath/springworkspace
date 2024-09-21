package com.htc.springbootdatajpa.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	@Id
	@Column(name="deptid")
	private int deptid;
	private String name;
	private String info;
	
	@OneToMany(mappedBy="department")
	@JsonManagedReference
	Set<Employee> employees;

	public Department() {
		super();
	}

	public Department(int deptid, String name, String info) {
		super();
		this.deptid = deptid;
		this.name = name;
		this.info = info;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [deptid=" + deptid + ", name=" + name + ", info=" + info + ", employees=" + employees + "]";
	}
	
	
}
