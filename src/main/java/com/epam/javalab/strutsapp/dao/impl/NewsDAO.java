package com.epam.javalab.strutsapp.dao.impl;

import com.epam.javalab.strutsapp.dao.INewsDAO;
import com.epam.javalab.strutsapp.entity.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;

@Component("newsDAO")
public class NewsDAO implements INewsDAO {

	private SessionFactory sessionFactory;

	@PostConstruct
	private void init() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			StandardServiceRegistryBuilder.destroy(registry);
			throw new ExceptionInInitializerError(ex);
		}
	}

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
