package com.htc.music.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.music.converter.PlaylistConverter;
import com.htc.music.converter.SongConverter;
import com.htc.music.converter.UserConverter;
import com.htc.music.dto.SongDTO;
import com.htc.music.model.Playlist;
import com.htc.music.model.Song;
import com.htc.music.repo.PlaylistRepository;
import com.htc.music.repo.SongRepository;
import com.htc.music.repo.UserRepository;


@Service("songService")
public class SongService {
	
	
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
	
	public boolean addSongDTO(SongDTO dept) {
		Song deptObj=songConvertor.dtoToEntity(dept);
		if(songRepository.save(deptObj)!=null)
			return true;
		return false;
	}
	
	public boolean plhasthissong(int plid,int songid) {
		Optional<Playlist> optpl=playlistRepository.findById(plid);
		Optional<Song> optsong=songRepository.findById(songid);
		
		if(optpl.isPresent()&&optsong.isPresent()) {
			Playlist pl=optpl.get();
			Song song=optsong.get();
			
			Set<Song> songs=pl.getSong();
			
			if(songs == null)
				songs=new HashSet<Song>();
			songs.add(song);
			pl.setSong(songs);
			playlistRepository.save(pl);
			return true;
		}
		return false;
	}
	
	public List<Song> getByMovie(Collection<String> movies){
		return (List<Song>) songRepository.findByMovieIn(movies);
	}
	
	public List<Song> getAllSongs(){
		return (List<Song>) songRepository.findAll();
	}
}
