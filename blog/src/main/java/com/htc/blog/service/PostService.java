package com.htc.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.blog.converter.CommentConverter;
import com.htc.blog.converter.PostConverter;
import com.htc.blog.converter.TagConverter;
import com.htc.blog.dto.PostDTO;
import com.htc.blog.model.Post;
import com.htc.blog.repo.CommentRepository;
import com.htc.blog.repo.PostRepository;
import com.htc.blog.repo.TagRepository;



@Service("postService")
public class PostService {
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
	
	
	
	public boolean addPostDTO(PostDTO dept) {
		Post deptObj=postConvertor.dtoToEntity(dept);
		if(postRepository.save(deptObj)!=null)
			return true;
		return false;
	}
	public Post getPostById(int id) {
		Optional<Post> pl=postRepository.findById(id);
		if(pl.isPresent())
			return pl.get();
		return null;
	}
	
	
	public List<Post> getAllPosts(){
		return (List<Post>) postRepository.findAll();
	}
}
