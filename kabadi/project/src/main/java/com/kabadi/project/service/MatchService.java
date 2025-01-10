package com.kabadi.project.service;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kabadi.project.repository.MatchRepository;
import com.kabadi.project.repository.TeamRepository;
import com.kabadi.project.entity.*;

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
			match.setTeam1score(0);
			match.setTeam2score(0);
			
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
	public boolean deleteMatch(int id) {
		Optional<Match> player=matchRepository.findById(id);
		if(player.isPresent()) {
			matchRepository.deleteById(id);
			return true;
		}
		return false;
	}
	public boolean updateMatch(int matchid,Match match) {
		
		   Optional<Match> optmatch=matchRepository.findById(matchid);
		   
		   
			if(optmatch.isPresent()) {
				Match oldmatch=optmatch.get();
				oldmatch.setTeam1score(match.getTeam1score());
				oldmatch.setTeam2score(match.getTeam2score());
				
				
				
				if(matchRepository.save(oldmatch)!=null)
					return true;
				
			}
			return false;
		}
   
}