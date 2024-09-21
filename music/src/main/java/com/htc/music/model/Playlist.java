package com.htc.music.model;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;







@Entity
@Table(name="playlist")
public class Playlist {
	
	@Id
	@Column(name="playlistid")
	private int playlistid;
	
	private String playlistname;
	
	
	@Temporal(TemporalType.DATE)
	private Date createddate;
	
	@ManyToOne
	@JoinColumn(name="userid")
	User user;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="playlistsongs",
			joinColumns=@JoinColumn(name="playlistid"),
			inverseJoinColumns=@JoinColumn(name="songid")
			)
	Set<Song> songs;

	public Set<Song> getSong() {
		return songs;
	}

	public void setSong(Set<Song> songs) {
		this.songs = songs;
	}

	public Playlist() {
		super();
	}

	public Playlist(int playlistid, String playlistname, Date createddate) {
		super();
		this.playlistid = playlistid;
		this.playlistname = playlistname;
		this.createddate = createddate;
	}

	public int getPlaylistid() {
		return playlistid;
	}

	public void setPlaylistid(int playlistid) {
		this.playlistid = playlistid;
	}

	public String getPlaylistname() {
		return playlistname;
	}

	public void setPlaylistname(String playlistname) {
		this.playlistname = playlistname;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	
	@JsonBackReference
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Playlist [playlistid=" + playlistid + ", playlistname=" + playlistname + ", createddate=" + createddate
				 + "]";
	}
	
}
