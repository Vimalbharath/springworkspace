package com.htc.project.controller;




import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.htc.project.model.Point;
import com.htc.project.model.Team;
import com.htc.project.service.PointService;


@RestController
@RequestMapping("/admin")
public class PointController {
	
	@Autowired
	PointService pointService;

	@PostMapping(value="/point/{teamid}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String addPoint(@PathVariable(name="teamid")int teamid
			) {
		String response = "";
      if( pointService.addTeamPoint(teamid) )
      {
            response =  "{'status': 'success'}";
      }
      else {
            response=  "{'status': 'fail'}";
      }
		return response;
	}
	
	@RequestMapping(value="/point/{pointid}",method=RequestMethod.GET)
	public ResponseEntity<Point> getPointById(@PathVariable(name="pointid")int pointid) {
		Point emp=pointService.getPointById(pointid);
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Point> respEntity;
		
		if( emp!=null )
        {
			 respEntity = new ResponseEntity<Point>(emp, headers, HttpStatus.OK);
        }
        else {
             respEntity = new ResponseEntity<Point>( HttpStatus.NOT_FOUND);
        }
		return respEntity;
	}
	
	
	 
	@GetMapping(value="/points/{pointid}")
	public Point getPointById2(@PathVariable(name="pointid")int pointid){
		Point points=pointService.getPointById(pointid);
		System.out.println(points);
		return points;
	}
	
	@GetMapping(value="/points")
	public List<Point> getAllPoints(){
		List<Point> points=pointService.getAllPoints();
		System.out.println(points);
		return points;
	}
	
	
	@PutMapping(value="/updatepoints/{matchid}")
	public String editPoints(@PathVariable(name="matchid")int matchid) {
		String response = "";
	      if( pointService.editTeamPoint(matchid) )
	      {
	            response =  "{'status': 'success'}";
	      }
	      else {
	            response=  "{'status': 'fail'}";
	      }
			return response;
	}
	
	
	
	
}
