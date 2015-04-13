package com.att.ttt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Levels")
public class Levels {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String levelId;
	private String levelName;
	
	
	public String getLevelId() {
		return levelId;
	}
	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevel_name(String levelName) {
		this.levelName = levelName;
	}
	
	
	
}
