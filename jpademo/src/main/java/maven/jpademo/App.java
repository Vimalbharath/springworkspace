package maven.jpademo;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import beans.TestUser;
import dao.TestUserDAO;
import dao.TestUserDAOImpl;
import util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    
        System.out.println( "Hello World!" );
        
        EntityManagerFactory emf=HibernateUtil.getEntityManagerFactory();
        TestUserDAO dao=new TestUserDAOImpl();
        
//        EntityManager em20 = emf.createEntityManager();
//        boolean result2=dao.addUser(new TestUser(100,"HJgj",2,"trichy",new Date()), em20);
//        System.out.println( result2);
        
        EntityManager em = emf.createEntityManager();
        TestUser user1=dao.getTestUser(123, em);
        System.out.println( user1);
        
        EntityManager em1 = emf.createEntityManager();
        List<TestUser> users=dao.getUsers(em1);
        System.out.println( users);
        
        EntityManager em2 = emf.createEntityManager();
        boolean result=dao.updateUser(123, "chennai", em2);
        System.out.println( result);
        
//        EntityManager em3 = emf.createEntityManager();
//        boolean result1=dao.deleteUser(100, em3);
//        System.out.println( result1);
        
        
        
        
    }
}
