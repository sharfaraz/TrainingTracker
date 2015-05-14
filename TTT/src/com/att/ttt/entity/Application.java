package com.att.ttt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Application")
public class Application {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer applnId;
	private String clusterId;
	private String applnName;
	
	public Integer getApplnId() {
		return applnId;
	}
	public void setApplnId(Integer applnId) {
		this.applnId = applnId;
	}
	public String getClusterId() {
		return clusterId;
	}
	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}
	public String getApplnName() {
		return applnName;
	}
	public void setApplnName(String applnName) {
		this.applnName = applnName;
	}
	
	
	
	
	
}
