package com.att.ttt.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.att.ttt.dao.TowerDao;
import com.att.ttt.entity.Tower;
import com.att.ttt.manager.TowerManager;

public class TowerManagerImpl implements TowerManager {
	
	private TowerDao towerDao;	

	public TowerDao getTowerDao() {
		return towerDao;
	}

	@Autowired
	public void setTowerDao(TowerDao towerDao) {
		this.towerDao = towerDao;
	}
	
	@Override
	public Tower fetchTower(String towerName) {
		Tower twr = new Tower();
		twr = towerDao.getTower(towerName);
		return twr;	
	}

}
