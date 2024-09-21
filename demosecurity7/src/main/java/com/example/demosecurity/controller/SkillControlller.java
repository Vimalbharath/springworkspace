package com.example.demosecurity.controller;
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
import org.springframework.web.bind.annotation.RestController;

import com.example.demosecurity.rest.dto.*;
import com.example.demosecurity.entity.*;
import com.example.demosecurity.repository.*;
import com.example.demosecurity.converter.*;
import com.example.demosecurity.service.*;


@RestController
@RequestMapping("/api/admin")
public class SkillControlller {
	
	@Autowired
	SkillService skillService;
	
	
	@PostMapping(value="/skill", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addSkill(@RequestBody@Validated SkillDTO skill) {
          String response = "";
          if( skillService.addSkill(skill) )
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
	
	@PutMapping(value="/player/{playerid}/skill/{skillid}")
	public String addEmpSkill(@PathVariable(name="playerid")int playerid,
			@PathVariable(name="skillid")int skillid) {
		String response = "";
	      if( skillService.playerhasthisskill(playerid, skillid) )
	      {
	            response =  "{'status': 'success'}";
	      }
	      else {
	            response=  "{'status': 'fail'}";
	      }
			return response;
	}
	
	@GetMapping(value="/skills")
	public List<Skill> getAllSkills(){
		List<Skill> players=skillService.getAllSkills(); 
		System.out.println(players);
		return players;
	}
}