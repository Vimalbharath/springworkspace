package com.kabadi.project.controller;
import static com.kabadi.project.config.SwaggerConfig.BASIC_AUTH_SECURITY_SCHEME;

import java.util.Collection;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
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


import com.kabadi.project.entity.*;
import com.kabadi.project.repository.*;

import com.kabadi.project.service.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class MatchController {
	
	@Autowired
	MatchService matchService;
	
	
	

	
	
	@PostMapping(value="/match/{team1id}/{team2id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String addMatch(@PathVariable(name="team1id")int team1id,@PathVariable(name="team2id")int team2id,
			@RequestBody Match match) {
		String response = "";
      if( matchService.addMatch(team1id, team2id, match) )
      {
            response =  "{'status': 'success'}";
      }
      else {
            response=  "{'status': 'fail'}";
      }
		return response;
	}
	
	@RequestMapping(value="/match/{matchid}",method=RequestMethod.GET)
	public ResponseEntity<Match> getMatchById(@PathVariable(name="matchid")int matchid) {
		Match emp=matchService.getMatchById(matchid);
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Match> respEntity;
		
		if( emp!=null )
        {
			 respEntity = new ResponseEntity<Match>(emp, headers, HttpStatus.OK);
        }
        else {
             respEntity = new ResponseEntity<Match>( HttpStatus.NOT_FOUND);
        }
		return respEntity;
	}
	 
	@GetMapping(value="/matchs/{matchid}")
	public Match getMatchById2(@PathVariable(name="matchid")int matchid){
		Match matchs=matchService.getMatchById(matchid);
		System.out.println(matchs);
		return matchs;
	}
	
	@GetMapping(value="/matchs")
	@Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
	public List<Match> getAllMatchs(){
		List<Match> matchs=matchService.getAllMatchs();
		System.out.println(matchs);
		return matchs;
	}
	
	@RequestMapping(value="/deletematch/{matchid}",method=RequestMethod.DELETE)
	public ResponseEntity<Player> deleteMatch(@PathVariable(name="matchid")int matchid) {
		boolean emp=matchService.deleteMatch(matchid);
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Player> respEntity;
		
		if( emp!=false )
        {
			 respEntity = new ResponseEntity<Player>(HttpStatus.OK);
        }
        else {
             respEntity = new ResponseEntity<Player>( HttpStatus.NOT_FOUND);
        }
		return respEntity;
	}
	
	@RequestMapping(value="/updatematch/{matchid}",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.PUT)
	public ResponseEntity<Player> updateMatch(@PathVariable(name="matchid")int matchid,@RequestBody Match match) {
		boolean emp=matchService.updateMatch(matchid,match);
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Player> respEntity;
		
		if( emp!=false )
        {
			 respEntity = new ResponseEntity<Player>(HttpStatus.OK);
        }
        else {
             respEntity = new ResponseEntity<Player>( HttpStatus.NOT_FOUND);
        }
		return respEntity;
	}
	
	
	
	
	
}