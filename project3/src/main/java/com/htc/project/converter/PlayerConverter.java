package com.htc.project.converter;



import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.htc.project.dto.PlayerDTO;
import com.htc.project.model.Player;







@Component
public class PlayerConverter {
	
	
	@Autowired
	private TeamConverter teamConverter;
	
	
	
	public Player dtoToEntity(PlayerDTO player)
	{
		Player obj=new Player();
		BeanUtils.copyProperties(player, obj);
		
		if(player.getTeamDTO()!=null)
			obj.setTeam(teamConverter.dtoToEntity(player.getTeamDTO()));
		return obj;	
		
	}
	
	public PlayerDTO enityToDto(Player player)
	{
		PlayerDTO obj=new PlayerDTO();
		BeanUtils.copyProperties(player, obj);
		System.out.println("After"+obj.getAge());
		
		if(player.getTeam()!=null)
			obj.setTeamDTO(teamConverter.entityToDto(player.getTeam()));
		return obj;	
		
	}
	
	public Set<Player> listOfDtoToEntity(List<PlayerDTO> players)
	{
		return players.stream().map(x->dtoToEntity(x)).collect(Collectors.toSet());
	}
	
	public Set<PlayerDTO> listOfEntityToDto(List<Player> players)
	{
		return players.stream().map(x->enityToDto(x)).collect(Collectors.toSet());
	}
	
	

}
