package com.att.ttt.action;

import com.att.ttt.entity.Emp_Trng;
import com.att.ttt.dao.TrainingTrackerDao;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;



public class UserTraingsAction extends ActionSupport implements SessionAware {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * @see ActionSupport#ActionSupport()
     */
	private SessionMap<String, Object> sessionMap;
	private String emp;
	List<Emp_Trng> myTrainingsList = new ArrayList<Emp_Trng>();
	
	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}
	
	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	
	public String getEmp() {
		return emp;
	}

	public void setEmp(String emp) {
		this.emp = emp;
	}

	public List<Emp_Trng> getMyTrainingsList() {
		return myTrainingsList;
	}

	public void setMyTrainingsList(List<Emp_Trng> myTrainingsList) {
		this.myTrainingsList = myTrainingsList;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionMap = (SessionMap<String, Object>) arg0;	
	}
	
	public String myTrainingsList(){
		String empId = emp.toString();
		String res = "failure";
		ServletContext ctx = ServletActionContext.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(ctx);
		sessionMap.put("emp", empId);
		TrainingTrackerDao trainingTracker = (TrainingTrackerDao) context
				.getBean("TrainingTrackerDaoImpl");
		myTrainingsList = trainingTracker.myTrainingsList(empId);
		System.out.println(myTrainingsList);
		if (myTrainingsList.size() != 0) {
			res = "success";
			
		}
		return res;
	}
	
	public String myArchiveTrainingsList(){
		String res = "failure";
		return res;
	}
	
	public String uploadTrainingList(){
		String res = "failure";
		return res;
	}

}  
