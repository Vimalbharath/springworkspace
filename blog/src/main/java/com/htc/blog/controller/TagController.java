package com.htc.blog.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.htc.blog.dto.TagDTO;
import com.htc.blog.model.Tag;
import com.htc.blog.service.TagService;

@RestController
public class TagController {
	@Autowired
	TagService tagService;
	@PostMapping(value="/tag", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addTag(@RequestBody@Validated TagDTO dept) {
	      String response = "";
	      if( tagService.addTagDTO(dept) )
	      {
	            response =  "{'status': 'success'}";
	      }
	      else {
	            response=  "{'status': 'fail'}";
	      }
	      
	      HttpHeaders headers = new HttpHeaders();
	      headers.add("Content-Type", "application/json");
	      headers.add("Access-Control-Allow-Origin", "*");
	      headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
	      headers.add("Access-Control-Allow-Methods", "GET,PUT,DELETE,POST,OPTIONS");
	      
	      ResponseEntity<String> respEntity = new ResponseEntity<String>(response, headers, HttpStatus.CREATED);
	      return respEntity;
	}
	@PutMapping(value="/post/{postid}/tag/{tagid}")
	public String addEmpTag(@PathVariable(name="postid")int postid,
			@PathVariable(name="tagid")int tagid) {
		String response = "";
	      if( tagService.plhasthistag(postid, tagid) )
	      {
	            response =  "{'status': 'success'}";
	      }
	      else {
	            response=  "{'status': 'fail'}";
	      }
			return response;
	}
	@GetMapping(value="/tagname")
	public List<Tag> getTagByMovies(@RequestBody Collection<String> names){
		List<Tag> posts=tagService.getByName(names);
		System.out.println(posts);
		return posts;
	}
	
	@GetMapping(value="/tags")
	public List<Tag> getAllTags(){
		List<Tag> posts=tagService.getAllTags(); 
		System.out.println(posts);
		return posts;
	}
}
