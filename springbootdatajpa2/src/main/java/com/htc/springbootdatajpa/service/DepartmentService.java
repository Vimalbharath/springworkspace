package com.htc.springbootdatajpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.springbootdatajpa.converter.DepartmentConverter;
import com.htc.springbootdatajpa.converter.EmployeeConverter;
import com.htc.springbootdatajpa.dto.DepartmentDTO;
import com.htc.springbootdatajpa.dto.EmployeeDTO;
import com.htc.springbootdatajpa.model.Department;
import com.htc.springbootdatajpa.model.Employee;
import com.htc.springbootdatajpa.repo.DepartmentRepository;
import com.htc.springbootdatajpa.repo.EmployeeRepository;
@Service("departmentService")
public class DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	DepartmentConverter departmentConvertor;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	EmployeeConverter employeeConvertor;
	
	public boolean addDepartmentDTO(DepartmentDTO dept) {
		Department deptObj=departmentConvertor.dtoToEntity(dept);
		if(departmentRepository.save(deptObj)!=null)
			return true;
		return false;
	}
	
public boolean addEmployeeDTO(int deptid,EmployeeDTO emp) {
	    Employee empObj=employeeConvertor.dtoToEntity(emp);
		Optional<Department> optdept=departmentRepository.findById(deptid);
		if(optdept.isPresent()) {
			Department dept=optdept.get();
			empObj.setDepartment(dept);
			if(employeeRepository.save(empObj)!=null)
				return true;
		}
		
		return false;
	}
}
