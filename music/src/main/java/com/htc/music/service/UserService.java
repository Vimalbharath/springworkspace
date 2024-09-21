package com.htc.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.music.converter.PlaylistConverter;
import com.htc.music.converter.SongConverter;
import com.htc.music.converter.UserConverter;
import com.htc.music.dto.UserDTO;
import com.htc.music.model.User;
import com.htc.music.repo.PlaylistRepository;
import com.htc.music.repo.SongRepository;
import com.htc.music.repo.UserRepository;


@Service("userService")
public class UserService {

	
	@Autowired
	PlaylistRepository playlistRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	SongRepository songRepository;
	@Autowired
	PlaylistConverter playlistConvertor;
	@Autowired
	UserConverter userConvertor;
	@Autowired
	SongConverter songConvertor;
	
	public boolean addUserDTO(UserDTO dept) {
		User deptObj=userConvertor.dtoToEntity(dept);
		if(userRepository.save(deptObj)!=null)
			return true;
		return false;
	}
	
	public List<User> getAllUsers(){
		return (List<User>) userRepository.findAll();
	}
}
