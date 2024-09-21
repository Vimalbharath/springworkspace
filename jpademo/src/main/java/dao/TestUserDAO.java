package dao;

import java.util.List;

import javax.persistence.EntityManager;

import beans.TestUser;

public interface TestUserDAO {
	public boolean addUser(TestUser user,EntityManager em);
	public TestUser getTestUser(int userId,EntityManager em);
	public boolean deleteUser(int userId,EntityManager em);
	public List <TestUser> getUsers(EntityManager em);
	public boolean updateUser(int userId,String newAddress,EntityManager em);
	
}
