package com.kabadi.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kabadi.project.entity.Team;
import com.kabadi.project.repository.PlayerRepository;
import com.kabadi.project.repository.TeamRepository;



@Service("teamService")
public class TeamService {
	
	@Autowired
	PlayerRepository playerRepository;
	@Autowired
	TeamRepository teamRepository;
	
	

	public boolean addTeam(Team team) {
		
		if(teamRepository.save(team)!=null)
			return true;
		return false;
	}
	
	 public List<Team> getAllTeams(){
			return (List<Team>) teamRepository.findAll();
		}
}
