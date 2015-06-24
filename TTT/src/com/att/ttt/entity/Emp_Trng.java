package com.att.ttt.entity;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Emp_Trng")
public class Emp_Trng {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int etId;
	private String empId;
	private Integer trainingId;
	private String trainingName;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	private String status;
	private String trainingType;
	private String delMgr;
	private String srDelMgr;
	private String emailContact;
	
	

	public int getEtId() {
		return etId;
	}
	public void setEtId(int etId) {
		this.etId = etId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public Integer getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(Integer trainingId) {
		this.trainingId = trainingId;
	}
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTrainingType() {
		return trainingType;
	}
	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}
	public String getDelMgr() {
		return delMgr;
	}
	public void setDelMgr(String delMgr) {
		this.delMgr = delMgr;
	}
	public String getSrDelMgr() {
		return srDelMgr;
	}
	public void setSrDelMgr(String srDelMgr) {
		this.srDelMgr = srDelMgr;
	}
	public String getEmailContact() {
		return emailContact;
	}
	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
	}
	
	
}
