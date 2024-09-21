package com.htc.springbootdatajpa.converter;



import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.htc.springbootdatajpa.dto.DepartmentDTO;
import com.htc.springbootdatajpa.model.Department;



@Component
public class DepartmentConverter {
	
	
	@Autowired
	private EmployeeConverter employeeConverter;
	
	@Autowired
	private SkillConverter skillConverter;
	
	public Department dtoToEntity(DepartmentDTO department)
	{
		Department obj=new Department();
		BeanUtils.copyProperties(department, obj);
		return obj;	
		
	}
	
	public DepartmentDTO entityToDto(Department department)
	{
		DepartmentDTO obj=new DepartmentDTO();
		BeanUtils.copyProperties(department, obj);
		return obj;	
		
	}
	
	
	
	

}
