package com.att.ttt.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.att.ttt.dao.AccountDao;
import com.att.ttt.entity.Account;

public class AccountDaoImpl implements AccountDao{

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
	public Account getAccount(String accountName) {
		// TODO Auto-generated method stub
		Session currentSession = this.getSessionFactory().getCurrentSession();
		String query = "from Account where accountname= '" +accountName+ "'";
		Query qry = currentSession.createQuery(query);
		Account acc = (Account)qry.uniqueResult();
		return acc;
	}
	
	

}
