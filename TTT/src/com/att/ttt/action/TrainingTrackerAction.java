package com.att.ttt.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.att.ttt.entity.Emp_Trng;
import com.att.ttt.manager.TrainingTrackerManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TrainingTrackerAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TrainingTrackerManager manager;

	private List<Emp_Trng> trainings;	

	
	public List<Emp_Trng> getTrainings() {
		return trainings;
	}
	public void setTrainings(List<Emp_Trng> trainings) {
		this.trainings = trainings;
	}

	public TrainingTrackerManager getTrainingTrackerManager() {
		return manager;
	}
	
	@Autowired
	public void setTrainingTrackerManager(TrainingTrackerManager manager) {
		this.manager = manager;
	}
	public String execute() {
		String res;
		Map<String, Object> session = ActionContext.getContext().getSession();
		String emailId = (String)session.get("email");
		System.out.println("emailId :" + emailId);
		trainings = manager.viewTrainings(emailId);
		System.out.println("trainings :" + trainings.size());
		res = "success";
		return res;
	}
}
