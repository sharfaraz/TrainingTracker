package com.att.ttt.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
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
import com.att.ttt.entity.Trainings;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TrainingsViewAction extends ActionSupport implements SessionAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Emp_Trng> empTrngs = new ArrayList<Emp_Trng>();
	private List<Trainings> trngs = new ArrayList<Trainings>();
	private SessionMap<String,Object> sessionMap;
	List<String> statuses = new ArrayList< String>();
	List<String> FilterTrainingType = new ArrayList<String>();
	List<String> FilterStatus = new ArrayList<String>();
	List<String> FilterLevel = new ArrayList<String>();
	private String selTrainingType;
	private String selTrainingStatus;
	private Date selTrainingStDate;
	private Date selTrainingEndDate;
	private String selLevel;
	private Integer[] trainingId;
	private String empId;

	public List<Trainings> getTrngs() {
		return trngs;
	}

	public void setTrngs(List<Trainings> trngs) {
		this.trngs = trngs;
	}
	
	public Integer[] getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(Integer[] trainingId) {
		this.trainingId = trainingId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public Date getSelTrainingStDate() {
		return selTrainingStDate;
	}

	public void setSelTrainingStDate(Date selTrainingStDate) {
		this.selTrainingStDate = selTrainingStDate;
	}

	public Date getSelTrainingEndDate() {
		return selTrainingEndDate;
	}

	public void setSelTrainingEndDate(Date selTrainingEndDate) {
		this.selTrainingEndDate = selTrainingEndDate;
	}

	public String getSelTrainingType() {
		return selTrainingType;
	}

	public void setSelTrainingType(String selTrainingType) {
		this.selTrainingType = selTrainingType;
	}

	public String getSelTrainingStatus() {
		return selTrainingStatus;
	}

	public void setSelTrainingStatus(String selTrainingStatus) {
		this.selTrainingStatus = selTrainingStatus;
	}

	public List<String> getFilterTrainingType() {
		return FilterTrainingType;
	}

	public void setFilterTrainingType(List<String> filterTrainingType) {
		FilterTrainingType = filterTrainingType;
	}

	public List<String> getFilterStatus() {
		return FilterStatus;
	}

	public void setFilterStatus(List<String> filterStatus) {
		FilterStatus = filterStatus;
	}

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

	
	public List<String> getFilterLevel() {
		return FilterLevel;
	}

	public void setFilterLevel(List<String> filterLevel) {
		FilterLevel = filterLevel;
	}

	public String getSelLevel() {
		return selLevel;
	}

	public void setSelLevel(String selLevel) {
		this.selLevel = selLevel;
	}

	public String updateTrainings() {
		System.out.println("updateTrainigs Called..");
		ServletContext ctx=ServletActionContext.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ctx);
		TrainingTrackerDao dao =(TrainingTrackerDao)context.getBean("TrainingTrackerDao");
		System.out.println("dao created successfully"+empTrngs.size());
		Map<String, Object> session1 = ActionContext.getContext().getSession();
		String emailId = (String)session1.get("email");
		for(Integer i : trainingId){
			System.out.println("STR" + i+empId);
			List<Emp_Trng> et = dao.myTrainingsList(i, emailId);
			et.get(0).setStatus(TTConstants.REQUESTED_FOR_COMPLETION);
			dao.updateEmpTrng(et.get(0));
			/*}
		
		Iterator<Emp_Trng> et = empTrngs.iterator();
		while (et.hasNext()) {
			Emp_Trng empT = et.next();
			System.out.println("we have values to save now");
			dao.updateEmpTrng(empT);
			sessionMap.put("successMsg", "Trainings updated successfully.");*/
			
		}
		return "success";
	}
	/*public String updateTrainingStatus() {
		//System.out.println(trainingId + empId);
		ServletContext ctx=ServletActionContext.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ctx);
		TrainingTrackerDao dao =(TrainingTrackerDao)context.getBean("TrainingTrackerDao");
		dao.updateStatus(trainingId, empId);
		
		return "success";
	}*/
	
	public String displayFilters(){
		
		ServletContext ctx=ServletActionContext.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ctx);
		TrainingTrackerDao dao =(TrainingTrackerDao)context.getBean("TrainingTrackerDao");

		try {
			Map<String, Object> session = ActionContext.getContext().getSession();
			String emailId = (String)session.get("email");
			
			Date date = new Date();
			java.sql.Date currentDate = new java.sql.Date(date.getTime());
			
			System.out.println("date: "+currentDate);
			sessionMap.put("currentDate", currentDate);
			
			FilterTrainingType.add("Mandatory");
			FilterTrainingType.add("Optional");
			
			FilterStatus.add(TTConstants.PENDING);
			FilterStatus.add(TTConstants.COMPLETED);
			FilterStatus.add(TTConstants.REQUESTED_FOR_COMPLETION);
			
			FilterLevel.add(TTConstants.ACCOUNT);
			FilterLevel.add(TTConstants.APPLICATION);
			FilterLevel.add(TTConstants.CLUSTER);
			FilterLevel.add(TTConstants.TOWER);

			statuses.add(TTConstants.PENDING);
			statuses.add(TTConstants.REQUESTED_FOR_COMPLETION);
			statuses.add(TTConstants.COMPLETED);
			
			if(selTrainingStatus == null){
				setSelTrainingStatus(TTConstants.PENDING);
			}
			
			if(selTrainingType == null){
				setSelTrainingType("-1");
			}

			empTrngs = dao.myTrainingsList(emailId, selTrainingStDate, selTrainingEndDate, selTrainingType, selTrainingStatus, selLevel);
			
			if (empTrngs.size() == 0) {
				sessionMap.put("trainingsMsg", "No Trainings to Display!!");
			}
		}
		catch (Exception e){
			e.printStackTrace();
			return "failure";
		}
		
		return "populate";
	}
	
public String displayAllFilters(){
		
		ServletContext ctx=ServletActionContext.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ctx);
		TrainingTrackerDao dao =(TrainingTrackerDao)context.getBean("TrainingTrackerDao");

		try {
			Map<String, Object> session = ActionContext.getContext().getSession();
			String emailId = (String)session.get("email");
			
			//Date date = new Date();
			//java.sql.Date currentDate = new java.sql.Date(date.getTime());
			
			//System.out.println("date: "+currentDate);
			//sessionMap.put("currentDate", currentDate);
			
			FilterTrainingType.add("Mandatory");
			FilterTrainingType.add("Optional");
			
			FilterStatus.add(TTConstants.PENDING);
			FilterStatus.add(TTConstants.COMPLETED);
			FilterStatus.add(TTConstants.REQUESTED_FOR_COMPLETION);
			
			FilterLevel.add(TTConstants.ACCOUNT);
			FilterLevel.add(TTConstants.APPLICATION);
			FilterLevel.add(TTConstants.CLUSTER);
			FilterLevel.add(TTConstants.TOWER);

			statuses.add(TTConstants.PENDING);
			statuses.add(TTConstants.REQUESTED_FOR_COMPLETION);
			statuses.add(TTConstants.COMPLETED);
			
			if(selTrainingStatus == null){
				setSelTrainingStatus(TTConstants.PENDING);
			}
			
			if(selTrainingType == null){
				setSelTrainingType("-1");
			}

			trngs = dao.getAllTrainings();
			System.out.println("trainngs: "+trngs.size());
			
			if (trngs.size() == 0) {
				sessionMap.put("trainingsMsg", "No Trainings to Display!!");
			}
		}
		catch (Exception e){
			e.printStackTrace();
			return "failure";
		}
		
		return "populate";
	}




}
