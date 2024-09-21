package com.example.demosecurity.repository;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demosecurity.entity.*;

@Repository("teamRepository")
public interface TeamRepository extends CrudRepository<Team,Integer> {

	Optional<Team> findByTeamid(Team winner);
	
	
	
}