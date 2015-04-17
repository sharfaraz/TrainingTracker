package com.att.ttt.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.att.ttt.dao.ClusterDao;
import com.att.ttt.entity.Cluster;
import com.att.ttt.manager.ClusterManager;

public class ClusterManagerImpl implements ClusterManager{

	private ClusterDao clusterDao;	

	public ClusterDao getClusterDao() {
		return clusterDao;
	}

	@Autowired
	public void setClusterDao(ClusterDao clusterDao) {
		this.clusterDao = clusterDao;
	}

	@Override
	public Cluster fetchCluster(String clusterName) {
		Cluster cluster = new Cluster();
		cluster = clusterDao.getCluster(clusterName);
		return cluster;	
	}
}
