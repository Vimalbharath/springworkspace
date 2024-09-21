package dao;

import java.util.List;
import java.util.logging.LogManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import beans.TestUser;

public class TestUserDAOImpl implements TestUserDAO  {
	
	//static Logger Logger=LogManager.getLogger(TestUserDAOImpl.class);

	@Override
	public boolean addUser(TestUser user, EntityManager em) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(user);
		tx.commit();
		em.close();
		
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public TestUser getTestUser(int userId, EntityManager em) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		TestUser user=em.find(TestUser.class, userId);
		tx.commit();
		em.close();
		
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public boolean deleteUser(int userId, EntityManager em) {
		// TODO Auto-generated method stub
//		EntityTransaction tx=em.getTransaction();
//		tx.begin();
//		TestUser user=em.find(TestUser.class, userId);
//		em.remove(user);
//		tx.commit();
//		em.close();add if else
		return true;
	}

	@Override
	public List<TestUser> getUsers(EntityManager em) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(int userId, String newAddress, EntityManager em) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		TestUser user=em.find(TestUser.class, userId);
		
		if(user!=null) {
			user.setAddress(newAddress);
			tx.commit();
			
			return true;
		}
		else {
		tx.rollback();
		
		return true;
		}
	}

}
