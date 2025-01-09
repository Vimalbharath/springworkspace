package com.kabadi.project.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kabadi.project.entity.Player;



@Repository("playerRepository")
public interface PlayerRepository extends CrudRepository<Player,Integer> {

	int countByTeam_teamid(int teamid);

	Optional<Player> findByPlayerId(Player manOfTheMatch);

	
	
	
	
}
