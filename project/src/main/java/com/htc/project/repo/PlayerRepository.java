package com.htc.project.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.project.model.Player;


@Repository("playerRepository")
public interface PlayerRepository extends CrudRepository<Player,Integer> {

	int countByTeam_teamid(int teamid);

	
	
	
	
}
