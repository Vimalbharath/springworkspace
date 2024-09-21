package com.htc.music.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.music.model.Playlist;





@Repository("playlistRepository")
public interface PlaylistRepository extends CrudRepository<Playlist,Integer> {

	
	
	
	
}
