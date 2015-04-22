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
import com.att.ttt.entity.Trainings;


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
	public List<Employee> getUserPresenceList(String emailId) {
		Session currentSession=this.getSessionFactory().getCurrentSession();
		String query = "from Employee e where e.emailId = '"+emailId.trim()+"'";
		Query qry=currentSession.createQuery(query);
		List<Employee> userPresentList =   qry.list();
		System.out.println("employee " + userPresentList.get(0).getEmpId());
		return userPresentList;
	}
	
	@Override
	@Transactional
	public String getUserRoles (String emailId) {
		Session currentSession=this.getSessionFactory().getCurrentSession();
		String query = "select userRole from UserRoles u where u.email = '"+emailId+"'";
		Query qry = currentSession.createQuery(query);
		List<String> userRolesList = qry.list();
		if (!userRolesList.isEmpty())
			return userRolesList.get(0);
		else
			return "";
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
	@Transactional
	public List<Employee> getDeliveryManagersList() {
		Session currentSession = this.getSessionFactory().getCurrentSession();
		String query = "select delmgr, delmgrid from employee group by 1, 2";
		Query qry = currentSession.createQuery(query);
		List<Employee> deliveryManagersList = qry.list();
		return deliveryManagersList;
	}
	@Override
	@Transactional
	public List<String> getAccountvalues() {
		List<String> accountList = new ArrayList<String>();
		Session currentSession = this.getSessionFactory().getCurrentSession();
		Query qry = currentSession
				.createQuery("Select distinct a.accountName from Account a");
		accountList = qry.list();
		return accountList;
	}
	@Override
	@Transactional
	public List<String> getTowervalues() {
		List<String> towerList = new ArrayList<String>();
		Session currentSession = this.getSessionFactory().getCurrentSession();
		Query qry = currentSession
				.createQuery("Select distinct t.towerName from Tower t");
		towerList = qry.list();
		return towerList;
	}
	@Override
	@Transactional
	public List<String> getClustervalues() {
		List<String> clusterList = new ArrayList<String>();
		Session currentSession = this.getSessionFactory().getCurrentSession();
		Query qry = currentSession
				.createQuery("Select distinct c.clusterName from Cluster c");
		clusterList = qry.list();
		return clusterList;
	}
	@Override
	@Transactional
	public List<String> getApplicationvalues() {
		List<String> appList = new ArrayList<String>();
		Session currentSession = this.getSessionFactory().getCurrentSession();
		Query qry = currentSession
				.createQuery("Select distinct ap.applnname from Application ap");
		appList = qry.list();
		return appList;
	}
	
	@Override
	@Transactional
	public void addTraining(Trainings training) {
		// TODO Auto-generated method stub
		Session currentSession=this.getSessionFactory().getCurrentSession();
		currentSession.save(training);
	}
}
