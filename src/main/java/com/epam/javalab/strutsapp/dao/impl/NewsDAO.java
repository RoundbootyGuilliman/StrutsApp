package com.epam.javalab.strutsapp.dao.impl;

import com.epam.javalab.strutsapp.dao.INewsDAO;
import com.epam.javalab.strutsapp.entity.News;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NewsDAO implements INewsDAO {

	private static SessionFactory factory;

	public NewsDAO() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	@Override
	public Map<Integer, News> getAllNews() {
		Session session = factory.openSession();
		Transaction tx = null;
		Map<Integer, News> newsMap = new HashMap<>();

		try {
			tx = session.beginTransaction();
			List newsList = session.createQuery("FROM News").list();
			for (Iterator iterator = newsList.iterator(); iterator.hasNext();){
				News news = (News) iterator.next();
				newsMap.put(news.getId(), news);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return newsMap;
	}

	@Override
	public News getNewsById(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		List newsList = null;

		try {
			tx = session.beginTransaction();
			newsList = session.createQuery("FROM News WHERE id=0").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return (News) newsList.get(0);
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
