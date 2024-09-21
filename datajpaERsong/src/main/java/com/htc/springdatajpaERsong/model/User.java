package com.htc.springdatajpaERsong.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column(name="userid")
	private int userid;
	private String username;
	private int age;
	private String favactor;
	
	@OneToMany(mappedBy="user")
	Set<Playlist> playlists;

	public User() {
		super();
	}

	public User(int userid, String username, int age, String favactor) {
		super();
		this.userid = userid;
		this.username = username;
		this.age = age;
		this.favactor = favactor;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFavactor() {
		return favactor;
	}

	public void setFavactor(String favactor) {
		this.favactor = favactor;
	}

	public Set<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(Set<Playlist> playlists) {
		this.playlists = playlists;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", age=" + age + ", favactor=" + favactor
				+ ", playlists=" + playlists + "]";
	}
	
	
	
}
