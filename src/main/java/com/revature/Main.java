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
		Expense exp = new Expense();
		
		exp.setStatus(2);
		exp.setManagerId(1);
		exp.setExpenseId(10);
		
		es.updateExpense(exp);
		
		
	}

}
