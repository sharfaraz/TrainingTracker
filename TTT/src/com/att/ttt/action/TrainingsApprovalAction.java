package com.att.ttt.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.att.ttt.constants.TTConstants;
import com.att.ttt.dao.TrainingTrackerDao;
import com.att.ttt.entity.Emp_Trng;
import com.att.ttt.entity.Employee;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TrainingsApprovalAction extends ActionSupport implements SessionAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Emp_Trng> empTrngs = new ArrayList<Emp_Trng>();
	private SessionMap<String,Object> sessionMap;
	List<String> statuses = new ArrayList< String>();
	private String selTrainingType;
	private String selTrainingStatus;
	private Date selTrainingStDate;
	private Date selTrainingEndDate;
	private String selLevel;
	private Integer[] trainingId;
	private String empId;
	private List<Employee> emps;


	


	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
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

	public String getSelLevel() {
		return selLevel;
	}

	public void setSelLevel(String selLevel) {
		this.selLevel = selLevel;
	}

	public String updateTrainingsCompleted() {
		System.out.println("updateTrainigs Called..");
		ServletContext ctx=ServletActionContext.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ctx);
		TrainingTrackerDao dao =(TrainingTrackerDao)context.getBean("TrainingTrackerDao");
		System.out.println("dao created successfully"+empTrngs.size());
		Map<String, Object> session1 = ActionContext.getContext().getSession();
		String emailId = (String)session1.get("email");
		
		System.out.println("values passed: "+trainingId);
		for (Integer trngId: trainingId){
			dao.updateTrainingToComplete(trngId);
		}
		
		sessionMap.put("successMsg", "Successfully updated to Complete");
		
		return "success";
	}

	
	public String displayTrainings(){
		
		ServletContext ctx=ServletActionContext.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ctx);
		TrainingTrackerDao dao =(TrainingTrackerDao)context.getBean("TrainingTrackerDao");

		try {
			Map<String, Object> session = ActionContext.getContext().getSession();
			String emailId = (String)session.get("email");
			
			
			empTrngs = dao.getTrainingsToBeApproved(emailId);
			emps = dao.getAllEmployees();
			
			
			
			if (empTrngs.size() == 0) {
				sessionMap.put("TrainingsApprovalMsg", "No Trainings to be Approved!!");
			}
		}
		catch (Exception e){
			e.printStackTrace();
			return "failure";
		}
		
		return "populate";
	}

}
