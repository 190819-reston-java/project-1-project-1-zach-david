package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Expense;
import com.revature.service.EmployeeService;
import com.revature.service.ExpenseService;

public class Main {

	public static void main(String[] args) {
	
		ExpenseService es = new ExpenseService();
		List<Expense> expList = new ArrayList();
		expList = es.getAllExpenses();
		System.out.println(expList);
		
	}

}
