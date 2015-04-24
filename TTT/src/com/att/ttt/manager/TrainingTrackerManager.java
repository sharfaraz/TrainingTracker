package com.att.ttt.manager;

import java.util.List;

import com.att.ttt.entity.Emp_Trng;

public interface TrainingTrackerManager {

	
	List<Emp_Trng> viewTrainings(String emailId);
}
