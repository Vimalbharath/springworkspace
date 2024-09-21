package com.example.demosecurity.controller;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demosecurity.rest.dto.*;
import com.example.demosecurity.entity.*;
import com.example.demosecurity.repository.*;
import com.example.demosecurity.converter.*;
import com.example.demosecurity.service.*;


@RestController
@RequestMapping("/api/captain")
public class PlayerController {
	
	@Autowired
	PlayerService playerService;
	
	@RequestMapping(value="/info",method=RequestMethod.GET)
	public String info() {
		return "{'msg':'Welcome to Springboot'}";
	}
	

	
	
	@PostMapping(value="/player/{teamid}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String addPlayer(@PathVariable(name="teamid")int teamid,
			@RequestBody@Validated PlayerDTO player) {
		String response = "";
      if( playerService.addPlayer(teamid, player) )
      {
            response =  "{'status': 'success'}";
      }
      else {
            response=  "{'status': 'fail'}";
      }
		return response;
	}
	
	@RequestMapping(value="/player/{playerid}",method=RequestMethod.GET)
	public ResponseEntity<Player> getPlayerById(@PathVariable(name="playerid")int playerid) {
		Player emp=playerService.getPlayerById(playerid);
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Player> respEntity;
		
		if( emp!=null )
        {
			 respEntity = new ResponseEntity<Player>(emp, headers, HttpStatus.OK);
        }
        else {
             respEntity = new ResponseEntity<Player>( HttpStatus.NOT_FOUND);
        }
		return respEntity;
	}
	@RequestMapping(value="/noofplayersofteam/{teamid}",method=RequestMethod.GET)
	public ResponseEntity<Integer> countByTeam_TeamId(@PathVariable(name="teamid")int teamid) {
		int count=playerService.countPlayersInTeam(teamid);
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Integer> respEntity;
		
		if( count!=0 )
        {
			 respEntity = new ResponseEntity<Integer>(count, headers, HttpStatus.OK);
        }
        else {
             respEntity = new ResponseEntity<Integer>( HttpStatus.NOT_FOUND);
        }
		return respEntity;
	}
	 
	@GetMapping(value="/players/{playerid}")
	public Player getPlayerById2(@PathVariable(name="playerid")int playerid){
		Player players=playerService.getPlayerById(playerid);
		System.out.println(players);
		return players;
	}
	
	@GetMapping(value="/players")
	public List<Player> getAllPlayers(){
		List<Player> players=playerService.getAllPlayers();
		System.out.println(players);
		return players;
	}
	
	
	
	
	
	
	
}