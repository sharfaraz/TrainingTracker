package com.att.ttt.dao.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.att.ttt.dao.TrainingTrackerDao;



public class InitAddAssignTrainingImpl {
	
	ServletContext ctx=ServletActionContext.getServletContext();
	WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ctx);
    
    TrainingTrackerDao trDao=(TrainingTrackerDao)context.getBean("TrainingTrackerDaoImpl");
	
	
	public List<String> getAllAccounts(){
		List<String> accounts = new ArrayList<String>();
		accounts =  trDao.getAccountvalues();
		return accounts;
	}
	
	public List<String> getAllTowers(){
		List<String> towers = new ArrayList<String>();
		towers =  trDao.getTowervalues();
		return towers;
	}
	
	public List<String> getAllClusters(){
		List<String> clusters = new ArrayList<String>();
		clusters =  trDao.getClustervalues();
		return clusters;
	}
  
}
