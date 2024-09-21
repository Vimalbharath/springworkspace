package com.htc.springdatajpaERsong.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.htc.springdatajpaERsong.model.Playlist;
import com.htc.springdatajpaERsong.model.Songs;
import com.htc.springdatajpaERsong.model.User;
import com.htc.springdatajpaERsong.repository.PlaylistRepository;
import com.htc.springdatajpaERsong.repository.SongsRepository;
import com.htc.springdatajpaERsong.repository.UserRepository;

@Service("erservice")
public class ERService {
	
	@Autowired
	PlaylistRepository playlistRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	SongsRepository songsRepository;
	
	public boolean addUser(User user) {
		if(userRepository.save(user)!=null)
			return true;
		return false;
	}
	
   public boolean addPlaylist(int userid,Playlist pl) {
		
		Optional<User> optuser=userRepository.findById(userid);
		if(optuser.isPresent()) {
			User user=optuser.get();
			pl.setUser(user);
			if(playlistRepository.save(pl)!=null)
				return true;
		}
		
		return false;
	}
   public List<Playlist> getAllPlaylists(){
		return (List<Playlist>) playlistRepository.findAll();
	}
	
   public boolean addSong(Songs song) {
		if(songsRepository.save(song)!=null)
			return true;
		return false;
	}

    public boolean playlistsongs(int songid, int playlistid) {
    	
    	Optional<Playlist> optpl=playlistRepository.findById(playlistid);
		Optional<Songs> optsong=songsRepository.findById(songid);
		
		if(optpl.isPresent()&&optsong.isPresent()) {
			Playlist pl=optpl.get();
			Songs song=optsong.get();
			
			Set<Songs> songs=pl.getSongs();
			
			if(songs == null)
				songs=new HashSet<Songs>();
			songs.add(song);
			pl.setSongs(songs);
			playlistRepository.save(pl);
			return true;
		}
		return false;
	
}
   
}