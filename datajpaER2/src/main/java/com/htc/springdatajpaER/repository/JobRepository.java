package com.htc.springdatajpaER.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.springdatajpaER.model.TestJob;

@Repository("jobRepository")
public interface JobRepository extends CrudRepository<TestJob,Integer> {
	
	public List<TestJob> findByDescription(String Description);
	
}
