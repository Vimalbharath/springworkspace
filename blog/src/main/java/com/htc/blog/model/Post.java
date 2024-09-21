package com.htc.blog.model;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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







@Entity
@Table(name="post")
public class Post {
	
	@Id
	@Column(name="postid")
	private int postid;
	
	private String details;
	
	
	@Temporal(TemporalType.DATE)
	private Date createddate;
	
	@OneToMany(mappedBy="post")
	@JsonManagedReference
	Set<Comment> comments;

	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="posttags",
			joinColumns=@JoinColumn(name="postid"),
			inverseJoinColumns=@JoinColumn(name="tagid")
			)
	Set<Tag> tags;

	public Set<Tag> getTag() {
		return tags;
	}

	public void setTag(Set<Tag> tags) {
		this.tags = tags;
	}

	public Post() {
		super();
	}

	public Post(int postid, String details, Date createddate) {
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
	
	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}


	@Override
	public String toString() {
		return "Post [postid=" + postid + ", details=" + details + ", createddate=" + createddate
				+ ", comments=" + comments + "]";
	}
	
}
