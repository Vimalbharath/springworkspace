package com.htc.springbootstarter.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class WelcomeController {
	
	@RequestMapping(value="/info",method=RequestMethod.GET)
	public String info() {
		return "{'msg':'Welcome to Springboot'}";
	}
	
	@GetMapping(value="/date")
	public String date() {
		return "{Today is March 16}";
	}
	
	@RequestMapping(value="/queryParam",method=RequestMethod.GET)
	public String TestQueryParam(String name,String location) {
		return "Name is " + name + " and location is " +location;
	}
	
	@RequestMapping(value="/queryParam2",method=RequestMethod.GET)
	public String TestQueryParam2(@RequestParam(name="empname",required=true)String empname,String location) {
		return "Name is " + empname + " and location is " +location;
	}
	
	@RequestMapping(value="/pathParam/{empid}/{name}",method=RequestMethod.GET)
	public String TestPathParam(@PathVariable(name="empid")int empid,
			@PathVariable(name="name")String name) {
		return "ID is " + empid + " and name is " +name;
	}
	
	@RequestMapping(value="/queryPath/{empid}",method=RequestMethod.GET)
	public String TestQueryPathParam(@PathVariable(name="empid")int empid,
			String name) {
		return "ID is " + empid + " and name is " +name;
	}
	
	@RequestMapping(value="/postSong",method=RequestMethod.POST
			,consumes=MediaType.APPLICATION_JSON_VALUE
			,produces=MediaType.APPLICATION_JSON_VALUE)
	public Songs postSong(@RequestBody Songs song) {
		System.out.println(song);
		return song;
	}
}
