package com.revature.model;

public class Expense {
	
	private int expenseId;
	private String requestDate;
	private double amount;
	private String description;
	private int employeeId;
	private int type;
	private int status;
	private int managerId;
	
	
	
	public Expense(int expenseId, String requestDate, double amount, String description, int employeeId, int type,
			int status, int managerId) {
		super();
		this.expenseId = expenseId;
		this.requestDate = requestDate;
		this.amount = amount;
		this.description = description;
		this.employeeId = employeeId;
		this.type = type;
		this.status = status;
		this.managerId = managerId;
	}
	
	public Expense() {
		
	}
	
	public int getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	

}
