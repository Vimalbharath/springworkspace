package com.htc.springdatajpaER.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.springdatajpaER.model.TestJob;
import com.htc.springdatajpaER.repository.JobRepository;

@Service("jobService")
public class JobService {
	
	@Autowired
	JobRepository jobRepository;
	
	public boolean addJob(TestJob job) {
		if(jobRepository.save(job)!=null)
			return true;
		return false;
	}

	public TestJob getJobById(int id) {
		Optional<TestJob> job=jobRepository.findById(id);
		if(job.isPresent())
			return job.get();
		return null;
	}
	
	public List<TestJob> getAllJobs(){
		return (List<TestJob>) jobRepository.findAll();
	}
	
	public TestJob updateJob(int id,String newrole) {
		Optional<TestJob> optjob=jobRepository.findById(id);
		if(optjob.isPresent()) {
			TestJob job= optjob.get();
			job.setDescription(newrole);
			if(jobRepository.save(job)!=null)
				return job;
		}
			
		return null;
	}
	
	public boolean deleteJob(int id) {
		Optional<TestJob> optjob=jobRepository.findById(id);
		if(optjob.isPresent()) {
			jobRepository.deleteById(id);
				return true;
		}
			
		return false;
	}
	
	public List<TestJob> findByDescription(String Description){
		return (List<TestJob>) jobRepository.findByDescription(Description);
	}
}