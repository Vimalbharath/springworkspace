package com.htc.blog.converter;



import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.htc.blog.dto.CommentDTO;
import com.htc.blog.dto.CommentDTO;
import com.htc.blog.model.Comment;
import com.htc.blog.model.Comment;





@Component
public class CommentConverter {
	
	
	@Autowired
	private PostConverter posttConverter;
	
	@Autowired
	private TagConverter tagConverter;
	
	public Comment dtoToEntity(CommentDTO comment)
	{
		Comment obj=new Comment();
		BeanUtils.copyProperties(comment, obj);
		return obj;	
		
	}
	
	public CommentDTO entityToDto(Comment comment)
	{
		CommentDTO obj=new CommentDTO();
		BeanUtils.copyProperties(comment, obj);
		return obj;	
		
	}
	
	public Set<Comment> listOfDtoToEntity(Set<CommentDTO> set)
	{
		return set.stream().map(x->dtoToEntity(x)).collect(Collectors.toSet());
	}
	
	public Set<CommentDTO> listOfEntityToDto(Set<Comment> set)
	{
		return set.stream().map(x->entityToDto(x)).collect(Collectors.toSet());
	}
	
	

}
