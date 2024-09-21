package com.htc.music.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class SongDTO {
	
	

	private int songid;
	private String name;
	private String movie;
	private String singer;
	public SongDTO() {
		super();
	}
	public int getSongid() {
		return songid;
	}
	public void setSongid(int songid) {
		this.songid = songid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public SongDTO( String name, String movie, String singer) {
		super();
		
		this.name = name;
		this.movie = movie;
		this.singer = singer;
	}
	@Override
	public String toString() {
		return "Song [songid=" + songid + ", name=" + name + ", movie=" + movie + ", singer=" + singer + "]";
	}
	
}
