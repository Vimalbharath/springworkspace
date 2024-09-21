package com.htc.springdatajpaERsong.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="songs")
public class Songs {
	
	@Id
	@Column(name="songid")
	private int songid;
	private String name;
	private String movie;
	private String singer;
	public Songs() {
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
	public Songs(int songid, String name, String movie, String singer) {
		super();
		this.songid = songid;
		this.name = name;
		this.movie = movie;
		this.singer = singer;
	}
	@Override
	public String toString() {
		return "Songs [songid=" + songid + ", name=" + name + ", movie=" + movie + ", singer=" + singer + "]";
	}
	
}
