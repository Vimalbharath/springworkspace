package com.htc.springdatajpaERsong.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.htc.springdatajpaERsong.model.Songs;


@Repository("songsRepository")
public interface SongsRepository extends CrudRepository<Songs,Integer> {
	
	
	
}
