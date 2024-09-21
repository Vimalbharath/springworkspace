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


@Service("matchService")
public class MatchService {
	 
	@Autowired
	MatchRepository matchRepository;
	@Autowired
	TeamRepository teamRepository;

	
	
	
	public boolean addMatch(int deptid,int deptid2,Match match) {
		
		Optional<Team> optteam1=teamRepository.findById(deptid);
		Optional<Team> optteam2=teamRepository.findById(deptid2);
		if(optteam1.isPresent()&&optteam2.isPresent()) {
			Team team1=optteam1.get();
			match.setTeam1(team1);
			Team team2=optteam2.get();
			match.setTeam2(team2);
			if(matchRepository.save(match)!=null)
				return true;
		}
		
		return false;
	}

	public Match getMatchById(int id) {
		Optional<Match> match=matchRepository.findById(id);
		if(match.isPresent())
			return match.get();
		return null;
	}
	
	public List<Match> getAllMatchs(){
		return (List<Match>) matchRepository.findAll();
	}
	
   
}