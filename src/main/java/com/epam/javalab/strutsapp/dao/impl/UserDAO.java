package com.epam.javalab.strutsapp.dao.impl;

import com.epam.javalab.strutsapp.dao.IUserDAO;
import com.epam.javalab.strutsapp.entity.News;
import com.epam.javalab.strutsapp.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.List;

@Component
public class UserDAO implements IUserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@PreDestroy
	private void destroy() {
		if (sessionFactory != null ) {
			sessionFactory.close();
		}
	}

	@Override
	public void saveUser(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(user);

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<User> getAllUsers() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<User> newsList = session.createQuery("from User").list();

		session.getTransaction().commit();
		session.close();
		return newsList;
	}

	@Override
	public void deleteUser(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(getUser(id));

		session.getTransaction().commit();
		session.close();
	}

	private User getUser(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		User user = (User) session.createQuery("FROM User WHERE id=:id").setParameter("id", id).uniqueResult();

		session.getTransaction().commit();
		session.close();
		return user;
	}
}