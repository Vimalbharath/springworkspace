package com.htc.music.controller;




import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.htc.music.model.Playlist;
import com.htc.music.model.Song;
import com.htc.music.model.User;
import com.htc.music.service.PlaylistServiceOld;



@RestController
@RequestMapping("/old")
public class PlaylistControllerOld {
	
	@Autowired
	PlaylistServiceOld playlistService;
	
	@RequestMapping(value="/info",method=RequestMethod.GET)
	public String info() {
		return "{'msg':'Welcome to Springboot'}";
	}
	
//	@PostMapping(value="/playlist", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> addPlaylist(@RequestBody Playlist playlist) {
//          String response = "";
//          if( playlistService.addPlaylist(playlist) )
//          {
//                response =  "{'status': 'success'}";
//          }
//          else {
//                response=  "{'status': 'fail'}";
//          }
//          
//          HttpHeaders headers = new HttpHeaders();
//          headers.add("Content-Type", "application/json");
//          headers.add("Access-Control-Allow-Origin", "*");
//          headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
//          headers.add("Access-Control-Allow-Methods", "GET,PUT,DELETE,POST,OPTIONS");
//          
//          ResponseEntity<String> respEntity = new ResponseEntity<String>(response, headers, HttpStatus.CREATED);
//          return respEntity;
//    }
	@PostMapping(value="/user", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addUser(@RequestBody User user) {
          String response = "";
          if( playlistService.addUser(user) )
          {
                response =  "{'status': 'success'}";
          }
          else {
                response=  "{'status': 'fail'}";
          }
          
          HttpHeaders headers = new HttpHeaders();
          headers.add("Content-Type", "application/json");
          headers.add("Access-Control-Allow-Origin", "*");
          headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
          headers.add("Access-Control-Allow-Methods", "GET,PUT,DELETE,POST,OPTIONS");
          
          ResponseEntity<String> respEntity = new ResponseEntity<String>(response, headers, HttpStatus.CREATED);
          return respEntity;
    }
	
	@PostMapping(value="/playlist/{userid}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String addPlaylist(@PathVariable(name="userid")int userid,
			@RequestBody Playlist playlist) {
		String response = "";
      if( playlistService.addPlaylist(userid, playlist) )
      {
            response =  "{'status': 'success'}";
      }
      else {
            response=  "{'status': 'fail'}";
      }
		return response;
	}
	@PostMapping(value="/song", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String addSong(@RequestBody Song sk) {
		String response = "";
      if( playlistService.addSong(sk) )
      {
            response =  "{'status': 'success'}";
      }
      else {
            response=  "{'status': 'fail'}";
      }
		return response;
	}
	@RequestMapping(value="/playlist/{playlistid}",method=RequestMethod.GET)
	public ResponseEntity<Playlist> getPlaylistById(@PathVariable(name="playlistid")int playlistid) {
		Playlist playlist=playlistService.getPlaylistById(playlistid);
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Playlist> respEntity;
		
		if( playlist!=null )
        {
			 respEntity = new ResponseEntity<Playlist>(playlist, headers, HttpStatus.OK);
        }
        else {
             respEntity = new ResponseEntity<Playlist>( HttpStatus.NOT_FOUND);
        }
		return respEntity;
	}
	 
	@GetMapping(value="/playlists/{playlistid}")
	public Playlist getPlaylistById2(@PathVariable(name="playlistid")int playlistid){
		Playlist playlists=playlistService.getPlaylistById(playlistid);
		System.out.println(playlists);
		return playlists;
	}
	
	@GetMapping(value="/playlists")
	public List<Playlist> getAllPlaylists(){
		List<Playlist> playlists=playlistService.getAllPlaylists();
		System.out.println(playlists);
		return playlists;
	}
	
//	@GetMapping(value="/playlists/{lower}/{upper}")
//	public List<Playlist> getPlaylistsbetween(@PathVariable(name="lower")int lower,
//			@PathVariable(name="upper")int upper){
//		List<Playlist> playlists=playlistService.getByageBetween(lower, upper);
//		System.out.println(playlists);
//		return playlists;
//	}
//	
	@GetMapping(value="/songmovie")
	public List<Song> getSongByMovies(@RequestBody Collection<String> movies){
		List<Song> playlists=playlistService.getByMovie(movies);
		System.out.println(playlists);
		return playlists;
	}
	
	@GetMapping(value="/songs")
	public List<Song> getAllSongs(){
		List<Song> playlists=playlistService.getAllSongs(); 
		System.out.println(playlists);
		return playlists;
	}
	
	@GetMapping(value="/users")
	public List<User> getAllUsers(){
		List<User> users=playlistService.getAllUsers(); 
		System.out.println(users);
		return users;
	}
	
	@PutMapping(value="/playlist/{playlistid}/song/{songid}")
	public String addEmpSong(@PathVariable(name="playlistid")int playlistid,
			@PathVariable(name="songid")int songid) {
		String response = "";
	      if( playlistService.plhasthissong(playlistid, songid) )
	      {
	            response =  "{'status': 'success'}";
	      }
	      else {
	            response=  "{'status': 'fail'}";
	      }
			return response;
	}
	
}
