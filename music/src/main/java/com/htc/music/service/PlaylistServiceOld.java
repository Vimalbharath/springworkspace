package com.htc.music.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.music.model.Playlist;
import com.htc.music.model.Song;
import com.htc.music.model.User;
import com.htc.music.repo.PlaylistRepository;
import com.htc.music.repo.SongRepository;
import com.htc.music.repo.UserRepository;

@Service("playlistServiceOld")
public class PlaylistServiceOld {
	 
	@Autowired
	PlaylistRepository playlistRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	SongRepository songRepository;
	
//	public boolean addPlaylist(Playlist pl) {
//		if(playlistRepository.save(pl)!=null)
//			return true;
//		return false;
//	}
	
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

	public Playlist getPlaylistById(int id) {
		Optional<Playlist> pl=playlistRepository.findById(id);
		if(pl.isPresent())
			return pl.get();
		return null;
	}
	
	public List<Playlist> getAllPlaylists(){
		return (List<Playlist>) playlistRepository.findAll();
	}
	
	public List<Song> getByMovie(Collection<String> movies){
		return (List<Song>) songRepository.findByMovieIn(movies);
	}
	
//	public List<Playlist> getByageBetween(int upper,int lower){
//		return (List<Playlist>) playlistRepository.findByageBetween(upper, lower);
//	}
	public boolean addSong(Song song) {
		if(songRepository.save(song)!=null)
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
	public List<Song> getAllSongs(){
		return (List<Song>) songRepository.findAll();
	}
	public List<User> getAllUsers(){
		return (List<User>) userRepository.findAll();
	}
}
