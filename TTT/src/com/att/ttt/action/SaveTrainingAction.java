package com.att.ttt.action;

import java.util.Date;


import com.att.ttt.dao.TrainingsDao;
import com.att.ttt.entity.Trainings;

public class SaveTrainingAction {
	private Integer trainingId;
	private String trainingName;	
	private String numOfdays;
	private String levelId;
	private Date startDate;
	private Date endDate;
	private String delMgr;
	
	public Integer getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(Integer trainingId) {
		this.trainingId = trainingId;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public String getNumOfdays() {
		return numOfdays;
	}

	public void setNumOfdays(String numOfdays) {
		this.numOfdays = numOfdays;
	}

	public String getLevelId() {
		return levelId;
	}

	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDelMgr() {
		return delMgr;
	}

	public void setDelMgr(String delMgr) {
		this.delMgr = delMgr;
	}

	public Trainings getTraining() {
		return training;
	}

	public void setTraining(Trainings training) {
		this.training = training;
	}

	public TrainingsDao getDao() {
		return dao;
	}

	public void setDao(TrainingsDao dao) {
		this.dao = dao;
	}

	private Trainings training;
	private TrainingsDao dao;
	
	public String execute() {
		training.setTrainingName(trainingName);
		training.setDelMgr(delMgr);
		/*training.setEndDate(endDate);
		training.setLevelId(levelId);
		training.setNumOfdays(numOfdays);
		training.setStartDate(startDate);
		
		dao.saveTraining(training);*/
		System.out.println("training name: " + training.getTrainingName() + " del mgr: " + training.getDelMgr());
		return "success";
	}

}
