package com.att.ttt.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.att.ttt.dao.TrainingTrackerDao;
import com.att.ttt.entity.Employee;
import com.opensymphony.xwork2.ActionSupport;

import swat.ReturnCode;
import swat.cwa;

public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	private String errorMsg = "";
	private SessionMap<String, Object> sessionMap;
	private Employee emp;

	ArrayList<Employee> userPresenceList = new ArrayList<Employee>();

	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public ArrayList<Employee> getUserPresenceList() {
		return userPresenceList;
	}

	public void setUserPresenceList(ArrayList<Employee> userPresenceList) {
		this.userPresenceList = userPresenceList;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getLdapHost() {
		return ldapHost;
	}

	public void setLdapHost(String ldapHost) {
		this.ldapHost = ldapHost;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionMap = (SessionMap<String, Object>) arg0;
	}

	String ldapHost = "bluepages.ibm.com";

	public String logout() {

		sessionMap.invalidate();
		System.out
				.println("email id after log out :" + sessionMap.get("email"));
		return "success";
	}

	public String execute() {
		String emailId = email.toLowerCase();
		System.setProperty(cwa.FORCE_SSL_SEARCH, "true");
		ReturnCode rc = null;
		rc = cwa.authenticate(ldapHost, emailId, password);
		String res = "failure";
		if (rc.getCode() == cwa.RC_SUCCESS) {
			ServletContext ctx = ServletActionContext.getServletContext();
			WebApplicationContext context = WebApplicationContextUtils
					.getWebApplicationContext(ctx);
			sessionMap.put("email", emailId);
			TrainingTrackerDao trainingTracker = (TrainingTrackerDao) context
					.getBean("TrainingTrackerDaoImpl");

			userPresenceList = trainingTracker.getUserPresenceList(emailId);
			System.out.println(userPresenceList);

			if (userPresenceList.size() != 0) {
				System.out.println("existingUser");
				res = "existingUser";
				sessionMap.put("empId", userPresenceList.get(0)
						.getEmployee_id().toString());
			} else {
				System.out.println("nonExistingUser");
//				res = "nonExistingUser";
				res = "employeesList";
			}
		} else {
			System.err.println("We're not in!");
			errorMsg = "Login failed. Please try again";
			addFieldError("username", "Login failed. Try again!!");
			res = "failure";
		}
		return res;
	}

}
