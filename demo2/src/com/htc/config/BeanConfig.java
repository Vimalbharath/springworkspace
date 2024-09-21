package com.htc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.htc.beans.Company;
import com.htc.beans.Job;

@Configuration
public class BeanConfig {
//	@Bean(name="comp")
	@Bean("comp")
	public Company getCompany() {
		Company comp=new Company();
		comp.setCompany_id(01);
		comp.setLocation("Bangalore");
		comp.setName("Google");
		return comp;
	}
	@Bean("job")
	public Job getJob() {
		Job job = new Job();
		job.setId(01);
		job.setDescripton("Manager");
		job.setCompany(getCompany());
		return job;
	}
	@Bean("job2")
	public Job getJob2() {
		Job job = new Job();
		job.setId(02);
		job.setDescripton("Engineer");
		job.setCompany(getCompany());
		return job;
	}
}