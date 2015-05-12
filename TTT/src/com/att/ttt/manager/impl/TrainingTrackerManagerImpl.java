package com.att.ttt.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.att.ttt.dao.TrainingTrackerDao;
import com.att.ttt.entity.Emp_Trng;
import com.att.ttt.manager.TrainingTrackerManager;

public class TrainingTrackerManagerImpl implements TrainingTrackerManager {

	private TrainingTrackerDao dao;

	public TrainingTrackerDao getTrainigTrackerDao() {
		return dao;
	}
	@Autowired
	public void setTrainingTrackerDao(TrainingTrackerDao dao) {
		this.dao = dao;
	}

/*	public List<Emp_Trng> viewTrainings(String empId) {
		return dao.myTrainingsList(empId);
	}*/
}
