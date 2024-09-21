package dao;

import java.util.List;

import javax.persistence.EntityManager;

import beans.TestJob;



public interface TestJobDAO {
	public boolean addJob(TestJob job,EntityManager em);
	public TestJob getJob(int jobId,EntityManager em);
	public boolean deleteJob(int jobId,EntityManager em);
	public List <TestJob> getJobs(EntityManager em);
	public boolean updateJob(int jobId,String newdescription,EntityManager em);
	
}
