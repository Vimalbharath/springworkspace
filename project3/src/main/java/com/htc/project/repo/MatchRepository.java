package com.htc.project.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.project.model.Match;


@Repository("matchRepository")
public interface MatchRepository extends CrudRepository<Match,Integer> {
	
	
	
}
