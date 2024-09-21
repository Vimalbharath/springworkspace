package com.htc.springdatajpaERsong.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;





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
	Set<Songs> songs;

	public Set<Songs> getSongs() {
		return songs;
	}

	public void setSongs(Set<Songs> songs) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Playlist [playlistid=" + playlistid + ", playlistname=" + playlistname + ", createddate=" + createddate
				+ ", user=" + user + "]";
	}
	
}
