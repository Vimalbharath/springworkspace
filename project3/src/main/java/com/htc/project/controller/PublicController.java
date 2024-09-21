package com.htc.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htc.project.model.Details;
import com.htc.project.model.Match;
import com.htc.project.model.Player;
import com.htc.project.model.Point;
import com.htc.project.model.Team;
import com.htc.project.repo.DetailsRepository;
import com.htc.project.service.DetailsService;
import com.htc.project.service.MatchService;
import com.htc.project.service.PlayerService;
import com.htc.project.service.PointService;
import com.htc.project.service.TeamService;

@RestController
@RequestMapping("/public")
@CrossOrigin(origins = "http://localhost:3000")
public class PublicController {
	
	@Autowired
	PointService pointService;
	@Autowired
	TeamService teamService;
	@Autowired
	MatchService matchService;
	@Autowired
	DetailsService detailsService;
	@Autowired
	DetailsRepository detailsRepository;
	@Autowired
	PlayerService playerService;
	
	@GetMapping(value="/points")
	public List<Point> getAllPoints(){
		List<Point> points=pointService.getAllPoints();
		System.out.println(points);
		return points;
	}
	
	@GetMapping(value="/details")
	public List<Details> getAllDetails(){
		List<Details> details=detailsService.getAllDetails();
		System.out.println(details);
		return details;
	}
	@GetMapping(value="/matchs")
	public List<Match> getAllMatchs(){
		List<Match> matchs=matchService.getAllMatchs();
		System.out.println(matchs);
		return matchs;
	}
	@GetMapping(value="/players")
	public List<Player> getAllPlayers(){
		List<Player> players=playerService.getAllPlayers();
		System.out.println(players);
		return players;
	}
	@GetMapping(value="/teams")
	
	public List<Team> getAllTeams(){
		List<Team> players=teamService.getAllTeams(); 
		System.out.println(players);
		return players;
	}
}
