package com.htc.project.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.project.model.Details;
import com.htc.project.model.Match;
import com.htc.project.model.Player;
import com.htc.project.model.Team;
import com.htc.project.repo.DetailsRepository;
import com.htc.project.repo.MatchRepository;
import com.htc.project.repo.PlayerRepository;
import com.htc.project.repo.PointsRepository;
import com.htc.project.repo.TeamRepository;


@Service("detailsService")
public class DetailsService {
	
	@Autowired
	PlayerRepository playerRepository; 
	@Autowired
	DetailsRepository detailsRepository;
	@Autowired
	TeamRepository teamRepository;
	@Autowired
	PointsRepository pointRepository;
	@Autowired
	MatchRepository matchRepository;

	
	
	
	public boolean addMatchdetails(int deptid) {
		
		Optional<Match> optmatch=matchRepository.findById(deptid);
		Details details = new Details();
		if(optmatch.isPresent()) {
			Match match=optmatch.get();
			details.setMatch(match);
			if(detailsRepository.save(details)!=null)
				return true;
		}
		
		return false;
	}
	
//    public boolean editMatchdetails(int detailsid,String toss,int innings1Score,int innings2Score,
//    		int teamid,int playerid) {
//		
//		Optional<Details> optdetails=detailsRepository.findById(detailsid);
//		
//		if(optdetails.isPresent()) {
//			Details details=optdetails.get();
//			
//			Match match=details.getMatch();
//			int mid=match.getMatchid();
//			Optional<Match> mat = matchRepository.findById(mid);
//            if (mat.isPresent()) {
//            	Match match1=mat.get();
//            	match1.setPlayed(true);
//            	if(matchRepository.save(match1)!=null);
//            }
//           
//			details.setToss(toss);
//			details.setInnings1Score(innings1Score);
//			details.setInnings2Score(innings2Score);
//			Optional<Team> winner = teamRepository.findById(teamid);
//            if (winner.isPresent()) {
//                details.setWinner(winner.get());
//            }
//            Optional<Player> manOfTheMatch = playerRepository.findById(playerid);
//            if (manOfTheMatch.isPresent()) {
//                details.setManOfTheMatch(manOfTheMatch.get());
//            }
//			if(detailsRepository.save(details)!=null)
//				return true;
//		}
//		
//		return false;
//	}
	public boolean editMatchdetails(int detailsid, String toss, int innings1Score, int innings2Score, int teamid, int playerid) {
	    Optional<Details> optDetails = detailsRepository.findById(detailsid);

	    if (optDetails.isPresent()) {
	        Details details = optDetails.get();
	        Match match = details.getMatch();

	        // Update the Match object (assuming played flag needs to be set)
	        match.setPlayed(true);

	        details.setToss(toss);
	        details.setInnings1Score(innings1Score);
	        details.setInnings2Score(innings2Score);
	        details.setWinner(teamRepository.findById(teamid).orElse(null)); // Assuming null if team not found
	        details.setManOfTheMatch(playerRepository.findById(playerid).orElse(null)); // Assuming null if player not found

	        // Save both Details and the updated Match in one call
	        detailsRepository.save(details);
	        return true;
	    }

	    return false;
	}

	public Details getDetailsById(int id) {
		Optional<Details> details=detailsRepository.findById(id);
		if(details.isPresent())
			return details.get();
		return null;
	}
	
	public List<Details> getAllDetails(){
		return (List<Details>) detailsRepository.findAll();
	}
	
	
	
}
