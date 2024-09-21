package com.example.demosecurity.controller;
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

import com.example.demosecurity.rest.dto.*;
import com.example.demosecurity.entity.*;
import com.example.demosecurity.repository.*;
import com.example.demosecurity.converter.*;
import com.example.demosecurity.service.*;


@RestController
@RequestMapping("/api/admin")
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
	public List<Match> getAllMatchs(){
		List<Match> matchs=matchService.getAllMatchs();
		System.out.println(matchs);
		return matchs;
	}
	
	
	
	
	
	
	
}