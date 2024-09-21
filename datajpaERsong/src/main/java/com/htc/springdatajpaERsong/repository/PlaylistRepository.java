package com.htc.springdatajpaERsong.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.springdatajpaERsong.model.Playlist;



@Repository("playlistRepository")
public interface PlaylistRepository extends CrudRepository<Playlist,Integer> {
	
	
	
}
