package com.att.ttt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Manager_App")
public class Manager_App {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int maId;
	private String managerId;
	private int applnId;
	public int getMaId() {
		return maId;
	}
	public void setMaId(int maId) {
		this.maId = maId;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public int getApplnId() {
		return applnId;
	}
	public void setApplnId(int applnId) {
		this.applnId = applnId;
	}

}
