package com.woho.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.woho.dao.AbstractDAO;
import com.woho.dao.UserDao;
import com.woho.model.UserInformation;

@Repository
public class UserDaoImpl extends AbstractDAO<UserInformation> implements UserDao  {
	
	private static final long serialVersionUID = 1L;
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	SessionFactory sessionFactory;
	
	public UserInformation findByUserId(String userId) {
		Session session  = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			LOG.error("Error caught" + e);
		}
		
		return null;
		
	}
	
	
	public void updateUser(UserInformation user) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Integer id = (Integer)session.save(user);
			System.out.println("User saved with ID : " +id);
			session.getTransaction().commit();
			
		}catch(Exception e) {
			LOG.error(e.getMessage());
		}
	}
	
	public void deleteUser(UserInformation user) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
