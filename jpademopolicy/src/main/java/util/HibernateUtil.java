package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	
	public static EntityManagerFactory getEntityManagerFactory() {
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("myunit");
	return emf;
	}
}
