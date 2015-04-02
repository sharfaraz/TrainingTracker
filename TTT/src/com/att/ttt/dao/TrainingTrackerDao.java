package com.att.ttt.dao;

import java.util.ArrayList;
import java.util.List;

import com.att.ttt.entity.Emp_Trng;
import com.att.ttt.entity.Employee;

public interface TrainingTrackerDao {

	ArrayList<Employee> getUserPresenceList(String emailId);

	List<Emp_Trng> myTrainingsList(String empId);

	List<Employee> getDeliveryManagersList();

}
