package com.htc.music.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.music.model.Playlist;
import com.htc.music.model.Song;



@Repository("songRepository")
public interface SongRepository extends CrudRepository<Song,Integer> {

	public List<Song> findByMovieIn(Collection<String> movies);
	
	
	
}
