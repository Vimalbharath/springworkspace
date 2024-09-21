package com.htc.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.htc.blog.dto.CommentDTO;
import com.htc.blog.model.Comment;
import com.htc.blog.service.CommentService;


@RestController
public class CommentController {
	@Autowired
	CommentService commentService;
	
	@PostMapping(value="/comment/{postid}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String addComment(@PathVariable(name="postid")int postid,
			@RequestBody@Validated CommentDTO comment) {
		String response = "";
      if( commentService.addCommentDTO(postid, comment) )
      {
            response =  "{'status': 'success'}";
      }
      else {
            response=  "{'status': 'fail'}";
      }
		return response;
	}
	
	@GetMapping(value="/comments")
	public List<Comment> getAllComments(){
		List<Comment> comments=commentService.getAllComments(); 
		System.out.println(comments);
		return comments;
	}
}
