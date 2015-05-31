package com.att.ttt.manager;

import java.io.File;
import java.util.List;

public interface EmployeeManager {

	void uploadEmployees(File file);
	
	List<String> getExistingEmpIds();

	Boolean cleanEmployees();
}
