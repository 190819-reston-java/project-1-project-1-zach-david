package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Employee;


public class Validate {
    public static boolean checkUser(String username,String pass) 
    {
        boolean st = false;
        try {
        	EmployeeService emp = new EmployeeService();
        	List<Employee> list = emp.getAllEmployees();
        	for (Employee employee : list) {
        		System.out.println(employee.getUsername());
        		if (employee.getUsername().contentEquals(username)) {
        			if (employee.getPassword().contentEquals(pass)) {
        				st = true;
        				System.out.println("Login Successful");
        			}
        		}
        	}
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }   
}