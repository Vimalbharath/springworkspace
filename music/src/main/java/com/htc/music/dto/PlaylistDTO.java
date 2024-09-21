package com.htc.music.dto;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;








public class PlaylistDTO {
	
	@Nonnull
	@Min(1)
	@Max(100)
	private int playlistid;
	@NotBlank(message="playlist Name required")
	@Size(min=3,max=20,message="playlist must be between 3 and 12 character long")
	private String playlistname;
	
	
	
	private Date createddate;
	
	
	UserDTO user;
	
	
	Set<SongDTO> songs;

	public Set<SongDTO> getSong() {
		return songs;
	}

	public void setSong(Set<SongDTO> songs) {
		this.songs = songs;
	}

	public PlaylistDTO() {
		super();
	}

	public PlaylistDTO(int playlistid, String playlistname, Date createddate) {
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
	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Playlist [playlistid=" + playlistid + ", playlistname=" + playlistname + ", createddate=" + createddate
				 + "]";
	}
	
}
