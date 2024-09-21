package com.htc.music.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.music.converter.PlaylistConverter;
import com.htc.music.converter.SongConverter;
import com.htc.music.converter.UserConverter;
import com.htc.music.dto.PlaylistDTO;
import com.htc.music.model.Playlist;
import com.htc.music.model.User;
import com.htc.music.repo.PlaylistRepository;
import com.htc.music.repo.SongRepository;
import com.htc.music.repo.UserRepository;


@Service("playlistService")
public class PlaylistService {
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
	
	public boolean addPlaylistDTO(int deptid,PlaylistDTO emp) {
	    Playlist empObj=playlistConvertor.dtoToEntity(emp);
		Optional<User> optdept=userRepository.findById(deptid);
		if(optdept.isPresent()) {
			User dept=optdept.get();
			empObj.setUser(dept);
			if(playlistRepository.save(empObj)!=null)
				return true;
		}
		
		return false;
	}
	
	public Playlist getPlaylistById(int id) {
		Optional<Playlist> pl=playlistRepository.findById(id);
		if(pl.isPresent())
			return pl.get();
		return null;
	}
	
	public List<Playlist> getAllPlaylists(){
		return (List<Playlist>) playlistRepository.findAll();
	}
	
}