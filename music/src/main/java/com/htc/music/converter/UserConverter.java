package com.htc.music.converter;



import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.htc.music.dto.UserDTO;
import com.htc.music.model.User;





@Component
public class UserConverter {
	
	
	@Autowired
	private PlaylistConverter playlistConverter;
	
	@Autowired
	private SongConverter songConverter;
	
	public User dtoToEntity(UserDTO user)
	{
		User obj=new User();
		BeanUtils.copyProperties(user, obj);
		return obj;	
		
	}
	
	public UserDTO entityToDto(User user)
	{
		UserDTO obj=new UserDTO();
		BeanUtils.copyProperties(user, obj);
		return obj;	
		
	}
	
	
	
	

}
