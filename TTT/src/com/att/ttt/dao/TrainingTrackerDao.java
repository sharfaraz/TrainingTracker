package com.att.ttt.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.att.ttt.entity.Application;
import com.att.ttt.entity.Emp_Trng;
import com.att.ttt.entity.Employee;
import com.att.ttt.entity.Manager_App;
import com.att.ttt.entity.TrainingReportBean;
import com.att.ttt.entity.Trainings;


public interface TrainingTrackerDao {

	ArrayList<Employee> getUserPresenceList(String emailId);
	List<Employee> getDeliveryManagersList();
	String getUserRoles (String emailId);
	public List<String> getAccountvalues(); 
	public List<String> getTowervalues(); 
	public List<String> getClustervalues(); 
	public List<String> getApplicationvalues(); 
	public void addTraining(Trainings training);
	public List<String> getSdmForReportDisplay(String tower);
	public List<String> getDmForReportDisplay(String sdm);
	public List<String> getAppForReportDisplay(String tower);
	public List<String> getEmployees (String levelName, String levelId);  
	public void assignTrainings(Emp_Trng empTrng);
	public void updateEmpTrng(Emp_Trng empTrng);
	List<String> getAllTrainingsName();
	List<TrainingReportBean> gererateTrainingReport(String TrainingName, Date trainingStartDate,
			Date trainingEndDate, String trainingType, String trainingStatus,
			String reportLevel, String reportLevelValue);
	List<Emp_Trng> myTrainingsList(String emailId, Date startDate,
			Date endDate, String trainingType, String status, String level);
	List<String> getSdmNames();
	public Boolean saveApplication(Application appln);
	public Boolean saveManagerApp(Manager_App manApp);
	public Employee getEmployee (String empId);
	public List<Trainings> getTrainings(Employee emp);
	public List<String> getAppsManaged(Employee emp);

}
