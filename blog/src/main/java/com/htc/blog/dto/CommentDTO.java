package com.htc.blog.dto;



import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;





public class CommentDTO {
	
	
	private int commentid;
	private String commentdetails;
	
	
	@ManyToOne
	@JoinColumn(name="postid")
	PostDTO post;

	@JsonBackReference
	public PostDTO getPostDTO() {
		return post;
	}

	public void setPostDTO(PostDTO post) {
		this.post = post;
	}

	public CommentDTO() {
		super();
	}

	public CommentDTO(int commentid, String commentdetails) {
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
		return "CommentDTO [commentid=" + commentid + ", commentdetails=" + commentdetails 
				 + "]";
	}
	
	
	
}
