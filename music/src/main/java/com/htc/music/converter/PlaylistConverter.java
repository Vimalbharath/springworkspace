package com.htc.music.converter;



import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.htc.music.dto.PlaylistDTO;
import com.htc.music.model.Playlist;





@Component
public class PlaylistConverter {
	
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private SongConverter songConverter;
	
	public Playlist dtoToEntity(PlaylistDTO playlist)
	{
		Playlist obj=new Playlist();
		BeanUtils.copyProperties(playlist, obj);
		if(playlist.getSong()!=null)
			obj.setSong(songConverter.listOfDtoToEntity(playlist.getSong()));
		if(playlist.getUser()!=null)
			obj.setUser(userConverter.dtoToEntity(playlist.getUser()));
		return obj;	
		
	}
	
	public PlaylistDTO enityToDto(Playlist playlist)
	{
		PlaylistDTO obj=new PlaylistDTO();
		BeanUtils.copyProperties(playlist, obj);
		//System.out.println("After"+obj.getEmpname());
		if(playlist.getSong()!=null)
			obj.setSong(songConverter.listOfEntityToDto(playlist.getSong()));
		if(playlist.getUser()!=null)
			obj.setUser(userConverter.entityToDto(playlist.getUser()));
		return obj;	
		
	}
	
	public Set<Playlist> listOfDtoToEntity(List<PlaylistDTO> playlists)
	{
		return playlists.stream().map(x->dtoToEntity(x)).collect(Collectors.toSet());
	}
	
	public Set<PlaylistDTO> listOfEntityToDto(List<Playlist> playlists)
	{
		return playlists.stream().map(x->enityToDto(x)).collect(Collectors.toSet());
	}
	
	

}
