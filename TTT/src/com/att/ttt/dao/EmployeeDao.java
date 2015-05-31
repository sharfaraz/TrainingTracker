package com.att.ttt.dao;

import java.util.Collection;
import java.util.List;

import com.att.ttt.entity.Employee;

public interface EmployeeDao {

	int loadEmployees(Collection<Employee> empCollection);
	void saveEmployee (Employee employee);
	void updateEmployee(Employee employee);
	Boolean cleanEmpTable();
	List<String> getEmployeeIds();
}
