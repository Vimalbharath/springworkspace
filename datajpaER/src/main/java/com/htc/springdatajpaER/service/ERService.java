package com.htc.springdatajpaER.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.springdatajpaER.model.Department;
import com.htc.springdatajpaER.model.Employee;
import com.htc.springdatajpaER.model.TestJob;
import com.htc.springdatajpaER.repository.DepartmentRepository;
import com.htc.springdatajpaER.repository.EmployeeRepository;
import com.htc.springdatajpaER.repository.JobRepository;

@Service("erservice")
public class ERService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	
	public boolean addDepartment(Department dept) {
		if(departmentRepository.save(dept)!=null)
			return true;
		return false;
	}
	
	public boolean addEmployee(int deptid,Employee emp) {
		
		Optional<Department> optdept=departmentRepository.findById(deptid);
		if(optdept.isPresent()) {
			Department dept=optdept.get();
			emp.setDepartment(dept);
			if(employeeRepository.save(emp)!=null)
				return true;
		}
		
		return false;
	}
	
	public List<Employee> getAllEmployees(){
		return (List<Employee>) employeeRepository.findAll();
	}
	
	public Department getDepartment(int empid) {
		Optional<Employee> optemp=employeeRepository.findById(empid);
		if(optemp.isPresent()) {
			Employee emp=optemp.get();
			return emp.getDepartment();
		
		}
		return null;
	}
}
