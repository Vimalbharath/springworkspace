package com.htc.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.htc.music.dto.PlaylistDTO;
import com.htc.music.model.Playlist;
import com.htc.music.service.PlaylistService;


@RestController
public class PlaylistController {

	@Autowired
	PlaylistService playlistService;
	
	@RequestMapping(value="/info",method=RequestMethod.GET)
	public String info() {
		return "{'msg':'Welcome to Springboot'}";
	}
	
	@PostMapping(value="/playlist/{userid}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String addPlaylist(@PathVariable(name="userid")int userid,
			@RequestBody@Validated PlaylistDTO emp) {
		String response = "";
      if( playlistService.addPlaylistDTO(userid, emp) )
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
}
