package com.htc.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htc.project.model.Team;

import com.htc.project.service.TeamService;

@RestController
@RequestMapping("/admin")
public class TeamController {

	@Autowired
	TeamService teamService;
	
	@PostMapping(value="/team", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addTeam(@RequestBody Team team) {
          String response = "";
          if( teamService.addTeam(team) )
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
	
	@GetMapping(value="/teams")
	public List<Team> getAllTeams(){
		List<Team> players=teamService.getAllTeams(); 
		System.out.println(players);
		return players;
	}
}
