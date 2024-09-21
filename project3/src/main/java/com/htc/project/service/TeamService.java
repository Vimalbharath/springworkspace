package com.htc.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.htc.project.converter.TeamConverter;
import com.htc.project.dto.TeamDTO;
import com.htc.project.model.Team;
import com.htc.project.repo.PlayerRepository;
import com.htc.project.repo.TeamRepository;

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
