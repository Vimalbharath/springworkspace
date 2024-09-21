package com.htc.project.controller;




import java.util.Collection;
import java.util.List;
import java.util.Optional;

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

import com.htc.project.model.Details;
import com.htc.project.model.Team;
import com.htc.project.repo.DetailsRepository;
import com.htc.project.service.DetailsService;


@RestController
public class DetailsController {
	
	@Autowired
	DetailsService detailsService;
	@Autowired
	DetailsRepository detailsRepository;

	@PostMapping(value="/details/{matchid}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String addDetails(@PathVariable(name="matchid")int matchid
			) {
		String response = "";
      if( detailsService.addMatchdetails(matchid) )
      {
            response =  "{'status': 'success'}";
      }
      else {
            response=  "{'status': 'fail'}";
      }
		return response;
	}
	
	@RequestMapping(value="/detail/{detailsid}",method=RequestMethod.GET)
	public ResponseEntity<Details> getDetailsById(@PathVariable(name="detailsid")int detailsid) {
		Details emp=detailsService.getDetailsById(detailsid);
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Details> respEntity;
		
		if( emp!=null )
        {
			 respEntity = new ResponseEntity<Details>(emp, headers, HttpStatus.OK);
        }
        else {
             respEntity = new ResponseEntity<Details>( HttpStatus.NOT_FOUND);
        }
		return respEntity;
	}
	
	
	 
	@GetMapping(value="/details/{detailsid}")
	public Details getDetailsById2(@PathVariable(name="detailsid")int detailsid){
		Details details=detailsService.getDetailsById(detailsid);
		System.out.println(details);
		return details;
	}
	
	@GetMapping(value="/details")
	public List<Details> getAllDetails(){
		List<Details> details=detailsService.getAllDetails();
		System.out.println(details);
		return details;
	}
	
	
	
	 @PutMapping(value="/details/{detailsid}/{teamid}/{playerid}")
		public String editMatchDetails(@PathVariable(name="detailsid")int detailsid,
				@PathVariable(name="teamid")int teamid,
				@PathVariable(name="playerid")int playerid,
				@RequestParam(name="toss")String toss,int innings1Score, int innings2Score) {
			String response = "";
		      if( detailsService.editMatchdetails( detailsid, toss, innings1Score, innings2Score,
		      		teamid, playerid) )
		      {
		            response =  "{'status': 'success'}";
		      }
		      else {
		            response=  "{'status': 'fail'}";
		      }
				return response;
		}
	
	
	
}
