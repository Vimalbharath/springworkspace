package com.kabadi.project.controller;

import static com.kabadi.project.config.SwaggerConfig.BASIC_AUTH_SECURITY_SCHEME;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kabadi.project.entity.Match;
import com.kabadi.project.entity.Player;
import com.kabadi.project.entity.Team;
import com.kabadi.project.service.TeamService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class TeamController {

	@Autowired
	TeamService teamService;
	
	@Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
	@PostMapping(value="/admin/team", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public String addTeam(@RequestBody Team team) {
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
          return response;
    }
	
	@Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
	@RequestMapping(value="/admin/updateteam/{teamid}",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.PUT)
	public ResponseEntity<Team> updateTeam(@PathVariable(name="teamid")int teamid,@RequestBody Team team) {
		boolean emp=teamService.updateTeam(teamid,team);
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Team> respEntity;
		
		if( emp!=false )
        {
			 respEntity = new ResponseEntity<Team>(HttpStatus.OK);
        }
        else {
             respEntity = new ResponseEntity<Team>( HttpStatus.NOT_FOUND);
        }
		return respEntity;
	}
	
	
	@GetMapping(value="/public/teams")
	@Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
	public List<Team> getAllTeams(){
		List<Team> teams=teamService.getAllTeams(); 
		System.out.println(teams);
		return teams;
	}
	
	@Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
	@RequestMapping(value="/admin/deleteteam/{teamid}",method=RequestMethod.DELETE)
	public ResponseEntity<Team> deleteTeam(@PathVariable(name="teamid")int teamid) {
		boolean emp=teamService.deleteTeam(teamid);
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Team> respEntity;
		
		if( emp!=false )
        {
			 respEntity = new ResponseEntity<Team>(HttpStatus.OK);
        }
        else {
             respEntity = new ResponseEntity<Team>( HttpStatus.NOT_FOUND);
        }
		return respEntity;
	}
	
	@Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
	@GetMapping(value="/public/team/{teamid}")
	public Team getSingleTeam(@PathVariable(name="teamid")int teamid){
		Team matchs=teamService.getTeamById(teamid);
		System.out.println(matchs);
		return matchs;
	}
}

