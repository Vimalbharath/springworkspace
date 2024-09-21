package com.htc.blog.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.blog.converter.CommentConverter;
import com.htc.blog.converter.PostConverter;
import com.htc.blog.converter.TagConverter;
import com.htc.blog.dto.TagDTO;
import com.htc.blog.model.Post;
import com.htc.blog.model.Tag;
import com.htc.blog.repo.CommentRepository;
import com.htc.blog.repo.PostRepository;
import com.htc.blog.repo.TagRepository;

@Service("tagService")
public class TagService {
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
	
	public boolean addTagDTO(TagDTO tag) {
		Tag tagObj=tagConvertor.dtoToEntity(tag);
		if(tagRepository.save(tagObj)!=null)
			return true;
		return false;
	}
	public boolean plhasthistag(int plid,int tagid) {
		Optional<Post> optpl=postRepository.findById(plid);
		Optional<Tag> opttag=tagRepository.findById(tagid);
		
		if(optpl.isPresent()&&opttag.isPresent()) {
			Post pl=optpl.get();
			Tag tag=opttag.get();
			
			Set<Tag> tags=pl.getTag();
			
			if(tags == null)
				tags=new HashSet<Tag>();
			tags.add(tag);
			pl.setTag(tags);
			postRepository.save(pl);
			return true;
		}
		return false;
	}
	public List<Tag> getByName(Collection<String> names){
		return (List<Tag>) tagRepository.findByNameIn(names);
	}
	
	public List<Tag> getAllTags(){
		return (List<Tag>) tagRepository.findAll();
	}
}
