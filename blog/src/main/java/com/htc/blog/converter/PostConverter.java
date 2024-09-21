package com.htc.blog.converter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.htc.blog.dto.PostDTO;
import com.htc.blog.model.Post;



@Component
public class PostConverter {
	
	
	@Autowired
	private CommentConverter commentConverter;
	
	@Autowired
	private TagConverter tagConverter;
	
	public Post dtoToEntity(PostDTO post)
	{
		Post obj=new Post();
		BeanUtils.copyProperties(post, obj);
		if(post.getTagDTO()!=null)
			obj.setTag(tagConverter.listOfDtoToEntity(post.getTagDTO()));
		if(post.getCommentDTOs()!=null)
			obj.setComments(commentConverter.listOfDtoToEntity(post.getCommentDTOs()));
		return obj;	
		
	}
	
	public PostDTO enityToDto(Post post)
	{
		PostDTO obj=new PostDTO();
		BeanUtils.copyProperties(post, obj);
		//System.out.println("After"+obj.getEmpname());
		if(post.getTag()!=null)
			obj.setTagDTO(tagConverter.listOfEntityToDto(post.getTag()));
		if(post.getComments()!=null)
			obj.setCommentDTOs(commentConverter.listOfEntityToDto(post.getComments()));
		return obj;	
		
	}
	
	public Set<Post> listOfDtoToEntity(List<PostDTO> posts)
	{
		return posts.stream().map(x->dtoToEntity(x)).collect(Collectors.toSet());
	}
	
	public Set<PostDTO> listOfEntityToDto(List<Post> posts)
	{
		return posts.stream().map(x->enityToDto(x)).collect(Collectors.toSet());
	}
	
	

}

