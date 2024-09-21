package com.example.demosecurity.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demosecurity.rest.dto.*;
import com.example.demosecurity.entity.*;
import com.example.demosecurity.repository.*;
import com.example.demosecurity.converter.*;

@Service("teamService")
public class TeamService {
	
	@Autowired
	PlayerRepository playerRepository;
	@Autowired
	TeamRepository teamRepository;
	@Autowired
	TeamConverter teamConvertor;
	

	public boolean addTeam(TeamDTO team) {
		Team teamObj=teamConvertor.dtoToEntity(team);
		if(teamRepository.save(teamObj)!=null)
			return true;
		return false;
	}
	
	 public List<Team> getAllTeams(){
			return (List<Team>) teamRepository.findAll();
		}
}