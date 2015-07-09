package com.att.ttt.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.att.ttt.entity.Application;
import com.att.ttt.entity.Emp_Application;
import com.att.ttt.entity.Emp_Trng;
import com.att.ttt.entity.Employee;
import com.att.ttt.entity.Manager_App;
import com.att.ttt.entity.TrainingReportBean;
import com.att.ttt.entity.Trainings;


public interface TrainingTrackerDao {

	
	
	//Employee Tables.
	public ArrayList<Employee> getUserPresenceList(String emailId);
	public List<Employee> getDeliveryManagersList();
	public Employee getEmployee (String empId);
	public List<Employee> getEmployeesManaged(Employee emp);
	public List<Employee> getAllEmployees();
	public List<String> getSdmNames();
	
	//Trainings
	public void addTraining(Trainings training);
	public List<String> getAllTrainingsName();
	public List<Trainings> getTrainings(Employee emp);
	public Boolean updateTrainingToComplete(Integer trainingId);
	public Trainings getTrainingFromTrainingName(String trainingName);
	public List<Trainings> getAllTrainings();
	
	//roles
	public String getUserRoles (String emailId);
	public Boolean isDm(String emailId);
	
	//Emp_Trngs
	public void assignTrainings(Emp_Trng empTrng);
	public void updateEmpTrng(Emp_Trng empTrng);
	public List<Emp_Trng> myTrainingsList(String empId);
	public List<Emp_Trng> myTrainingsList(Integer trainingId, String emailId);
	public List<Emp_Trng> getTrainingsToBeApproved(String emailId);
	public List<Emp_Trng> myTrainingsList(String emailId, Date startDate,
			Date endDate, String trainingType, String status, String level);
	
	
	
	//Reports
	public List<String> getAccountvalues(); 
	public List<String> getTowervalues(); 
	public List<String> getClustervalues(); 
	public List<String> getApplicationvalues(); 
	
	public List<String> getSdmForReportDisplay(String tower);
	public List<String> getDmForReportDisplay(String sdm);
	public List<String> getAppForReportDisplay(String tower);
	public List<String> getEmployees (String levelName, String levelId);  
	
	//Training report bean
	public List<TrainingReportBean> gererateTrainingReport(String TrainingName, Date trainingStartDate,
			Date trainingEndDate, String trainingType, String trainingStatus,
			String reportLevel, String reportLevelValue);
	public List<TrainingReportBean> generateTrainingReportUnderMe(String emailid);
	
	
	//Applications
	public void assignApplication(Emp_Application empApp);
	public Application getAppFromAppName(String appName);
	public List<String> myAppsList( String empId);
	public Boolean saveApplication(Application appln);
	public Boolean saveManagerApp(Manager_App manApp);
	public List<String> getAppsManaged(Employee emp);
	public List<String> getAllApplicationNames();
	

	//general
	public Session getCurrentSessionUser();
	

}
