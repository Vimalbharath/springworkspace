package com.htc.beans;

public class Company {
	int company_id;
	String name;
	String location;
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Company() {
		super();
	}
	public Company(int company_id, String name, String location) {
		super();
		this.company_id = company_id;
		this.name = name;
		this.location = location;
	}
	public void display(){  
	    System.out.println(company_id+" "+name+" "+location);  
	}
	@Override
	public String toString() {
		return "Company [company_id=" + company_id + ", name=" + name + ", location=" + location + "]";
	}
	
	
}
