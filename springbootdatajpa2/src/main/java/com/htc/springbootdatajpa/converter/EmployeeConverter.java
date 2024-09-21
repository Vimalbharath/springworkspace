package com.htc.springbootdatajpa.converter;



import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.htc.springbootdatajpa.dto.EmployeeDTO;
import com.htc.springbootdatajpa.model.Employee;



@Component
public class EmployeeConverter {
	
	
	@Autowired
	private DepartmentConverter departmentConverter;
	
	@Autowired
	private SkillConverter skillConverter;
	
	public Employee dtoToEntity(EmployeeDTO employee)
	{
		Employee obj=new Employee();
		BeanUtils.copyProperties(employee, obj);
		if(employee.getSkills()!=null)
			obj.setSkill(skillConverter.listOfDtoToEntity(employee.getSkills()));
		if(employee.getDepartment()!=null)
			obj.setDepartment(departmentConverter.dtoToEntity(employee.getDepartment()));
		return obj;	
		
	}
	
	public EmployeeDTO enityToDto(Employee employee)
	{
		EmployeeDTO obj=new EmployeeDTO();
		BeanUtils.copyProperties(employee, obj);
		System.out.println("After"+obj.getEmpname());
		if(employee.getSkill()!=null)
			obj.setSkills(skillConverter.listOfEntityToDto(employee.getSkill()));
		if(employee.getDepartment()!=null)
			obj.setDepartment(departmentConverter.entityToDto(employee.getDepartment()));
		return obj;	
		
	}
	
	public Set<Employee> listOfDtoToEntity(List<EmployeeDTO> employees)
	{
		return employees.stream().map(x->dtoToEntity(x)).collect(Collectors.toSet());
	}
	
	public Set<EmployeeDTO> listOfEntityToDto(List<Employee> employees)
	{
		return employees.stream().map(x->enityToDto(x)).collect(Collectors.toSet());
	}
	
	

}
