package com.htc.springdatajpa.main;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.htc.springdatajpa.beans.TestJob;
import com.htc.springdatajpa.config.JPAConfig;
import com.htc.springdatajpa.service.JobService;

public class ProjectMain {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(JPAConfig.class);
		
		JobService jobService=(JobService) context.getBean("jobService");
		
		boolean result=false;
//		result=jobService.addJob(new TestJob(105,"Microsoft","HR",190,new Date()));
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
		
		
	}
}
