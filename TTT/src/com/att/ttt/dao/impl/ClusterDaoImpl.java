package com.att.ttt.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.att.ttt.dao.ClusterDao;
import com.att.ttt.entity.Cluster;

public class ClusterDaoImpl implements ClusterDao{

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
	public Cluster getCluster(String clusterName) {
		// TODO Auto-generated method stub
		Session currentSession = this.getSessionFactory().getCurrentSession();
		String query = "from Cluster where clustername= '" +clusterName+ "'";
		Query qry = currentSession.createQuery(query);
		Cluster cluster = (Cluster)qry.uniqueResult();
		return cluster;
	}
	
	

}
