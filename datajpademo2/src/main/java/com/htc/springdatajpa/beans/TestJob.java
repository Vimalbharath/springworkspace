package com.htc.springdatajpa.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="jobs")
public class TestJob {
	@Id
	@Column(name="jobid")
	private int jobId;
	
	@Column(name="company")
	private String company;
	
	
	private String description;
	
	private int salary;
	
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
		return "TestJob [jobId=" + jobId + ", company=" + company + ", description=" + description + ", salary="
				+ salary + ", startdate=" + startdate + "]";
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public TestJob(int jobId, String company, String description, int salary, Date startdate) {
		super();
		this.jobId = jobId;
		this.company = company;
		this.description = description;
		this.salary = salary;
		this.startdate = startdate;
	}
	
	
}
