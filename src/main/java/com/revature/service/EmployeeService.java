package com.revature.service;

import java.util.List;

import com.revature.model.Employee;
import com.revature.repository.EmployeeDao;
import com.revature.repository.EmployeeDaoJdbc;

public class EmployeeService {
	
	public boolean createEmployee(Employee emp) {
		EmployeeDao empDao = new EmployeeDaoJdbc();
		return empDao.createEmployee(emp);
	}
	
	public Employee getEmployee(String username, String password) {
		EmployeeDao empDao = new EmployeeDaoJdbc();
		System.out.println(username + password);
		return empDao.getEmployee(username, password);
	}
	
	public Employee getEmployee(int employeeId) {
		EmployeeDao empDao = new EmployeeDaoJdbc();
		return empDao.getEmployee(employeeId);
	}
	
	public List<Employee> getAllEmployees() {
		EmployeeDao empDao = new EmployeeDaoJdbc();
		return empDao.getAllEmployees();
	}
	
	public boolean updateEmployee(Employee emp) {
		EmployeeDao empDao = new EmployeeDaoJdbc();
		return empDao.updateEmployee(emp);
	}

}
