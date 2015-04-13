package com.att.ttt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tower")
public class Tower {
	

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String towerId;
	private String accountId;
	private String towerName;
	
	public String getTowerId() {
		return towerId;
	}
	public void setTowerId(String towerId) {
		this.towerId = towerId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getTowerName() {
		return towerName;
	}
	public void setTowerName(String towerName) {
		this.towerName = towerName;
	}
	
	
	
	
}
