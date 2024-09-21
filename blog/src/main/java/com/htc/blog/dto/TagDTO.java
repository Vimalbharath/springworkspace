package com.htc.blog.dto;




public class TagDTO {
	

	private int tagid;
	private String name;
	
	public TagDTO() {
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
	
	public TagDTO( String name, String movie, String singer) {
		super();
		
		this.name = name;
	
	}
	@Override
	public String toString() {
		return "Tag [tagid=" + tagid + ", name=" + name + "]";
	}
	
}
