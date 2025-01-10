package com.kabadi.project.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kabadi.project.entity.*;


@Repository("matchRepository")
public interface MatchRepository extends CrudRepository<Match,Integer> {
	
	
	
}