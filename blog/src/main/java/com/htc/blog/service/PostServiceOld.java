package com.htc.blog.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.blog.model.Post;
import com.htc.blog.model.Tag;
import com.htc.blog.model.Comment;
import com.htc.blog.repo.PostRepository;
import com.htc.blog.repo.TagRepository;
import com.htc.blog.repo.CommentRepository;

@Service("postServiceOld")
public class PostServiceOld {
	 
	@Autowired
	PostRepository postRepository;
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	TagRepository tagRepository;
	
	public boolean addPost(Post pl) {
		if(postRepository.save(pl)!=null)
			return true;
		return false;
	}
	
//	public boolean addComment(Comment comment) {
//		if(commentRepository.save(comment)!=null)
//			return true;
//		return false;
//	}
	
	public boolean addComment(int postid,Comment pl) {
		
		Optional<Post> optpost=postRepository.findById(postid);
		if(optpost.isPresent()) {
			Post post=optpost.get();
			pl.setPost(post);
			if(commentRepository.save(pl)!=null)
				return true;
		}
		
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
	
	public List<Tag> getByName(Collection<String> names){
		return (List<Tag>) tagRepository.findByNameIn(names);
	}
	
//	public List<Post> getByageBetween(int upper,int lower){
//		return (List<Post>) postRepository.findByageBetween(upper, lower);
//	}
	public boolean addTag(Tag tag) {
		if(tagRepository.save(tag)!=null)
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
	public List<Tag> getAllTags(){
		return (List<Tag>) tagRepository.findAll();
	}
	public List<Comment> getAllComments(){
		return (List<Comment>) commentRepository.findAll();
	}
}
