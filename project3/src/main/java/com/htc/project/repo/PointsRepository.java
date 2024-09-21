package com.htc.project.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.project.model.Details;
import com.htc.project.model.Point;
import com.htc.project.model.Team;


@Repository("pointsRepository")
public interface PointsRepository extends CrudRepository<Point,Integer> {
	
	Optional<Point> findByTeam_teamid(int teamid);
	
}
