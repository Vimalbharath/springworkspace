package com.htc.dao;

import java.util.ArrayList;

import com.htc.entity.Employee;
import com.htc.exceptions.EmployeeNotFoundException;

public interface DeptInterface {
	public boolean addEmployee(Employee emp);
	public Employee getEmployee(int empId)throws EmployeeNotFoundException;
	public ArrayList<Employee> getAllEmployee();
	public Employee updateEmployee  (int empId,String Designation)throws EmployeeNotFoundException;
	public boolean deleteEmployee(int empId);
	
}
