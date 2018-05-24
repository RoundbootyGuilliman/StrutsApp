package com.epam.javalab.strutsapp.dao.impl;

import com.epam.javalab.strutsapp.dao.INewsDAO;
import com.epam.javalab.strutsapp.entity.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.*;

@Component
public class NewsDAO implements INewsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@PreDestroy
	private void destroy() {
		if (sessionFactory != null ) {
			sessionFactory.close();
		}
	}

	@Override
	public List<News> getAllNews() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<News> newsList = session.createQuery("from News").list();

		session.getTransaction().commit();
		session.close();
		return newsList;
	}

	@Override
	public News getNewsById(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		News news = (News) session.createQuery("FROM News WHERE id=:id").setParameter("id", id).uniqueResult();

		session.getTransaction().commit();
		session.close();
		return news;
	}

	@Override
	public void saveNews(News news) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(news);

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteNews(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(getNewsById(id));

		session.getTransaction().commit();
		session.close();
	}
}
