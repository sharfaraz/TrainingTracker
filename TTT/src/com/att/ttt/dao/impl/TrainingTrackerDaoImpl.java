package com.att.ttt.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.att.ttt.dao.TrainingTrackerDao;
import com.att.ttt.entity.Emp_Trng;
import com.att.ttt.entity.Employee;


public class TrainingTrackerDaoImpl implements TrainingTrackerDao{

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	@Transactional
	public ArrayList<Employee> getUserPresenceList(String emailId) {
		Session currentSession=this.getSessionFactory().getCurrentSession();
		String query = "from Employee e where e.emailId = '"+emailId+"'";
		Query qry=currentSession.createQuery(query);
		List<Employee> userPresentList =   qry.list();
		return (ArrayList<Employee>) userPresentList;
	}
	
	@Override
	@Transactional
	public ArrayList<String> getUserRoles (String emailId) {
		Session currentSession=this.getSessionFactory().getCurrentSession();
		String query = "select userRole from Users u where u.email = '"+emailId+"'";
		Query qry = currentSession.createQuery(query);
		List<String> userRolesList = qry.list();
		return (ArrayList<String>) userRolesList;
	}
	
	@Override
	@Transactional
	public List<Emp_Trng> myTrainingsList(String empId) {
		Session currentSession=this.getSessionFactory().getCurrentSession();
		String query = "from Emp_Trng et where et.empId = '"+empId+"'";
		Query qry=currentSession.createQuery(query);
		List<Emp_Trng> myTrainingsList =   qry.list();
		return myTrainingsList;
	}
	@Override
	public List<Employee> getDeliveryManagersList() {
		Session currentSession = this.getSessionFactory().getCurrentSession();
		String query = "select delmgr, delmgrid from employee group by 1, 2";
		Query qry = currentSession.createQuery(query);
		List<Employee> deliveryManagersList = qry.list();
		return deliveryManagersList;
	}
	
	@Override
	public String getLevelId(String level, String levelItem) {
		Session currentSession = this.getSessionFactory().getCurrentSession();
		String query = "from "+level+" where applnname = '"+levelItem+"'";
		Query qry = currentSession.createQuery(query);
		String id = qry.getQueryString();
		return id;	
	}
	
}
