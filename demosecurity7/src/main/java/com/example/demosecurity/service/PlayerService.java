package com.example.demosecurity.service;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demosecurity.rest.dto.*;
import com.example.demosecurity.entity.*;
import com.example.demosecurity.repository.*;
import com.example.demosecurity.converter.*;


@Service("playerService")
public class PlayerService {
	 
	@Autowired
	PlayerRepository playerRepository;
	@Autowired
	TeamRepository teamRepository;
	@Autowired
	TeamConverter teamConvertor;
	@Autowired
	PlayerConverter playerConvertor;

	
	
	
	public boolean addPlayer(int teamid,PlayerDTO player) {
		
		Player playerObj=playerConvertor.dtoToEntity(player);
		Optional<Team> optteam=teamRepository.findById(teamid);
		if(optteam.isPresent()) {
			Team team=optteam.get();
			playerObj.setTeam(team);
			if(playerRepository.save(playerObj)!=null)
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
	
	public List<Player> getAllPlayers(){
		return (List<Player>) playerRepository.findAll();
	}
	
	public int countPlayersInTeam(int teamid) {
	    return playerRepository.countByTeam_teamid(teamid);  // Assuming playerRepository is a JPA repository for Player
	}

	
}