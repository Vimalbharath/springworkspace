package com.htc.springbootdatajpa.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


public class DepartmentDTO {

	private int deptid;
	private String name;
	private String info;
	
	@OneToMany(mappedBy="department")
	@JsonManagedReference
	Set<EmployeeDTO> employees;

	public DepartmentDTO() {
		super();
	}

	public DepartmentDTO(int deptid, String name, String info) {
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

	public Set<EmployeeDTO> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeeDTO> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "DepartmentDTO [deptid=" + deptid + ", name=" + name + ", info=" + info + ", employees=" + employees + "]";
	}
	
	
}
