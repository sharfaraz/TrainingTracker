package com.att.ttt.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.att.ttt.dao.ApplicationDao;
import com.att.ttt.entity.Application;

public class ApplicationDaoImpl implements ApplicationDao {

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
	public Application getApplication(String appName) {
		// TODO Auto-generated method stub
		Session currentSession = this.getSessionFactory().getCurrentSession();
		String query = "from Application where applnname= '" +appName+ "'";
		Query qry = currentSession.createQuery(query);
		Application app = (Application)qry.uniqueResult();
		return app;
	}

}
