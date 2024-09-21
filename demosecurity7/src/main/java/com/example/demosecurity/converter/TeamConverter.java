package com.example.demosecurity.converter;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demosecurity.rest.dto.*;
import com.example.demosecurity.entity.*;




@Component
public class TeamConverter {
	
	
	@Autowired
	private PlayerConverter playerConverter;
	
	
	
	public Team dtoToEntity(TeamDTO user)
	{
		Team obj=new Team();
		BeanUtils.copyProperties(user, obj);
		return obj;	
		
	}
	
	public TeamDTO entityToDto(Team user)
	{
		TeamDTO obj=new TeamDTO();
		BeanUtils.copyProperties(user, obj);
		return obj;	
		
	}
	
	
	
	

}