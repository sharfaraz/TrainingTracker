package com.att.ttt.entity;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer training_id;
	private String training_name;
	
	private String numOfdays;
	private String level_id;
	private String level_sub_id;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	private String delMgr;
	

	public Integer getTraining_id() {
		return training_id;
	}
	public void setTraining_id(Integer training_id) {
		this.training_id = training_id;
	}
	public String getTraining_name() {
		return training_name;
	}
	public void setTraining_name(String training_name) {
		this.training_name = training_name;
	}
	public String getNumOfdays() {
		return numOfdays;
	}
	public void setNumOfdays(String numOfdays) {
		this.numOfdays = numOfdays;
	}
	public String getLevel_id() {
		return level_id;
	}
	public void setLevel_id(String level_id) {
		this.level_id = level_id;
	}
	public String getLevel_sub_id() {
		return level_sub_id;
	}
	public void setLevel_sub_id(String level_sub_id) {
		this.level_sub_id = level_sub_id;
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
