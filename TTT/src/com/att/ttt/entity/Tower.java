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
	private String twr_id;
	private String acc_id;
	private String twr_name;
	
	public String getTwr_id() {
		return twr_id;
	}
	public void setTwr_id(String twr_id) {
		this.twr_id = twr_id;
	}
	public String getAcc_id() {
		return acc_id;
	}
	public void setAcc_id(String acc_id) {
		this.acc_id = acc_id;
	}
	public String getTwr_name() {
		return twr_name;
	}
	public void setTwr_name(String twr_name) {
		this.twr_name = twr_name;
	}
	
	
	
	
}
