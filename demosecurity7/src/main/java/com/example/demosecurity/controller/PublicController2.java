package com.example.demosecurity.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demosecurity.rest.dto.*;
import com.example.demosecurity.entity.*;
import com.example.demosecurity.repository.*;
import com.example.demosecurity.converter.*;
import com.example.demosecurity.service.*;

@RestController
@RequestMapping("api/public")
@CrossOrigin(origins = "http://localhost:3000")
public class PublicController2 {
	
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