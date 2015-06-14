package com.att.ttt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Emp_Application")
public class Emp_Application {
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer aeId;
	private Integer applnId;
	private String empId;

	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public Integer getApplnId() {
		return applnId;
	}
	public void setApplnId(Integer applnId) {
		this.applnId = applnId;
	}

}
