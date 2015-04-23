package com.att.ttt.entity;

import java.util.Date;

public class TrainingReportBean {

	
   private String empId;
   private String empName;
   private String emailId;
   private String appName;
   private String dmName;
   private String sdmName;
   private String towerName;
   
   private String trainingName;
   private String trainingStatus;
   private String trainingType;
  
private Date startDate;
   private Date endDate;
   
   
public String getEmpId() {
	return empId;
}
public void setEmpId(String empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getAppName() {
	return appName;
}
public void setAppName(String appName) {
	this.appName = appName;
}
public String getDmName() {
	return dmName;
}
public void setDmName(String dmName) {
	this.dmName = dmName;
}
public String getSdmName() {
	return sdmName;
}
public void setSdmName(String sdmName) {
	this.sdmName = sdmName;
}
public String getTowerName() {
	return towerName;
}
public void setTowerName(String towerName) {
	this.towerName = towerName;
}
public String getTrainingName() {
	return trainingName;
}
public void setTrainingName(String trainingName) {
	this.trainingName = trainingName;
}
public String getTrainingStatus() {
	return trainingStatus;
}
public void setTrainingStatus(String trainingStatus) {
	this.trainingStatus = trainingStatus;
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
public String getTrainingType() {
	return trainingType;
}
public void setTrainingType(String trainingType) {
	this.trainingType = trainingType;
}	
}
