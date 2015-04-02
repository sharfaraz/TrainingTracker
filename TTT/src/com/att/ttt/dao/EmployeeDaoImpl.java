package com.att.ttt.dao;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.att.ttt.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private SessionFactory sessionFactory;
	private HibernateTemplate hibernateTemplate;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int loadEmployees(Collection<Employee> empCollection) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session currentSession = this.getSessionFactory().getCurrentSession();
		currentSession.save(employee);
		System.out.println("after save");
//		sessionFactory.openSession().save(employee);
	}
	@Override
	@Transactional
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session currentSession = this.getSessionFactory().getCurrentSession();
		currentSession.saveOrUpdate(employee);
//		sessionFactory.openSession().saveOrUpdate(employee);
	}
	
}
