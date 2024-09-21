package main;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class jpademo {
	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("myunit");
		EntityManager em = emf.createEntityManager();
		System.out.println( em.find(jpademo.class,123));
	}
}
