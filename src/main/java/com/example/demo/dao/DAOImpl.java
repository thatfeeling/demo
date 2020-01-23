package com.example.demo.dao;


import com.example.demo.Entity.User;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DAOImpl implements DAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private SessionFactory sessionFactory;

	public DAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public boolean varifyUser(String userName, String password) {

		return false;
	}

	@Override
	public void getAllUsers() {
//		Session session = entityManager.unwrap(Session.class);
		Session session = sessionFactory.getCurrentSession();
		
		System.out.println("session: " + session);
		Query<User> query = session.createQuery("from User", User.class);
		
		System.out.println(query.getResultList().get(0));
	
	}

	@Override
	public boolean registerUser(String userName, String password, String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
