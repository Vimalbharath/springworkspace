package com.htc.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.project.model.Team;
import com.htc.project.repo.PlayerRepository;
import com.htc.project.repo.TeamRepository;

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
