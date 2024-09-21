package com.htc.blog.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.blog.model.Comment;





@Repository("commentRepository")
public interface CommentRepository extends CrudRepository<Comment,Integer> {
	
	
	
}
