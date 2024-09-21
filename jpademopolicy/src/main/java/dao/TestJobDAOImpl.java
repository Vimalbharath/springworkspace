package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import beans.TestJob;


public class TestJobDAOImpl implements TestJobDAO  {
	
//	static Logger Logg er=LogManager.getLogger(TestUserDAOImpl.class);

	@Override
	public boolean addJob(TestJob job, EntityManager em) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(job);
		tx.commit();
		em.close();
		
	
		return true;
	}

	@Override
	public TestJob getJob(int jobId, EntityManager em) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		TestJob job=em.find(TestJob.class, jobId);
		tx.commit();
		em.close();
		
		// TODO Auto-generated method stub
		return job;
	}

	@Override
	public boolean deleteJob(int jobId, EntityManager em) {
//		 TODO Auto-generated method stub
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		TestJob job=em.find(TestJob.class, jobId);
		
		if(job!=null) {
		em.remove(job);
		tx.commit();
//		em.close();
		return true;
		}
		else {
			tx.rollback();
			
			return false;
		}
	}

	@Override
	public List<TestJob> getJobs(EntityManager em) {
//		EntityTransaction tx=em.getTransaction();
//		tx.begin();
//		TestJob job=em.
//				.find(TestJob.class, tx);
//		List<TestJob> jobs=new ArrayList<TestJob>();
////		while (job!=null) {
////			jobs.add(job);
////		}
////		tx.commit();
////		em.close();
////		return jobs;

//       Query q=em.createQuery("SELECT tu FROM TestJob tu",TestJob.class);
//       return q.getResultList();
		TypedQuery<TestJob> q =em.createQuery("SELECT tu FROM TestJob tu",TestJob.class);
		return q.getResultList();
//		return null;
	}

	@Override
	public boolean updateJob(int jobId, String newDescription, EntityManager em) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		TestJob job=em.find(TestJob.class, jobId);
		
		if(job!=null) {
			job.setDescription(newDescription);
			tx.commit();
			
			return true;
		}
		else {
		tx.rollback();
		
		return false;
		}
	}

}
