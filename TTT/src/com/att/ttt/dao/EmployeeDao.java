package com.att.ttt.dao;

import java.util.Collection;

import com.att.ttt.entity.Employee;

public interface EmployeeDao {

	int loadEmployees(Collection<Employee> empCollection);
	void saveEmployee (Employee employee);
	void updateEmployee(Employee employee);
}
