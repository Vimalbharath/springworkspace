package com.kabadi.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kabadi.project.entity.Player;
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
	
	public boolean updateTeam(int teamid,Team team) {
		
		   Optional<Team> optteam=teamRepository.findById(teamid);
			if(optteam.isPresent()) {
				Team oldteam=optteam.get();
				oldteam.setCaptain(team.getCaptain());
				oldteam.setName(team.getName());
				oldteam.setNumber(team.getNumber());
				oldteam.setVillage(team.getVillage());
				
				if(teamRepository.save(oldteam)!=null)
					return true;
				
			}
			return false;
		}
	
   public boolean deleteTeam(int teamid) {
		
	   Optional<Team> team=teamRepository.findById(teamid);
		if(team.isPresent()) {
			if(playerRepository.countByTeam_teamid(teamid)==0) {
			teamRepository.deleteById(teamid);
			return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
	 public List<Team> getAllTeams(){
			return (List<Team>) teamRepository.findAll();
		}
}
