package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Expense;
import com.revature.util.ConnectionUtil;
import com.revature.util.StreamCloser;

public class ExpenseDaoJdbc implements ExpenseDao {

	public Expense getExpense(int expenseId) {
		Connection conn =  null;
		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		String query = "SELECT * FROM expenses WHERE expenseid=?;";
		Expense exp = null;
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, expenseId);
			if(stmt.execute()) {
				resultSet = stmt.getResultSet();
				if(resultSet.next()) {
					exp = new Expense(resultSet.getInt("expenseid"),
									  resultSet.getString("requestdate"),
									  resultSet.getDouble("amount"),
									  resultSet.getString("description"),
									  resultSet.getInt("employeeid"),
									  resultSet.getInt("typeid"),
									  resultSet.getInt("statusid"),
									  resultSet.getInt("managerid"));									  
				}	
			}
			
		} catch (SQLException e) {	
			e.printStackTrace();
		} finally {
			StreamCloser.close(resultSet);
			StreamCloser.close(stmt);
			StreamCloser.close(conn);
		}
		return exp;
	}

	public List<Expense> getAllEmployeeExpenses(int employeeId) {
		Connection conn =  null;
		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		List<Expense> allEmployeeExpenses = new ArrayList<Expense>();
		String query = "SELECT * FROM expenses WHERE employeeid=?;";
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, employeeId);
			if(stmt.execute()) {
				resultSet = stmt.getResultSet();
				while(resultSet.next()) {
					allEmployeeExpenses.add(new Expense(
									resultSet.getInt("expenseid"),
									resultSet.getString("requestdate"),
									resultSet.getDouble("amount"),
									resultSet.getString("description"),
								    resultSet.getInt("employeeid"),
								    resultSet.getInt("typeid"),
								    resultSet.getInt("statusid"),
								    resultSet.getInt("managerid"))
									);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allEmployeeExpenses;
	}

	/*
	 * This returns a list of all expense reports that a manager has either approved or denied.
	 */
	public List<Expense> getAllManagerExpenses(int managerId) {
		Connection conn =  null;
		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		List<Expense> allManagerExpenses = new ArrayList<Expense>();
		String query = "SELECT * FROM expenses WHERE managerid=?;";
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, managerId);
			if(stmt.execute()) {
				resultSet = stmt.getResultSet();
				while(resultSet.next()) {
					allManagerExpenses.add(new Expense(
									resultSet.getInt("expenseid"),
									resultSet.getString("requestdate"),
									resultSet.getDouble("amount"),
									resultSet.getString("description"),
								    resultSet.getInt("employeeid"),
								    resultSet.getInt("typeid"),
								    resultSet.getInt("statusid"),
								    resultSet.getInt("managerid"))
									);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allManagerExpenses;
	}

	public List<Expense> getAllExpenses() {
		Connection conn =  null;
		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		List<Expense> allExpenses = new ArrayList<Expense>();
		String query = "SELECT * FROM expenses;";
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			if(stmt.execute()) {
				resultSet = stmt.getResultSet();
				while(resultSet.next()) {
					allExpenses.add(new Expense(
									resultSet.getInt("expenseid"),
									resultSet.getString("requestdate"),
									resultSet.getDouble("amount"),
									resultSet.getString("description"),
								    resultSet.getInt("employeeid"),
								    resultSet.getInt("typeid"),
								    resultSet.getInt("statusid"),
								    resultSet.getInt("managerid"))
									);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allExpenses;
	}

	public boolean createExpense(Expense exp) {
		Connection conn =  null;
		PreparedStatement stmt = null;
		String query = "INSERT INTO expenses VALUES (DEFAULT, ?, ?, ?, ?, ?, ?);";
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, exp.getRequestDate());
			stmt.setDouble(2, exp.getAmount());
			stmt.setString(3, exp.getDescription());
			stmt.setInt(4, exp.getEmployeeId());
			stmt.setInt(5, exp.getType());
			stmt.setInt(6, exp.getStatus());
			stmt.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			StreamCloser.close(stmt);
			StreamCloser.close(conn);
		}
	}

	public boolean updateExpense(Expense exp) {
		Connection conn =  null;
		PreparedStatement stmt = null;
		String query = "UPDATE expense SET (amount=?, description=?, typeid=?, statusid=?, managerid=? WHERE expenseid=?;";
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setDouble(1, exp.getAmount());
			stmt.setString(2, exp.getDescription());
			stmt.setInt(3, exp.getType());
			stmt.setInt(4, exp.getStatus());
			stmt.setInt(5, exp.getManagerId());
			stmt.setInt(6, exp.getExpenseId());
			stmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			StreamCloser.close(stmt);
			StreamCloser.close(conn);
		}
	}

}
