package com.att.ttt.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;

import org.apache.catalina.core.ApplicationContext;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.att.ttt.constants.TTConstants;
import com.att.ttt.dao.TrainingTrackerDao;
import com.att.ttt.dao.TrainingsDao;
import com.att.ttt.dao.impl.InitAddAssignTrainingImpl;
import com.att.ttt.entity.Emp_Trng;
import com.att.ttt.entity.Trainings;
import com.att.ttt.utility.WebApp;
import com.opensymphony.xwork2.ActionSupport;

public class CreateTrainingAction extends ActionSupport implements SessionAware {
	private String NewTrainingName;
	private SessionMap<String, Object> sessionMap;

	private ArrayList<String> NewTrainingType = new ArrayList<String>();
	private ArrayList<String> NewCategoryType = new ArrayList<String>();
	private ArrayList<String> AssignedTo = new ArrayList<String>();
	private ArrayList<String> AssignedValue = new ArrayList<String>();
	private String NewTrainingStDt;
	private String NewTrainingEndDt;
	private String NewExtendedDt;
	

	private String TrainingTypeData = "Mandatory,Optional";
	private String CategoryTypedata = "L&K,External,Internal,AT&T Academy,Other";

	private ArrayList<String> dataList;

	private List<String> applicableForData = new ArrayList<String>();

	private String trainingType;
	private String trainingCateg;
	private String assignedType;
	private String assignedKey;

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<String> getDataList() {
		return dataList;
	}

	public void setDataList(ArrayList<String> dataList) {
		this.dataList = dataList;
	}

	public String getNewTrainingName() {
		return NewTrainingName;
	}

	public void setNewTrainingName(String newTrainingName) {
		NewTrainingName = newTrainingName;
	}


	public ArrayList<String> getNewTrainingType() {
		return NewTrainingType;
	}

	public void setNewTrainingType(ArrayList<String> newTrainingType) {
		NewTrainingType = newTrainingType;
	}

	public ArrayList<String> getNewCategoryType() {
		return NewCategoryType;
	}

	public void setNewCategoryType(ArrayList<String> newCategoryType) {

		NewCategoryType = newCategoryType;
	}

	public ArrayList<String> getAssignedTo() {
		return AssignedTo;
	}

	public void setAssignedTo(ArrayList<String> assignedTo) {

		AssignedTo = assignedTo;
	}

	public ArrayList<String> getAssignedValue() {
		return AssignedValue;
	}

	public void setAssignedValue(ArrayList<String> assignedValue) {
		AssignedValue = assignedValue;
	}

	public String getNewTrainingStDt() {
		return NewTrainingStDt;
	}

	public void setNewTrainingStDt(String newTrainingStDt) {
		NewTrainingStDt = newTrainingStDt;
	}

	public String getNewTrainingEndDt() {
		return NewTrainingEndDt;
	}

	public void setNewTrainingEndDt(String newTrainingEndDt) {
		NewTrainingEndDt = newTrainingEndDt;
	}

	public String getNewExtendedDt() {
		return NewExtendedDt;
	}

	public void setNewExtendedDt(String newExtendedDt) {
		NewExtendedDt = newExtendedDt;
	}

	public String getTrainingTypeData() {
		return TrainingTypeData;
	}

	public void setTrainingTypeData(String trainingTypeData) {
		TrainingTypeData = trainingTypeData;
	}

	public String getCategoryTypedata() {
		return CategoryTypedata;
	}

	public void setCategoryTypedata(String categoryTypedata) {
		CategoryTypedata = categoryTypedata;
	}

	public String getAssignedType() {
		return assignedType;
	}

	public void setAssignedType(String assignedType) {
		this.assignedType = assignedType;
	}

	public String getTrainingType() {
		return trainingType;
	}

	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}

	public String getTrainingCateg() {
		return trainingCateg;
	}

	public void setTrainingCateg(String trainingCateg) {
		this.trainingCateg = trainingCateg;
	}

	

	public List<String> getApplicableForData() {
		return applicableForData;
	}

	public void setApplicableForData(List<String> applicableForData) {
		this.applicableForData = applicableForData;
	}

	public String getAssignedKey() {
		return assignedKey;
	}

	public void setAssignedKey(String assignedKey) {
		this.assignedKey = assignedKey;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap) map;

	}

	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	
	public String populateAssignedValue()
	{
	
		ServletContext ctx=ServletActionContext.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ctx);
		
		TrainingTrackerDao trDao=(TrainingTrackerDao)context.getBean("TrainingTrackerDao");

		if(assignedType.equals(TTConstants.ACCOUNT))
		{

			applicableForData=trDao.getAccountvalues();

		}
		else if(assignedType.equals(TTConstants.TOWER))
		{
			applicableForData=trDao.getTowervalues();
		}
		else if(assignedType.equals(TTConstants.CLUSTER))
		{
			applicableForData=trDao.getClustervalues();
		}
		else if(assignedType.equals(TTConstants.APPLICATION))
		{
			applicableForData=trDao.getApplicationvalues();
		}
		
		return "success"; 

	}


	
	  public String createTraining() {
	  
	ServletContext ctx = ServletActionContext.getServletContext();
			WebApplicationContext context = WebApplicationContextUtils
					.getWebApplicationContext(ctx);
			
			
	  TrainingTrackerDao
	  trainingOperation=(TrainingTrackerDao)context.getBean("TrainingTrackerDao"); 
	  Trainings training=(Trainings)context.getBean("Trainings");
	  Emp_Trng empTrng=(Emp_Trng)context.getBean("Emp_Trng");
	
	  training.setTrainingName(NewTrainingName);
	  training.setTrainingType(trainingType);
	  training.setCategoryType(trainingCateg);
	  training.setLevelId(assignedType);
	  training.setLevelName(assignedKey);
	  training.setStartDate(StringtoDate(NewTrainingStDt));
	  training.setEndDate(StringtoDate(NewTrainingEndDt));
	  
	  
	  trainingOperation.addTraining(training);
	  
	  if (trainingType.equals("Mandatory")) {
		  
		    //empTrng.setEmpId("05487M");
			empTrng.setTrainingId(training.getTrainingId().toString());
			empTrng.setStartDate(training.getStartDate());
			empTrng.setEndDate(training.getEndDate());
			empTrng.setStatus(TTConstants.PENDING);
			//empTrng.setEtId("2");
			
			List<String> employeeList = trainingOperation.getEmployees(training.getLevelName(), training.getLevelId());
	    	for (int i=0; i<employeeList.size(); i++){
	    	empTrng.setEmpId(employeeList.get(i));
	    	trainingOperation.assignTrainings(empTrng);    	
	    	}
		  
	  }
		    /*if(assignedType.equals(TTConstants.APPLICATION)) {
			  
		    	System.out.println("passing to assignTrainings");
		    	trainingOperation.assignTrainings(empTrng);
			  
		    } 
		    else if(assignedType.equals(TTConstants.CLUSTER)) {
				  
		    	trainingOperation.assignTrainings(empTrng);
				  
			} 
		    else if(assignedType.equals(TTConstants.TOWER)) {
				  
		    	List<String> employeeList = trainingOperation.getEmployees(training.getLevelName(), training.getLevelId());
		    	for (int i=0; i<employeeList.size(); i++){
		    	empTrng.setEmpId(employeeList.get(i));
		    	trainingOperation.assignTrainings(empTrng);
		    	}
				  
		    } 
		    else if(assignedType.equals(TTConstants.ACCOUNT)) {
				  
		    	trainingOperation.assignTrainings(empTrng);
				  
		    }*/	 
	/*  System.out.println("selectedValue:"+assignedKey);
	  
	  System.out.println("taringin added :"+training.getTrainingId());
	  
	  System.out.println("assignedType:"+assignedType);
	  
	  List<Training> trainingList=new ArrayList<Training>();
	  trainingList.add(training);
	  
	  
	  if(assignedType.equals(TTConstants.ROLE)) {
	  
	  trainingOperation.assignTrainingsToRole(trainingList, assignedKey);
	  
	  } else if(assignedType.equals(TTConstants.APPLICATION)) {
	  
	  trainingOperation.assignTrainingsToApplication(trainingList,
	  assignedKey);
	  
	  } else if(assignedType.equals(TTConstants.EMPLOYEE)) {
	  
	  trainingOperation.assignTrainingsToEmployee(trainingList, assignedKey);
	  
	  } else if(assignedType.equals(TTConstants.CLUSTER)) {
	  
	  trainingOperation.assignTrainingsToCluster(trainingList, assignedKey);
	  
	  } else if(assignedType.equals(TTConstants.TOWER)) {
	  
	  trainingOperation.assignTrainingsToTower(trainingList, assignedKey);
	  
	  } else if(assignedType.equals(TTConstants.ACCOUNT)) {
	  
	  trainingOperation.assignTrainingsToAccount(trainingList, assignedKey);
	  
	  }*/
	  
	  return "success"; 
	  
	  }
	 

	public String execute() {

			AssignedTo.add(TTConstants.ACCOUNT);
			AssignedTo.add(TTConstants.TOWER);
			AssignedTo.add(TTConstants.CLUSTER);
			AssignedTo.add(TTConstants.APPLICATION);

		NewTrainingType = populate(TrainingTypeData);
		setNewTrainingType(NewTrainingType);
		NewCategoryType = populate(CategoryTypedata);
		setNewCategoryType(NewCategoryType);

		setAssignedTo(AssignedTo);
		return "populate";
	}

	private ArrayList<String> populate(String data) {
		dataList = new ArrayList<String>();
		dataList.clear();
		StringTokenizer st = new StringTokenizer(data, ",");

		while (st.hasMoreTokens()) {
			dataList.add(st.nextToken().trim());
		}
		return dataList;
	}

	public Date StringtoDate(String inputDate) {
		SimpleDateFormat dateType = new SimpleDateFormat("MM/dd/yy");
		Date convertDate = new Date();

		try {
			convertDate = dateType.parse(inputDate);

		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}

		return convertDate;

	}

}
