package com.revature.model;

public class Employee {
	
	private int employeeId;
	private String employeeFirstName;
	private String employeeLastName;
	private String username;
	private String password;
	private String email;
	private boolean manager;
	
	

	public Employee(int employeeId, String employeeFirstName, String employeeLastName, String username, String password,
			String email, boolean manager) {
		super();
		this.employeeId = employeeId;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.manager = manager;
	}
	
	public Employee(String employeeFirstName, String employeeLastName, String username, String password,
			String email, boolean manager) {
		super();
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.manager = manager;
	}
	
	public Employee() {
		
	}
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
	public String getEmployeeLastName() {
		return employeeLastName;
	}
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean getManager() {
		return manager;
	}
	public void setManager(boolean manager) {
		this.manager = manager;
	}
	
	

}
