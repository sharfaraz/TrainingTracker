package com.att.ttt.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.att.ttt.dao.EmployeeDao;
import com.att.ttt.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private SessionFactory sessionFactory;
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
	@Override
	@Transactional
	public Boolean cleanEmpTable() {
		// TODO Auto-generated method stub
		try {
			Session currentSession = this.getSessionFactory().getCurrentSession();
			Query qry = currentSession
					.createQuery(" delete from Employee");
			qry.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	@Override
	@Transactional
	public List<String> getEmployeeIds( ) {
		// TODO Auto-generated method stub
		List<String> empId = null;
		try {
			Session currentSession = this.getSessionFactory().getCurrentSession();
			Query qry = currentSession
					.createQuery(" select empId from Employee order by empId");
			empId = qry.list();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return empId;
	}
	
}
