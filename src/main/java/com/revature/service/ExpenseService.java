package com.revature.service;

import java.util.List;

import com.revature.model.Expense;
import com.revature.repository.ExpenseDao;
import com.revature.repository.ExpenseDaoJdbc;

public class ExpenseService {
	
	public Expense getExpense(int expenseId) {
		ExpenseDao expDao = new ExpenseDaoJdbc();
		return expDao.getExpense(expenseId);
	}
	
	public List<Expense> getAllExpenses() {
		ExpenseDao expDao = new ExpenseDaoJdbc();
		return expDao.getAllExpenses();
	}
	
	public List<Expense> getAllEmployeeExpenses(int employeeId) {
		ExpenseDao expDao = new ExpenseDaoJdbc();
		return expDao.getAllEmployeeExpenses(employeeId);
	}
	
	public List<Expense> getAllManagerExpenses(int managerId) {
		ExpenseDao expDao = new ExpenseDaoJdbc();
		return expDao.getAllEmployeeExpenses(managerId);
	}
	
	public boolean createExpense(Expense exp) {
		ExpenseDao expDao = new ExpenseDaoJdbc();
		return expDao.createExpense(exp);
	}
	
	public boolean updateExpense(Expense exp) {
		ExpenseDao expDao = new ExpenseDaoJdbc();
		return expDao.updateExpense(exp);
	}
	
	
}
