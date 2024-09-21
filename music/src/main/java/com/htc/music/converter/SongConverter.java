package com.htc.music.converter;



import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.htc.music.dto.SongDTO;
import com.htc.music.model.Song;





@Component
public class SongConverter {
	
	
	@Autowired
	private PlaylistConverter playlistConverter;
	
	@Autowired
	private UserConverter userConverter;
	
	public Song dtoToEntity(SongDTO song)
	{
		Song obj=new Song();
		BeanUtils.copyProperties(song, obj);
		return obj;	
		
	}
	
	public SongDTO enityToDto(Song song)
	{
		SongDTO obj=new SongDTO();
		BeanUtils.copyProperties(song, obj);
		return obj;	
		
	}
	
	
	public Set<Song> listOfDtoToEntity(Set<SongDTO> set)
	{
		return set.stream().map(x->dtoToEntity(x)).collect(Collectors.toSet());
	}
	
	public Set<SongDTO> listOfEntityToDto(Set<Song> set)
	{
		return set.stream().map(x->enityToDto(x)).collect(Collectors.toSet());
	}
	

}
