package com.htc.music.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;






public class UserDTO {
	

	private int userid;
	private String username;
	private int age;
	private String favactor;
	
	@OneToMany(mappedBy="user")
	@JsonManagedReference
	Set<PlaylistDTO> playlists;

	public UserDTO() {
		super();
	}

	public UserDTO(int userid, String username, int age, String favactor) {
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

	public Set<PlaylistDTO> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(Set<PlaylistDTO> playlists) {
		this.playlists = playlists;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", age=" + age + ", favactor=" + favactor
				+ ", playlists=" + playlists + "]";
	}
	
	
	
}
