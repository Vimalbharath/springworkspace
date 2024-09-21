package com.example.demosecurity.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demosecurity.entity.*;


@Repository("matchRepository")
public interface MatchRepository extends CrudRepository<Match,Integer> {
	
	
	
}