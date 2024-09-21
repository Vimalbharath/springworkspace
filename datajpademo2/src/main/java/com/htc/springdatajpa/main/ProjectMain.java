package com.htc.springdatajpa.main;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.htc.springdatajpa.beans.TestJob;
import com.htc.springdatajpa.config.JPAConfig;
import com.htc.springdatajpa.service.JobService;



public class ProjectMain {
	public static void main(String[] args) {
		final Logger Logger=LogManager.getLogger(ProjectMain.class);
		Logger.info("Hi Vimal");
		ApplicationContext context=new AnnotationConfigApplicationContext(JPAConfig.class);
		
		JobService jobService=(JobService) context.getBean("jobService");
		
		boolean result=false;
//		result=jobService.addJob(new TestJob(102,"Microsoft","HR",new Date()));
//		System.out.println(result);
		TestJob job = jobService.updateJob(101, "CEO");
		System.out.println(job);
		job= jobService.getJobById(100);
		System.out.println(job);
		List<TestJob> jobs=jobService.getAllJobs();
		System.out.println(jobs);
//		result=jobService.deleteJob(101);
//		System.out.println(result);
		List<TestJob> jobs1=jobService.getAllJobs();
		System.out.println(jobs1);
		List<TestJob> jobs2=jobService.findByDescription("Manager");
		System.out.println(jobs2);
		List<TestJob> jobs3=jobService.findBysalaryBetween(120,210);
		System.out.println(jobs3);
		List<String> companies=Arrays.asList("Google","Microsoft");
		List<TestJob> jobs4=jobService.findByCompanyIn(companies);
		System.out.println(jobs4);
		List<TestJob> jobs5=jobService.findByCompAndSal("Microsoft", 120);
		System.out.println(jobs5);
		
		
		List<Object[]> jobs6=jobService.getJobsbyComp();
		System.out.println(jobs6);
		for(Object[] row : jobs6) {
			String comp=(String)row[0];
			Long tot=(Long)row[1];
			System.out.println("Company Name : " + comp + " Jobs Offered : "+ tot );
		}
		
	}
}
