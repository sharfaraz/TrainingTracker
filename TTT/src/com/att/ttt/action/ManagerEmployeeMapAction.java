package com.att.ttt.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.att.ttt.constants.TTConstants;
import com.att.ttt.dao.TrainingTrackerDao;
import com.att.ttt.entity.Application;
import com.att.ttt.entity.Emp_Trng;
import com.att.ttt.entity.Employee;
import com.att.ttt.entity.Manager_App;
import com.att.ttt.entity.Trainings;
import com.opensymphony.xwork2.ActionContext;



public class ManagerEmployeeMapAction {
		
	List<String> emps = new ArrayList<String>();
	

	public List<String> getEmps() {
		return emps;
	}

	public void setEmps(List<String> emps) {
		this.emps = emps;
	}

	
	public String execute() {
		
		ServletContext ctx=ServletActionContext.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ctx);
		TrainingTrackerDao dao =(TrainingTrackerDao)context.getBean("TrainingTrackerDao");
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		String emailId = (String)session.get("email");
		
		List<Employee> emp = dao.getUserPresenceList(emailId);
		
		emps = dao.getEmployeesManaged(emp.get(0));
		
		return "success";
	}

}
