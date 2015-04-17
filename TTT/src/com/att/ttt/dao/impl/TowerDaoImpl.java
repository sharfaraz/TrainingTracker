package com.att.ttt.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.att.ttt.dao.TowerDao;
import com.att.ttt.entity.Tower;

public class TowerDaoImpl implements TowerDao {

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
	public Tower getTower(String towerName) {
		// TODO Auto-generated method stub
		Session currentSession = this.getSessionFactory().getCurrentSession();
		String query = "from Tower where towername= '" +towerName+ "'";
		Query qry = currentSession.createQuery(query);
		Tower twr = (Tower)qry.uniqueResult();
		return twr;
	}
	

}
