package com.htc.entity;

import java.util.Date;

public class Job {
	public int id;
	public String code;
	public int job_type_id;
	public Date posted_date;
	public Date start_date;
	public int employees_needed;
	public String descripton;
	public int company_id;
	public Date date_process_started;
	
	Date today=86400;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Job() {
		super();
	}

	public static void main(String[] args) {
		Job j= new Job();
		j.setId(20);
		j.setStart_date(2023+02+02);
		System.out.println(j.getId());
	}
}
