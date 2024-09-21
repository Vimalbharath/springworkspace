package main;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import beans.TestJob;

public class Demo {
	static final Logger Logger=LogManager.getLogger(Demo.class);
	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("myunit");
		EntityManager em = emf.createEntityManager();
		System.out.println( em.find(TestJob.class,123));
		Logger.info("Hello");
	}
}
