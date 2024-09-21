package com.htc.beans;



public class Job {
	public int id;
	public String descripton;
	public Company company;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripton() {
		return descripton;
	}
	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Job(int id, String descripton, Company company) {
		super();
		this.id = id;
		this.descripton = descripton;
		this.company = company;
	}
	public Job() {
		super();
	}
	public void display() {
		// TODO Auto-generated method stub
		 System.out.println(id+" "+descripton+" "+company);
	}
	
	
	
}
