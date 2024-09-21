package com.htc.entity;

public class Employee {
	private double empId;
	private String empName;
	private String address;
	private String designation;
	private double salary;
	public Employee(double empid2, String empName, String address, String designation, double salary2) {
		super();
		this.empId = empid2;
		this.empName = empName;
		this.address = address;
		this.designation = designation;
		this.salary = salary2;
	}
	public double getEmpId() {
		return empId;
	}
	public void setEmpId(double empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", address=" + address + ", designation="
				+ designation + ", salary=" + salary + "]";
	}
	public static void add(Employee employee) {
		// TODO Auto-generated method stub
		//System.out.println(employee);
	}

}
