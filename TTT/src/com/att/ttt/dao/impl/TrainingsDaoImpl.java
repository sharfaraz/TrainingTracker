package com.att.ttt.dao.impl;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.att.ttt.dao.TrainingsDao;
import com.att.ttt.entity.Trainings;

public class TrainingsDaoImpl implements TrainingsDao {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int loadTrainings(Collection<Trainings> trngCollection) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	@Transactional
	public void saveTraining (Trainings training) {
		// TODO Auto-generated method stub
		Session currentSession = this.getSessionFactory().getCurrentSession();
		currentSession.save(training);
		System.out.println("after save");
//		sessionFactory.openSession().save(employee);
	}
	@Override
	@Transactional
	public void updateTraining (Trainings training) {
		// TODO Auto-generated method stub
		Session currentSession = this.getSessionFactory().getCurrentSession();
		currentSession.saveOrUpdate(training);
//		sessionFactory.openSession().saveOrUpdate(employee);
	}
	
}
