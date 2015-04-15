package com.att.ttt.entity;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Trainings")
public class Trainings {
	/*@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator ="training_id_seq")
	@SequenceGenerator(
		    name="training_id_seq",
		    sequenceName="training_id_seq",
		    allocationSize=1
		)*/
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer trainingId;
	private String trainingName;
	
	private String numOfDays;
	private String levelId;
	private String levelName;
	

	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
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
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
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
}
