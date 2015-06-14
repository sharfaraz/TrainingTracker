package com.att.ttt.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.att.ttt.dao.TrainingTrackerDao;
import com.att.ttt.entity.Employee;
import com.opensymphony.xwork2.ActionContext;



public class ManagerEmployeeMapAction {
		
	List<Employee> emps = new ArrayList<Employee>();
	

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
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
