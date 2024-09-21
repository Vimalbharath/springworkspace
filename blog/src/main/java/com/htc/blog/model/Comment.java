package com.htc.blog.model;



import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;





@Entity
@Table(name="comment")
public class Comment {
	
	@Id
	@Column(name="commentid")
	private int commentid;
	private String commentdetails;
	
	
	@ManyToOne
	@JoinColumn(name="postid")
	Post post;

	@JsonBackReference
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Comment() {
		super();
	}

	public Comment(int commentid, String commentdetails) {
		super();
		this.commentid = commentid;
		this.commentdetails = commentdetails;
	
	}

	public int getCommentid() {
		return commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	public String getCommentdetails() {
		return commentdetails;
	}

	public void setCommentdetails(String commentdetails) {
		this.commentdetails = commentdetails;
	}

	

	
	@Override
	public String toString() {
		return "Comment [commentid=" + commentid + ", commentdetails=" + commentdetails 
				 + "]";
	}
	
	
	
}
