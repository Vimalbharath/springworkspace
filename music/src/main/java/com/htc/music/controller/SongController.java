package com.htc.music.controller;

import java.util.Collection;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.htc.music.dto.SongDTO;
import com.htc.music.model.Song;
import com.htc.music.service.SongService;

@RestController
public class SongController {

	@Autowired
	SongService songService;
	
	@PostMapping(value="/song", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addSong(@RequestBody@Validated SongDTO dept) {
          String response = "";
          if( songService.addSongDTO(dept) )
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
	
	@PutMapping(value="/playlist/{playlistid}/song/{songid}")
	public String addEmpSong(@PathVariable(name="playlistid")int playlistid,
			@PathVariable(name="songid")int songid) {
		String response = "";
	      if( songService.plhasthissong(playlistid, songid) )
	      {
	            response =  "{'status': 'success'}";
	      }
	      else {
	            response=  "{'status': 'fail'}";
	      }
			return response;
	}
	
	@GetMapping(value="/songmovie")
	public List<Song> getSongByMovies(@RequestBody Collection<String> movies){
		List<Song> playlists=songService.getByMovie(movies);
		System.out.println(playlists);
		return playlists;
	}
	
	@GetMapping(value="/songs")
	public List<Song> getAllSongs(){
		List<Song> playlists=songService.getAllSongs(); 
		System.out.println(playlists);
		return playlists;
	}
	
}
