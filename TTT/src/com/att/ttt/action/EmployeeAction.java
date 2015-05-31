package com.att.ttt.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.att.ttt.constants.TTConstants;
import com.att.ttt.dao.TrainingTrackerDao;
import com.att.ttt.entity.Emp_Trng;
import com.att.ttt.entity.Employee;
import com.att.ttt.entity.Trainings;
import com.att.ttt.manager.EmployeeManager;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EmployeeManager manager;
	
	Collection<String> ex;
	
	private File uploadFile;
	private String uploadFileContentType;
	private String uploadFileFileName;	
	private List<String> existingEmp;
	private List<String> newEmployees;
	private List<String> newEmp2 = new ArrayList<String>();

	public List<String> getNewEmp2() {
		return newEmp2;
	}
	public void setNewEmp2(List<String> newEmp2) {
		this.newEmp2 = newEmp2;
	}
	public List<String> getNewEmployees() {
		return newEmployees;
	}
	public void setNewEmployees(List<String> newEmployees) {
		this.newEmployees = newEmployees;
	}
	public EmployeeManager getManager() {
		return manager;
	}
	public void setManager(EmployeeManager manager) {
		this.manager = manager;
	}
	public List<String> getExistingEmp() {
		return existingEmp;
	}
	public void setExistingEmp(List<String> existingEmp) {
		this.existingEmp = existingEmp;
	}
	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
 
	public String getUploadFileContentType() {
		return uploadFileContentType;
	}
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
 
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}


	public EmployeeManager getEmployeeManager() {
		return manager;
	}
	@Autowired
	public void setEmployeeManager(EmployeeManager manager) {
		this.manager = manager;
	}
	
	public Boolean assignMandatoryTrainings( List<String> employees) {
		ServletContext ctx = ServletActionContext.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ctx);
		
		TrainingTrackerDao dao =(TrainingTrackerDao)context.getBean("TrainingTrackerDao");
		
		System.out.println("***********************************************************************Size :"+employees.size());
		for (String empId : employees) {
			System.out.println("fetching Trainings");
			Employee employee = dao.getEmployee(empId);
			List<Trainings> trList = dao.getTrainings(employee);
			for (Trainings training : trList) {
				Emp_Trng empTrng = new Emp_Trng();
				empTrng.setTrainingId(training.getTrainingId());
				empTrng.setStartDate(training.getStartDate());
				empTrng.setEndDate(training.getEndDate());
				empTrng.setStatus(TTConstants.PENDING);
				empTrng.setTrainingName(training.getTrainingName());
				empTrng.setTrainingType(training.getTrainingType());
				empTrng.setEmpId(empId);
				dao.assignTrainings(empTrng);
			}		
		}
		return true;
	}
	
	public String execute() {
		String res;
		System.out.println("File received: "+ uploadFile);
		System.out.println("File name: "+ uploadFileFileName);
		
		existingEmp = manager.getExistingEmpIds();
		
		System.out.println("we have "+existingEmp.size()+" employees now");
		
		if (manager.cleanEmployees()) {
			manager.uploadEmployees(uploadFile);
		}
		else {
			System.out.println("error in deleting");
			return "failure";
		}
		
		newEmployees = manager.getExistingEmpIds();
		
		System.out.println("after load we now have "+newEmployees.size()+" employees");
		
		newEmp2.addAll(newEmployees);
		
		newEmployees.removeAll(existingEmp);
		
		System.out.println("No of new employees added:"+newEmployees.size());
		
		existingEmp.removeAll(newEmp2);
		
		System.out.println("deleted employees: "+existingEmp.size());
		
		if (assignMandatoryTrainings(newEmployees)) {
			res = "success";
		}
		else {
			res = "failure";
		}
		return res;
	}
}
