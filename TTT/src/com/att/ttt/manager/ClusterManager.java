package com.att.ttt.manager;

import com.att.ttt.entity.Cluster;

public interface ClusterManager {

	Cluster fetchCluster(String clusterName);
	
}
