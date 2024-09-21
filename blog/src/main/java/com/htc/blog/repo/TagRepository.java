package com.htc.blog.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.htc.blog.model.Tag;



@Repository("tagRepository")
public interface TagRepository extends CrudRepository<Tag,Integer> {

	public List<Tag> findByNameIn(Collection<String> names);
	
	
	
}
