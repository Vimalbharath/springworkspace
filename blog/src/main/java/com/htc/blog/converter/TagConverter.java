package com.htc.blog.converter;



import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.htc.blog.dto.TagDTO;
import com.htc.blog.model.Tag;




@Component
public class TagConverter {
	
	
	@Autowired
	private PostConverter postConverter;
	
	@Autowired
	private CommentConverter commentConverter;
	
	public Tag dtoToEntity(TagDTO tag)
	{
		Tag obj=new Tag();
		BeanUtils.copyProperties(tag, obj);
		return obj;	
		
	}
	
	public TagDTO enityToDto(Tag tag)
	{
		TagDTO obj=new TagDTO();
		BeanUtils.copyProperties(tag, obj);
		return obj;	
		
	}
	
	
	public Set<Tag> listOfDtoToEntity(Set<TagDTO> set)
	{
		return set.stream().map(x->dtoToEntity(x)).collect(Collectors.toSet());
	}
	
	public Set<TagDTO> listOfEntityToDto(Set<Tag> set)
	{
		return set.stream().map(x->enityToDto(x)).collect(Collectors.toSet());
	}
	

}
