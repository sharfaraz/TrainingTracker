package com.att.ttt.dao;

import java.util.List;

import com.att.ttt.entity.Emp_Trng;
import com.att.ttt.entity.Employee;
import com.att.ttt.entity.Trainings;


public interface TrainingTrackerDao {

	List<Employee> getUserPresenceList(String emailId);

	List<Emp_Trng> myTrainingsList(String empId);

	List<Employee> getDeliveryManagersList();
	
	String getUserRoles (String emailId);
	
	public List<String> getAccountvalues(); 
	public List<String> getTowervalues(); 
	public List<String> getClustervalues(); 
	public List<String> getApplicationvalues(); 
	public void addTraining(Trainings training);
	public void assignTrainings(Emp_Trng empTrng);
	public List<String> getEmployees (String levelName, String levelId);
	

}
