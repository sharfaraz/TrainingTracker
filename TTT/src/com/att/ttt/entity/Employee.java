package com.att.ttt.entity;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Employee")
public class Employee {

	/*@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator ="employee_id_seq")
	@SequenceGenerator(
		    name="employee_id_seq",
		    sequenceName="employee_id_seq",
		    allocationSize=1
		)*/

	@Id
	private String empId;
	private String attuid;
	private String account;
	private String tower;
	private String lname;	
	private String fname;
	private String jobTitle;
	private String emailId;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	private String city;
	private String delMgr;
	private String delMgrId;
	private String srDelMgr;
	private String srDelMgrId;
	private String application;
	
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getAttuid() {
		return attuid;
	}
	public void setAttuid(String attuid) {
		this.attuid = attuid;
	}
	public String getTower() {
		return tower;
	}
	public void setTower(String tower) {
		this.tower = tower;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDelMgr() {
		return delMgr;
	}
	public void setDelMgr(String delMgr) {
		this.delMgr = delMgr;
	}
	public String getDelMgrId() {
		return delMgrId;
	}
	public void setDelMgrId(String delMgrId) {
		this.delMgrId = delMgrId;
	}
	public String getSrDelMgr() {
		return srDelMgr;
	}
	public void setSrDelMgr(String srDelMgr) {
		this.srDelMgr = srDelMgr;
	}
	public String getSrDelMgrId() {
		return srDelMgrId;
	}
	public void setSrDelMgrId(String srDelMgrId) {
		this.srDelMgrId = srDelMgrId;
	}


	
	
	
}
