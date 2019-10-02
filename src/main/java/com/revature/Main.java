package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Expense;
import com.revature.service.EmployeeService;
import com.revature.service.ExpenseService;

public class Main {

	public static void main(String[] args) {
//		String user = "marsh3825";
//		String password = "Revature2019";
//		
//		EmployeeService es = new EmployeeService();
//		Employee emp = es.getEmployee(user, password);
//		System.out.println(emp);
		
		ExpenseService expServ = new ExpenseService();
		List<Expense> expList = new ArrayList<Expense>();
		expList = expServ.getAllExpenses();
		for (Expense e : expList) {
			System.out.println(e.toString());
		}
	}

}
