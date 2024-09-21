package com.htc.blog.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.blog.model.Post;





@Repository("postRepository")
public interface PostRepository extends CrudRepository<Post,Integer> {

	
	
	
	
}
