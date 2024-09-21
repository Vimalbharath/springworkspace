package com.htc.blog.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.htc.blog.dto.PostDTO;
import com.htc.blog.model.Post;
import com.htc.blog.service.PostService;


@RestController
public class PostController {
	@Autowired
	PostService postService;
	
	@RequestMapping(value="/info",method=RequestMethod.GET)
	public String info() {
		return "{'msg':'Welcome to Springboot'}";
	}
	@PostMapping(value="/post", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addPost(@RequestBody@Validated PostDTO dept) {
          String response = "";
          if( postService.addPostDTO(dept) )
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
	
	@GetMapping(value="/posts/{postid}")
	public Post getPostById2(@PathVariable(name="postid")int postid){
		Post posts=postService.getPostById(postid);
		System.out.println(posts);
		return posts;
	}
	
	@GetMapping(value="/posts")
	public List<Post> getAllPosts(){
		List<Post> posts=postService.getAllPosts();
		System.out.println(posts);
		return posts;
	}
}
