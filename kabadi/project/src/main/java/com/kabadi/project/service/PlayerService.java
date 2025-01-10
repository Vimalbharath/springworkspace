package com.kabadi.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kabadi.project.entity.Player;
import com.kabadi.project.entity.Team;
import com.kabadi.project.repository.PlayerRepository;
import com.kabadi.project.repository.TeamRepository;


@Service("playerService")
public class PlayerService {
	 
	@Autowired
	PlayerRepository playerRepository;
	@Autowired
	TeamRepository teamRepository;


	
	
	
	public boolean addPlayer(int teamid,Player player) {
		
		
		Optional<Team> optteam=teamRepository.findById(teamid);
		if(optteam.isPresent()) {
			Team team=optteam.get();
			player.setTeam(team);
			if(playerRepository.save(player)!=null)
				return true;
		}
		
		return false;
	}

	public Player getPlayerById(int id) {
		Optional<Player> player=playerRepository.findById(id);
		if(player.isPresent())
			return player.get();
		return null;
	}
	
	public boolean deletePlayer(int id) {
		Optional<Player> player=playerRepository.findById(id);
		if(player.isPresent()) {
			playerRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<Player> getAllPlayers(){
		return (List<Player>) playerRepository.findAll();
	}
	
	public int countPlayersInTeam(int teamid) {
	    return playerRepository.countByTeam_teamid(teamid);  // Assuming playerRepository is a JPA repository for Player
	}

	
}
