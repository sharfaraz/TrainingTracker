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
	private String clusterId;
	private String towerId;
	private String clusterName;
	
	public String getClusterId() {
		return clusterId;
	}
	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}
	public String getTowerId() {
		return towerId;
	}
	public void setTowerId(String towerId) {
		this.towerId = towerId;
	}
	public String getClusterName() {
		return clusterName;
	}
	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}
	
	
}
