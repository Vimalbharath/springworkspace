package com.htc.blog.controller;




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
import org.springframework.web.bind.annotation.RestController;

import com.htc.blog.model.Post;
import com.htc.blog.model.Tag;
import com.htc.blog.model.Comment;
import com.htc.blog.service.PostServiceOld;



@RestController
@RequestMapping("/old") 
public class PostControllerOld {
	
	@Autowired
	PostServiceOld postService;
	
	@RequestMapping(value="/info",method=RequestMethod.GET)
	public String info() {
		return "{'msg':'Welcome to Springboot'}";
	}
	
	@PostMapping(value="/post", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addPost(@RequestBody Post post) {
          String response = "";
          if( postService.addPost(post) )
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
//	@PostMapping(value="/comment", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> addComment(@RequestBody Comment comment) {
//          String response = "";
//          if( postService.addComment(comment) )
//          {
//                response =  "{'status': 'success'}";
//          }
//          else {
//                response=  "{'status': 'fail'}";
//          }
//          
//          HttpHeaders headers = new HttpHeaders();
//          headers.add("Content-Type", "application/json");
//          headers.add("Access-Control-Allow-Origin", "*");
//          headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
//          headers.add("Access-Control-Allow-Methods", "GET,PUT,DELETE,POST,OPTIONS");
//          
//          ResponseEntity<String> respEntity = new ResponseEntity<String>(response, headers, HttpStatus.CREATED);
//          return respEntity;
//    }
	
	@PostMapping(value="/comment/{postid}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String addComment(@PathVariable(name="postid")int postid,
			@RequestBody Comment comment) {
		String response = "";
      if( postService.addComment(postid, comment) )
      {
            response =  "{'status': 'success'}";
      }
      else {
            response=  "{'status': 'fail'}";
      }
		return response;
	}
	@PostMapping(value="/tag", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String addTag(@RequestBody Tag sk) {
		String response = "";
      if( postService.addTag(sk) )
      {
            response =  "{'status': 'success'}";
      }
      else {
            response=  "{'status': 'fail'}";
      }
		return response;
	}
	@RequestMapping(value="/post/{postid}",method=RequestMethod.GET)
	public ResponseEntity<Post> getPostById(@PathVariable(name="postid")int postid) {
		Post post=postService.getPostById(postid);
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Post> respEntity;
		
		if( post!=null )
        {
			 respEntity = new ResponseEntity<Post>(post, headers, HttpStatus.OK);
        }
        else {
             respEntity = new ResponseEntity<Post>( HttpStatus.NOT_FOUND);
        }
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
	
//	@GetMapping(value="/posts/{lower}/{upper}")
//	public List<Post> getPostsbetween(@PathVariable(name="lower")int lower,
//			@PathVariable(name="upper")int upper){
//		List<Post> posts=postService.getByageBetween(lower, upper);
//		System.out.println(posts);
//		return posts;
//	}
//	
	@GetMapping(value="/tagname")
	public List<Tag> getTagByMovies(@RequestBody Collection<String> names){
		List<Tag> posts=postService.getByName(names);
		System.out.println(posts);
		return posts;
	}
	
	@GetMapping(value="/tags")
	public List<Tag> getAllTags(){
		List<Tag> posts=postService.getAllTags(); 
		System.out.println(posts);
		return posts;
	}
	
	@GetMapping(value="/comments")
	public List<Comment> getAllComments(){
		List<Comment> comments=postService.getAllComments(); 
		System.out.println(comments);
		return comments;
	}
	
	@PutMapping(value="/post/{postid}/tag/{tagid}")
	public String addEmpTag(@PathVariable(name="postid")int postid,
			@PathVariable(name="tagid")int tagid) {
		String response = "";
	      if( postService.plhasthistag(postid, tagid) )
	      {
	            response =  "{'status': 'success'}";
	      }
	      else {
	            response=  "{'status': 'fail'}";
	      }
			return response;
	}
	
}
