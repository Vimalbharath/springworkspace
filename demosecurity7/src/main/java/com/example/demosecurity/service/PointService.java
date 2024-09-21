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


@Service("pointService")
public class PointService {
	 
	@Autowired
	PlayerRepository playerRepository;
	@Autowired
	TeamRepository teamRepository;
	@Autowired
	PointsRepository pointRepository;
	@Autowired
	MatchRepository matchRepository;
	@Autowired
	DetailsRepository detailsRepository;

	
	
	
	public boolean addTeamPoint(int deptid) {
		
		Optional<Team> optteam=teamRepository.findById(deptid);
		Point point = new Point();
		if(optteam.isPresent()) {
			Team team=optteam.get();
			point.setTeam(team);
			if(pointRepository.save(point)!=null)
				return true;
		}
		
		return false;
	}

	public Point getPointById(int id) {
		Optional<Point> point=pointRepository.findById(id);
		if(point.isPresent())
			return point.get();
		return null;
	}
	
	public List<Point> getAllPoints(){
		return (List<Point>) pointRepository.findAll();
	}
	
//public boolean editTeamPoint(int matchid) {
//		
//		Optional<Match> optmatch=matchRepository.findById(matchid);
//		Details optDetails = detailsRepository.findByMatch_matchid(matchid);
//		if(optmatch.isPresent()) {
//			Match match=optmatch.get();
//			Team team1=match.getTeam1();
//			Team team2=match.getTeam2();
//			Team winner=optDetails.getWinner();
//			Team lost=new Team();
//			if(winner==team1)
//			 {lost=team2;}
//			else
//				lost=team1;
//			
//			Optional<Point> optpointloss=pointRepository.findById(lost.getTeamid());
//			if(optpointloss.isPresent()) {
//				Point point=optpointloss.get();
//				int oldpoint=point.getPoints();
//				int oldmp=point.getMatchplayed();
//				int oldml=point.getMatchlost();
//				point.setPoints(oldpoint);
//				point.setMatchlost(oldml+1);
//				point.setMatchplayed(oldmp+1);
//				
//				Optional<Point> optpointwon=pointRepository.findById(winner.getTeamid());
//				if(optpointwon.isPresent()) {
//					Point pointwon=optpointwon.get();
//					int oldpoint2=pointwon.getPoints();
//					int oldmp2=pointwon.getMatchplayed();
//					int oldmw=pointwon.getMatchwon();
//					pointwon.setPoints(oldpoint2+2);
//					pointwon.setMatchwon(oldmw+1);
//					pointwon.setMatchplayed(oldmp2+1);
//					pointRepository.save(pointwon);
//			if((pointRepository.save(point))!=null)
//				return true;
//			
//			}}
//		}
//		
//		return false;
//	}
	
	public boolean editTeamPoint(int matchid) {

	    Optional<Match> optMatch = matchRepository.findById(matchid);
	    if (optMatch.isPresent()) {
	        Match match = optMatch.get();
	        Details details = detailsRepository.findByMatch_matchid(matchid);
	        if (details != null && details.getWinner() != null) { // Check for winner existence

	            Team winner = details.getWinner();
	            Team loser = winner == match.getTeam1() ? match.getTeam2() : match.getTeam1();

	            Optional<Point> optPointLoss = pointRepository.findByTeam_teamid(loser.getTeamid());
	            if (optPointLoss.isPresent()) {
	                Point pointLoss = optPointLoss.get();
	                pointLoss.setMatchlost(pointLoss.getMatchlost() + 1);
	                pointLoss.setMatchplayed(pointLoss.getMatchplayed() + 1);

	                Optional<Point> optPointWon = pointRepository.findByTeam_teamid(winner.getTeamid());
	                if (optPointWon.isPresent()) {
	                    Point pointWon = optPointWon.get();
	                    pointWon.setMatchwon(pointWon.getMatchwon() + 1);
	                    pointWon.setPoints(pointWon.getPoints() + 2);
	                    pointWon.setMatchplayed(pointWon.getMatchplayed() + 1);
	                    pointRepository.save(pointWon); // Save winner points first
	                }

	                pointRepository.save(pointLoss); // Save loser points after
	                return true;
	            }
	        }
	    }

	    return false;
	}

	
}