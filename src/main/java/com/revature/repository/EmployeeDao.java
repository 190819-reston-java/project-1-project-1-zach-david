package com.revature.repository;

import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Expense;

public interface EmployeeDao {

	Employee getEmployee(String username, String password);
	Employee getEmployee(int employeeId);
	List<Employee> getAllEmployees();
	boolean createEmployee(Employee emp);
	boolean updateEmployee(Employee emp);
	
}
