package com.htc.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.blog.converter.CommentConverter;
import com.htc.blog.converter.PostConverter;
import com.htc.blog.converter.TagConverter;
import com.htc.blog.dto.CommentDTO;
import com.htc.blog.model.Comment;
import com.htc.blog.model.Post;
import com.htc.blog.repo.CommentRepository;
import com.htc.blog.repo.PostRepository;
import com.htc.blog.repo.TagRepository;


@Service("commentService")
public class CommentService {
	@Autowired
	TagConverter tagConvertor;
	@Autowired
	CommentConverter commentConvertor;
	@Autowired
	PostConverter postConvertor;
	@Autowired
	PostRepository postRepository;
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	TagRepository tagRepository;
	
	public boolean addCommentDTO(int postid,CommentDTO comment) {
	    Comment commentObj=commentConvertor.dtoToEntity(comment);
		Optional<Post> optpost=postRepository.findById(postid);
		if(optpost.isPresent()) {
			Post post=optpost.get();
			commentObj.setPost(post);
			if(commentRepository.save(commentObj)!=null)
				return true;
		}
		
		return false;
	}
	
	public List<Comment> getAllComments(){
		return (List<Comment>) commentRepository.findAll();
	}
	
}
