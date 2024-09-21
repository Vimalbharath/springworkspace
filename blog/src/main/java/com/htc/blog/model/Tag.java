package com.htc.blog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tag")
public class Tag {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tagid")
	private int tagid;
	private String name;
	
	public Tag() {
		super();
	}
	public int getTagid() {
		return tagid;
	}
	public void setTagid(int tagid) {
		this.tagid = tagid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Tag( String name, String movie, String singer) {
		super();
		
		this.name = name;
	
	}
	@Override
	public String toString() {
		return "Tag [tagid=" + tagid + ", name=" + name + "]";
	}
	
}
