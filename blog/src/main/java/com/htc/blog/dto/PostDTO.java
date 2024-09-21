package com.htc.blog.dto;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;








public class PostDTO {
	
	@Nonnull
	@Min(1)
	@Max(100)
	private int postid;
	@NotBlank(message="Details required")
	@Size(min=3,max=20,message="Details must be between 3 and 12 character long")
	private String details;
	
	
	
	private Date createddate;
	
	@OneToMany(mappedBy="post")
	@JsonManagedReference
	Set<CommentDTO> comments;

	
	
	Set<TagDTO> tags;

	public Set<TagDTO> getTagDTO() {
		return tags;
	}

	public void setTagDTO(Set<TagDTO> tags) {
		this.tags = tags;
	}

	public PostDTO() {
		super();
	}

	public PostDTO(int postid, String details, Date createddate) {
		super();
		this.postid = postid;
		this.details = details;
		this.createddate = createddate;
	}

	public int getPostid() {
		return postid;
	}

	public void setPostid(int postid) {
		this.postid = postid;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	
	public Set<CommentDTO> getCommentDTOs() {
		return comments;
	}

	public void setCommentDTOs(Set<CommentDTO> comments) {
		this.comments = comments;
	}


	@Override
	public String toString() {
		return "Post [postid=" + postid + ", details=" + details + ", createddate=" + createddate
				+ ", comments=" + comments + "]";
	}
	
}
