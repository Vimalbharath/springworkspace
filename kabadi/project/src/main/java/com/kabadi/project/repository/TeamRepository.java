package com.kabadi.project.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kabadi.project.entity.Team;



@Repository("teamRepository")
public interface TeamRepository extends CrudRepository<Team,Integer> {

	Optional<Team> findByTeamid(Team winner);
	
	
	
}
