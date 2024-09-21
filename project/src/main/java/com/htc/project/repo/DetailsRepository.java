package com.htc.project.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.project.model.Details;


@Repository("detailsRepository")
public interface DetailsRepository extends CrudRepository<Details,Integer> {
	
	Details findByMatch_matchid(int matchid);
	
}
