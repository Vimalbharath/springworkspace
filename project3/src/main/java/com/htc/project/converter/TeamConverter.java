package com.htc.project.converter;






import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.htc.project.dto.TeamDTO;
import com.htc.project.model.Team;




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
