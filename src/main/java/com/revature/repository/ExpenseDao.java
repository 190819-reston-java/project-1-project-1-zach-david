package com.revature.repository;

import java.util.List;

import com.revature.model.Expense;

public interface ExpenseDao {

	Expense getExpense(int expenseId);
	List<Expense> getAllEmployeeExpenses(int employeeId);
	List<Expense> getAllManagerExpenses(int employeeId);
	List<Expense> getAllExpenses();
	boolean createExpense(Expense exp);
	boolean updateExpense(Expense exp);
	
}
