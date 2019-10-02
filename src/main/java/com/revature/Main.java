package com.revature;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class Main {

	public static void main(String[] args) {
		String user = "marsh3825";
		String password = "Revature2019";
		
		EmployeeService es = new EmployeeService();
		Employee emp = es.getEmployee(user, password);
		System.out.println(emp);
	}

}
