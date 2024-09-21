package com.htc.springbootdatajpa.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.springbootdatajpa.model.Department;
import com.htc.springbootdatajpa.model.Employee;
import com.htc.springbootdatajpa.model.Skill;
import com.htc.springbootdatajpa.repo.DepartmentRepository;
import com.htc.springbootdatajpa.repo.EmployeeRepository;
import com.htc.springbootdatajpa.repo.SkillRepository;







@Service("empService")
public class EmpService {
	 
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	SkillRepository skillRepository;
	
//	public boolean addEmployee(Employee emp) {
//		if(employeeRepository.save(emp)!=null)
//			return true;
//		return false;
//	}
	
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

	public Employee getEmployeeById(int id) {
		Optional<Employee> emp=employeeRepository.findById(id);
		if(emp.isPresent())
			return emp.get();
		return null;
	}
	
	public List<Employee> getAllEmployees(){
		return (List<Employee>) employeeRepository.findAll();
	}
	
	public List<Employee> getByLocation(Collection<String> locations){
		return (List<Employee>) employeeRepository.findByLocationIn(locations);
	}
	
	public List<Employee> getByageBetween(int upper,int lower){
		return (List<Employee>) employeeRepository.findByageBetween(upper, lower);
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
	public List<Skill> getAllSkills(){
		return (List<Skill>) skillRepository.findAll();
	}
	public List<Department> getAllDepartments(){
		return (List<Department>) departmentRepository.findAll();
	}
}
