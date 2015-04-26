package com.att.ttt.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.ServletContext;

import java.util.Iterator;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;












import com.att.ttt.constants.TTConstants;
import com.att.ttt.dao.TrainingTrackerDao;
import com.att.ttt.entity.Emp_Trng;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TrainingsViewAction extends ActionSupport implements SessionAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Emp_Trng> empTrngs = new ArrayList<Emp_Trng>();
	private SessionMap<String,Object> sessionMap;
	List<String> statuses = new ArrayList< String>();
	
	
	public List<String> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<String> statuses) {
		this.statuses = statuses;
	}

	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}

/*	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}*/
	
	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sessionMap=(SessionMap)map;
	}
	

	public List<Emp_Trng> getEmpTrngs() {
		return empTrngs;
	}

	public void setEmpTrngs(List<Emp_Trng> empTrngs) {
		this.empTrngs = empTrngs;
	}

	public String displayTrainings() {
		String res;
		statuses.add(TTConstants.PENDING);
		statuses.add(TTConstants.IN_PROGRESS);
		statuses.add(TTConstants.COMPLETED);

		ServletContext ctx=ServletActionContext.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ctx);
		TrainingTrackerDao dao =(TrainingTrackerDao)context.getBean("TrainingTrackerDao");

		Map<String, Object> session = ActionContext.getContext().getSession();
		String emailId = (String)session.get("email");

		empTrngs = dao.myTrainingsList(emailId);
		
		System.out.println("trainings :" + empTrngs.size());
		res = "success";
		return res;
	}
	
	public String updateTrainings() {
		System.out.println("updateTrainigs Called..");
		ServletContext ctx=ServletActionContext.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ctx);
		TrainingTrackerDao dao =(TrainingTrackerDao)context.getBean("TrainingTrackerDao");
		System.out.println("dao created successfully"+empTrngs.size());
		
		Iterator<Emp_Trng> et = empTrngs.iterator();
		while (et.hasNext()) {
			Emp_Trng empT = et.next();
			System.out.println("we have values to save now");
			dao.updateEmpTrng(empT);
			sessionMap.put("successMsg", "Trainings updated successfully.");
			
		}
		return "success";
	}

}
