package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;
import com.revature.util.StreamCloser;

public class EmployeeDaoJdbc implements EmployeeDao {

	public Employee getEmployee(String username, String password) {
		Connection conn =  null;
		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		Employee emp = null;
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM public.employee WHERE username=? AND password=?;");
			stmt.setString(1, username);
			stmt.setString(2, password);			
			if(stmt.execute()) {
				resultSet = stmt.getResultSet();
				if(resultSet.next()) {
					emp = new Employee(resultSet.getInt("employeeid"),
									   resultSet.getString("firstname"),
									   resultSet.getString("lastname"),
									   resultSet.getString("email"),
									   resultSet.getString("username"),
									   resultSet.getString("password"),
									   resultSet.getBoolean("manager")
									   );
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			StreamCloser.close(resultSet);
			StreamCloser.close(stmt);
			StreamCloser.close(conn);
		}
		
		return emp;
	}

	public Employee getEmployee(int employeeId) {
		Connection conn =  null;
		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		Employee emp = null;
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM employee WHERE employeeid=?;");
			stmt.setInt(1, employeeId);
			if(stmt.execute()) {
				resultSet = stmt.getResultSet();
				if(resultSet.next()) {
					emp = new Employee(resultSet.getInt("employeeid"),
									   resultSet.getString("firstname"),
									   resultSet.getString("lastname"),
									   resultSet.getString("email"),
									   resultSet.getString("username"),
									   resultSet.getString("password"),
									   resultSet.getBoolean("manager")
									   );
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			StreamCloser.close(resultSet);
			StreamCloser.close(stmt);
			StreamCloser.close(conn);
		}
		
		return emp;
	}

	public List<Employee> getAllEmployees() {
		Connection conn =  null;
		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		List<Employee> allEmployees = new ArrayList<Employee>();
		String query = "SELECT * FROM employee;";
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			if(stmt.execute()) {
				resultSet = stmt.getResultSet();
				while(resultSet.next()) {
					allEmployees.add(new Employee(
								resultSet.getInt("employeeid"),
								resultSet.getString("firstname"),
								resultSet.getString("lastname"),
								resultSet.getString("email"),
								resultSet.getString("username"),
								resultSet.getString("password"),
								resultSet.getBoolean("manager"))
								);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			allEmployees = null;
		} finally {
			StreamCloser.close(resultSet);
			StreamCloser.close(stmt);
			StreamCloser.close(conn);
		}
		
		return allEmployees;
	}

	public boolean createEmployee(Employee emp) {
		Connection conn =  null;
		PreparedStatement stmt = null;
		String query = "INSERT INTO employee VALUES (DEFAULT, ?, ?, ?, ?, ?, ?);";
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, emp.getEmployeeFirstName());
			stmt.setString(2, emp.getEmployeeLastName());
			stmt.setString(3, emp.getEmail());
			stmt.setString(4, emp.getUsername());
			stmt.setString(5, emp.getPassword());
			stmt.setBoolean(6, emp.getManager());
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

	public boolean updateEmployee(Employee emp) {
		Connection conn =  null;
		PreparedStatement stmt = null;
		String query = "UPDATE employee SET (firstname=?, lastname=?, email=?, username=?, password=?, manager=? WHERE employeeid=?;)";
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, emp.getEmployeeFirstName());
			stmt.setString(2, emp.getEmployeeLastName());
			stmt.setString(3, emp.getEmail());
			stmt.setString(4, emp.getUsername());
			stmt.setString(5, emp.getPassword());
			stmt.setBoolean(6, emp.getManager());
			stmt.setInt(7, emp.getEmployeeId());
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
