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
import com.att.ttt.entity.Emp_Trng;
import com.att.ttt.entity.Employee;
import com.att.ttt.entity.Trainings;
import com.opensymphony.xwork2.ActionContext;



public class AssignTrainingsAction {
	private List<Employee> emp =  new ArrayList<Employee>();
	private List<String> employees = new ArrayList<String>();
	private List<Emp_Trng> et = new ArrayList<Emp_Trng>();
	private List<String> assignedTrainings =  new ArrayList<String>();
	private List<String> availableTrainings =  new ArrayList<String>();
	private List<String> selTrainings =  new ArrayList<String>();
	private String selEmpName;
	private List<String> employee = new ArrayList<String>();
	
	

	public List<String> getSelTrainings() {
		return selTrainings;
	}

	public void setSelTrainings(List<String> selTrainings) {
		this.selTrainings = selTrainings;
	}

	public List<String> getEmployee() {
		return employee;
	}

	public void setEmployee(List<String> employee) {
		this.employee = employee;
	}

	public List<String> getAssignedTrainings() {
		return assignedTrainings;
	}

	public void setAssignedTrainings(List<String> assignedTrainings) {
		this.assignedTrainings = assignedTrainings;
	}

	public List<String> getAvailableTrainings() {
		return availableTrainings;
	}

	public void setAvailableTrainings(List<String> availableTrainings) {
		this.availableTrainings = availableTrainings;
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

	public List<Emp_Trng> getEt() {
		return et;
	}

	public void setEt(List<Emp_Trng> et) {
		this.et = et;
	}

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
		List<String> trainingsToBeAssigned =  new ArrayList<String>();
		emp = dao.getEmployeesManaged(emp1.get(0));
		
		
		System.out.println("employee "+employee);
		System.out.println("trainings "+selTrainings);
		for  (Employee e : emp) {
			if (employee.contains((e.getFname()+" "+e.getLname()))){
				System.out.println("Gonna assign trainings for "+e.getFname());
				et = dao.myTrainingsList(e.getEmpId());
				trainingsToBeAssigned = selTrainings;
				for (Emp_Trng etx : et) {
					trainingsToBeAssigned.remove(etx.getTrainingName());
				}
				System.out.println("trainngs to be assigned "+trainingsToBeAssigned);
				for (int i=0;i<trainingsToBeAssigned.size(); i++){
					Trainings tr = dao.getTrainingFromTrainingName(trainingsToBeAssigned.get(i));
					Emp_Trng empTrng = new Emp_Trng();
					empTrng.setTrainingId(tr.getTrainingId());
					empTrng.setStartDate(tr.getStartDate());
					empTrng.setEndDate(tr.getEndDate());
					empTrng.setStatus(TTConstants.PENDING);
					empTrng.setTrainingName(tr.getTrainingName());
					empTrng.setTrainingType(tr.getTrainingType());
					empTrng.setEmpId(e.getEmpId());
					dao.assignTrainings(empTrng);
				}
				
			}
		}
		return"success";
	}
	
	public String initAssignTrainings() {
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		String emailId = (String)session.get("email");
		
		List<Employee> emp1 = dao.getUserPresenceList(emailId);
		
		emp = dao.getEmployeesManaged(emp1.get(0));
		
		for (Employee e : emp) {
			employees.add(e.getFname()+" "+e.getLname());
		}
		
		availableTrainings=dao.getAllTrainingsName();
		 
		return "success";
	}

}
