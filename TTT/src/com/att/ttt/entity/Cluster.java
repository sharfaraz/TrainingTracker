package com.att.ttt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cluster")
public class Cluster {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String cluster_id;
	private String  twr_id;
	private String cluster_name;
	
	public String getCluster_id() {
		return cluster_id;
	}
	public void setCluster_id(String cluster_id) {
		this.cluster_id = cluster_id;
	}
	public String getTwr_id() {
		return twr_id;
	}
	public void setTwr_id(String twr_id) {
		this.twr_id = twr_id;
	}
	public String getCluster_name() {
		return cluster_name;
	}
	public void setCluster_name(String cluster_name) {
		this.cluster_name = cluster_name;
	}
	
	
}
