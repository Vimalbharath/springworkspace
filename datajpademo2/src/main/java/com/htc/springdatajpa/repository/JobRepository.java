package com.htc.springdatajpa.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.htc.springdatajpa.beans.TestJob;

@Repository("jobRepository")
public interface JobRepository extends CrudRepository<TestJob,Integer> {
	
	public List<TestJob> findByDescription(String Description);
	
	public List<TestJob> findBysalaryBetween(int upper,int lower);
	
	public List<TestJob> findByCompanyIn(Collection<String> companies);
	
	//class  name not table 
	
	@Query("SELECT j from TestJob j WHERE j.company = :companys AND j.salary > :salarys")
	public List<TestJob> findByCompAndSal(@Param("companys") String company,
	                                      @Param("salarys") int salary);
	
	@Query("select j.company,count(j.company) from TestJob j group by company ")
	public List<Object[]> getJobsbyComp();
	
}
