package com.epam.javalab.strutsapp.dao.impl;

import com.epam.javalab.strutsapp.dao.INewsDAO;
import com.epam.javalab.strutsapp.entity.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
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

//	/* Method to CREATE an employee in the database */
//	public Integer addEmployee(String fname, String lname, int salary){
//		Session session = factory.openSession();
//		Transaction tx = null;
//		Integer employeeID = null;
//
//		try {
//			tx = session.beginTransaction();
//			Employee employee = new Employee(fname, lname, salary);
//			employeeID = (Integer) session.save(employee);
//			tx.commit();
//		} catch (HibernateException e) {
//			if (tx!=null) tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//		return employeeID;
//	}


	/* Method to UPDATE salary for an employee */
//	public void updateEmployee(Integer EmployeeID, int salary ){
//		Session session = factory.openSession();
//		Transaction tx = null;
//
//		try {
//			tx = session.beginTransaction();
//			Employee employee = (Employee)session.get(Employee.class, EmployeeID);
//			employee.setSalary( salary );
//			session.update(employee);
//			tx.commit();
//		} catch (HibernateException e) {
//			if (tx!=null) tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
////	}
//
//	/* Method to DELETE an employee from the records */
//	public void deleteEmployee(Integer EmployeeID){
//		Session session = factory.openSession();
//		Transaction tx = null;
//
//		try {
//			tx = session.beginTransaction();
//			Employee employee = (Employee)session.get(Employee.class, EmployeeID);
//			session.delete(employee);
//			tx.commit();
//		} catch (HibernateException e) {
//			if (tx!=null) tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//	}
}
