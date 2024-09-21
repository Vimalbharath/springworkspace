package com.example.demosecurity.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demosecurity.entity.*;


@Repository("detailsRepository")
public interface DetailsRepository extends CrudRepository<Details,Integer> {
	
	Details findByMatch_matchid(int matchid);
	
}