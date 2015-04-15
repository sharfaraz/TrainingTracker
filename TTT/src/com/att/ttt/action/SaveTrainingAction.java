package com.att.ttt.action;

import java.io.File;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import com.att.ttt.entity.Trainings;
import com.att.ttt.manager.TrainingsManager;


public class SaveTrainingAction {
	private Integer trainingId;
	private String trainingName;	
	private String numOfDays;
	private String levelId;
	private String levelName;
	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

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

	public String getNumOfDays() {
		return numOfDays;
	}

	public void setNumOfDays(String numOfDays) {
		this.numOfDays = numOfDays;
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

	private Trainings training;
	private TrainingsManager manager;
	
	public TrainingsManager getManager() {
		return manager;
	}
	
	@Autowired
	public void setManager(TrainingsManager manager) {
		this.manager = manager;
	}

	public String execute() {
		
		try {
			training = new Trainings();
			training.setTrainingName(trainingName);
			training.setDelMgr(delMgr);
			training.setEndDate(endDate);
			training.setLevelId(levelId);
			training.setNumOfDays(numOfDays);
			training.setStartDate(startDate);
			training.setLevelName(levelName);
			System.out.println("training name: " + training.getTrainingName() + " del mgr: " + training.getDelMgr());
			manager.createTraining(training);
			System.out.println("training name: " + training.getTrainingName() + " del mgr: " + training.getDelMgr());
			
		}
		
		
		catch (Exception e) {
			e.printStackTrace();	
		}
		return "success";
	}
	
	public String display() {
		return "none";
	}

}
