package com.htc.springbootdatajpa.converter;



import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.htc.springbootdatajpa.dto.SkillDTO;
import com.htc.springbootdatajpa.dto.SkillDTO;
import com.htc.springbootdatajpa.model.Skill;
import com.htc.springbootdatajpa.model.Skill;



@Component
public class SkillConverter {
	
	
	@Autowired
	private EmployeeConverter employeeConverter;
	
	@Autowired
	private DepartmentConverter departmentConverter;
	
	public Skill dtoToEntity(SkillDTO skill)
	{
		Skill obj=new Skill();
		BeanUtils.copyProperties(skill, obj);
		return obj;	
		
	}
	
	public SkillDTO enityToDto(Skill skill)
	{
		SkillDTO obj=new SkillDTO();
		BeanUtils.copyProperties(skill, obj);
		return obj;	
		
	}
	
	
	public Set<Skill> listOfDtoToEntity(Set<SkillDTO> set)
	{
		return set.stream().map(x->dtoToEntity(x)).collect(Collectors.toSet());
	}
	
	public Set<SkillDTO> listOfEntityToDto(Set<Skill> set)
	{
		return set.stream().map(x->enityToDto(x)).collect(Collectors.toSet());
	}
	

}
