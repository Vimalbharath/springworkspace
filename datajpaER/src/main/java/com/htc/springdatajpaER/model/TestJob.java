package com.htc.springdatajpaER.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="testjobs")
public class TestJob {
	@Id
	@Column(name="jobid")
	private int jobId;
	
	@Column(name="company")
	private String company;
	
	
	private String description;
	
	@Column(name="startdate")
	@Temporal(TemporalType.DATE)
	private Date startdate;
	public TestJob() {
		super();
	}
	public TestJob(int jobId, String company, String description, Date startdate) {
		super();
		this.jobId = jobId;
		this.company = company;
		this.description = description;
		this.startdate = startdate;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	@Override
	public String toString() {
		return "TestJob [jobId=" + jobId + ", company=" + company + ", description=" + description + ", startdate="
				+ startdate + "]";
	}
	
}
