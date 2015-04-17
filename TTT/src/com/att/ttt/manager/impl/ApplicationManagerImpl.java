package com.att.ttt.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.att.ttt.dao.ApplicationDao;
import com.att.ttt.entity.Application;
import com.att.ttt.manager.ApplicationManager;

public class ApplicationManagerImpl implements ApplicationManager {
	
	private ApplicationDao applicationDao;	

	public ApplicationDao getApplicationDao() {
		return applicationDao;
	}

	@Autowired
	public void setApplicationDao(ApplicationDao applicationDao) {
		this.applicationDao = applicationDao;
	}


	@Override
	public Application fetchApplication(String appName) {
		System.out.println("In fetch application");
		Application app = new Application();
		app = applicationDao.getApplication(appName);
		return app;	
	}

}
