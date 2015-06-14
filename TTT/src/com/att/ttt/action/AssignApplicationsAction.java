package com.att.ttt.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.att.ttt.constants.TTConstants;
import com.att.ttt.dao.TrainingTrackerDao;
import com.att.ttt.entity.Application;
import com.att.ttt.entity.Emp_Application;
import com.att.ttt.entity.Emp_Trng;
import com.att.ttt.entity.Employee;
import com.att.ttt.entity.Trainings;
import com.opensymphony.xwork2.ActionContext;



public class AssignApplicationsAction {
	private List<Employee> emp =  new ArrayList<Employee>();
	private List<String> employees = new ArrayList<String>();
	private List<String> myApps = new ArrayList<String>();
	private List<String> assignedApplications =  new ArrayList<String>();
	private List<String> availableApplications =  new ArrayList<String>();
	private List<String> selApplications =  new ArrayList<String>();
	private String selEmpName;
	private List<String> employee = new ArrayList<String>();

	public List<String> getMyApps() {
		return myApps;
	}

	public void setMyApps(List<String> myApps) {
		this.myApps = myApps;
	}

	public List<String> getAssignedApplications() {
		return assignedApplications;
	}

	public void setAssignedApplications(List<String> assignedApplications) {
		this.assignedApplications = assignedApplications;
	}

	public List<String> getAvailableApplications() {
		return availableApplications;
	}

	public void setAvailableApplications(List<String> availableApplications) {
		this.availableApplications = availableApplications;
	}

	public List<String> getSelApplications() {
		return selApplications;
	}

	public void setSelApplications(List<String> selApplications) {
		this.selApplications = selApplications;
	}

	public List<String> getEmployee() {
		return employee;
	}

	public void setEmployee(List<String> employee) {
		this.employee = employee;
	}

	public String getSelEmpName() {
		return selEmpName;
	}

	public void setSelEmpName(String selEmpName) {
		this.selEmpName = selEmpName;
	}

	ServletContext ctx = ServletActionContext.getServletContext();
	WebApplicationContext context = WebApplicationContextUtils
			.getWebApplicationContext(ctx);
	TrainingTrackerDao dao =(TrainingTrackerDao)context.getBean("TrainingTrackerDao");


	public List<String> getEmployees() {
		return employees;
	}

	public void setEmployees(List<String> employees) {
		this.employees = employees;
	}

	List<Employee> getEmp() {
		return emp;
	}

	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}

	public String execute(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		String emailId = (String)session.get("email");
		List<Employee> emp1 = dao.getUserPresenceList(emailId);
		List<String> applicationsToBeAssigned =  new ArrayList<String>();
		emp = dao.getEmployeesManaged(emp1.get(0));
		
		
		System.out.println("employee "+employee);
		System.out.println("applications "+selApplications);
		for  (Employee e : emp) {
			if (employee.contains((e.getFname()+" "+e.getLname()))){
				System.out.println("Gonna assign trainings for "+e.getFname());
				myApps = dao.myAppsList(e.getEmpId());
				applicationsToBeAssigned = selApplications;
				for (String app : myApps) {
					applicationsToBeAssigned.remove(app);
				}
				System.out.println("applications to be assigned "+applicationsToBeAssigned);
				for (int i=0;i<applicationsToBeAssigned.size(); i++){
					Application a = dao.getAppFromAppName(applicationsToBeAssigned.get(i));
					Emp_Application empApp = new Emp_Application();
					empApp.setApplnId(a.getApplnId());
					empApp.setEmpId(e.getEmpId());

					dao.assignApplication(empApp);
				}
				
			}
		}
		return"success";
	}
	
	public String initAssignApplications() {
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		String emailId = (String)session.get("email");
		
		List<Employee> emp1 = dao.getUserPresenceList(emailId);
		
		emp = dao.getEmployeesManaged(emp1.get(0));
		
		for (Employee e : emp) {
			employees.add(e.getFname()+" "+e.getLname());
		}
		
		availableApplications=dao.getAppsManaged(emp1.get(0));
		 
		return "success";
	}

}
