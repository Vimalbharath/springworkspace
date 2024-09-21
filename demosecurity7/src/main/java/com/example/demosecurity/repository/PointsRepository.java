package com.example.demosecurity.repository;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demosecurity.entity.*;


@Repository("pointsRepository")
public interface PointsRepository extends CrudRepository<Point,Integer> {
	
	Optional<Point> findByTeam_teamid(int teamid);
	
}