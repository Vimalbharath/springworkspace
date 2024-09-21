package com.htc.entity;

import java.util.Objects;

public class Employee {
	public int empId;
	public String empName;
	public String location;
	public String designation;

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", location=" + location + ", designation="
				+ designation + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(designation, empId, empName, location);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(designation, other.designation) && empId == other.empId && empName == other.empName
				&& Objects.equals(location, other.location);
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Employee(int empId, String empName, String location, String designation) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.location = location;
		this.designation = designation;
	}

	public Employee() {
		super();
	}

}
