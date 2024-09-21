package com.htc.entity;

import java.util.ArrayList;

public class Department {
	public int deptId;
	public String deptName;
	//public Employee emp;
	public ArrayList<Employee> empList = new ArrayList<Employee>();
	@Override
	public String toString() {
		return "DeptDAOImpl [deptId=" + deptId + ", deptName=" + deptName + ", empList=" + empList + "]";
	}
	
	
	
	public Department(int deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}

	
	public Department(int deptId, String deptName, ArrayList<Employee> empList) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.empList = empList;
	}



	public Department() {
		super();
	}
}
