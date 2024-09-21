package com.htc.springdatajpaER.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.springdatajpaER.model.Department;
import com.htc.springdatajpaER.model.Employee;
import com.htc.springdatajpaER.model.Skill;
import com.htc.springdatajpaER.model.TestJob;
import com.htc.springdatajpaER.repository.DepartmentRepository;
import com.htc.springdatajpaER.repository.EmployeeRepository;
import com.htc.springdatajpaER.repository.JobRepository;
import com.htc.springdatajpaER.repository.SkillRepository;

@Service("erservice")
public class ERService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	SkillRepository skillRepository;
	
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
	public boolean addSkill(Skill skill) {
		if(skillRepository.save(skill)!=null)
			return true;
		return false;
	}
	
	public boolean emphasthisskill(int empid,int skillid) {
		Optional<Employee> optemp=employeeRepository.findById(empid);
		Optional<Skill> optskill=skillRepository.findById(skillid);
		
		if(optemp.isPresent()&&optskill.isPresent()) {
			Employee emp=optemp.get();
			Skill skil=optskill.get();
			
			Set<Skill> skills=emp.getSkill();
			
			if(skills == null)
				skills=new HashSet<Skill>();
			skills.add(skil);
			emp.setSkill(skills);
			employeeRepository.save(emp);
			return true;
		}
		return false;
	}
}
