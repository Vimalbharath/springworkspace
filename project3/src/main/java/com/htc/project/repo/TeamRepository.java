package com.htc.project.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.project.model.Match;
import com.htc.project.model.Team;

@Repository("teamRepository")
public interface TeamRepository extends CrudRepository<Team,Integer> {

	Optional<Team> findByTeamid(Team winner);
	
	
	
}
