package main;

import java.util.Date;
import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import beans.TestJob;

import dao.TestJobDAO;
import dao.TestJobDAOImpl;

import util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	final Logger Logger=LogManager.getLogger(App.class);
  
    
        System.out.println( "Hello World!" );
        
        EntityManagerFactory emf=HibernateUtil.getEntityManagerFactory();
        TestJobDAO dao=new TestJobDAOImpl();
        
//        EntityManager em0 = emf.createEntityManager();
//        boolean result2=dao.addJob(new TestJob(100,"Microsoft","HR",new Date()), em0);
//        System.out.println( result2);
        
        
        
        EntityManager em1 = emf.createEntityManager();
        List<TestJob> jobs=dao.getJobs(em1);
        System.out.println( jobs);
        
        EntityManager em2 = emf.createEntityManager();
        boolean result=dao.updateJob(124, "CEO", em2);
        System.out.println( result);
        
//        EntityManager em3 = emf.createEntityManager();
//        boolean result1=dao.deleteJob(100, em3);
//        System.out.println( result1);
        
        EntityManager em4 = emf.createEntityManager();
        TestJob job1=dao.getJob(123, em4);
        System.out.println( job1);
        Logger.info(jobs+"Hi");
        //.info("Hello");
        
        
        
    }
}
