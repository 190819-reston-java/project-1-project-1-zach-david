package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Employee;
import com.revature.model.Expense;
import com.revature.service.EmployeeService;
import com.revature.service.ExpenseService;

public class FrontController extends HttpServlet {

	private ExpenseService expenseService = new ExpenseService();
	private EmployeeService employeeService = new EmployeeService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] splitUri = req.getRequestURI().split("/");
		String[] tokens = Arrays.copyOfRange(splitUri, 2, splitUri.length);
		
		if (tokens.length == 0) {
			resp.sendError(400, "Usage: /login or /register");
			return;
		}

		switch (tokens[0]) {
		case "menu":
			handleEmployees(req, resp, tokens);
			break;
		case "NewEmployee":
			handleEmployees(req, resp, tokens);
			break;
		case "NewExpense":
			handleExpenses(req, resp, tokens);
			break;
		case "ViewExpenses":
			handleExpenses(req, resp, tokens);
			break;
		default:
			resp.sendError(404, "Token not recognized: " + tokens[0]);
			break;
		}
		
	}

	

	private void handleExpenses(HttpServletRequest req, HttpServletResponse resp, String[] tokens)
			throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = resp.getWriter();
		Expense exp = null;
		HttpSession mySession = req.getSession();
		List<Expense> expenseList = new ArrayList<Expense>();
		

		switch (req.getMethod()) {
		case "GET":
			if(tokens[1].equals("All")) {
				expenseList =  expenseService.getAllExpenses();
				String test = om.writeValueAsString(expenseList);
				pw.write(test);
			} else if(tokens[1].equals("Employee")) {
				int empId = (int) mySession.getAttribute("employeeId");
				expenseList = expenseService.getAllEmployeeExpenses(empId);
				String test = om.writeValueAsString(expenseList);
				pw.write(test);
			} else if(tokens[1].equals("Manager")) {
				int managerId = Integer.parseInt(req.getParameter("managerId"));
				expenseList = expenseService.getAllManagerExpenses(managerId);
				String test = om.writeValueAsString(expenseList);
				pw.write(test);
			} else if(tokens[1].equals("Info")) {
				int expId = Integer.parseInt(req.getParameter("expenseId"));
				exp = expenseService.getExpense(expId);
				String test = om.writeValueAsString(exp);
				pw.write(test);
			} else {
				pw.write("Token not recognized. Try again.");
			}
			break;
		case "POST":
			if (req.getParameter("expenseId") == null) {
				exp = om.readValue(req.getReader(), Expense.class);
				int empId = (int) mySession.getAttribute("employeeId");
				exp.setEmployeeId(empId);
				if (!expenseService.createExpense(exp)) {
					resp.sendError(400, "Failed to create Expense");
				} else {
					pw.write("Created expense succussfuly");
				}
			} else if (req.getParameter("expenseId") != null) {
				exp = om.readValue(req.getReader(), Expense.class);
				expenseService.updateExpense(exp);
			} 
			break;
		}
	}

	private void handleEmployees(HttpServletRequest req, HttpServletResponse resp, String[] tokens)
			throws ServletException, IOException {
		HttpSession mySession = req.getSession();
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = resp.getWriter();
		Employee emp = null;
		List<Employee> employeeList = new ArrayList<Employee>();

		switch (req.getMethod()) {
		case "GET":
			if (tokens[1].equals("All")) {
				employeeList =  employeeService.getAllEmployees();
				String test = om.writeValueAsString(employeeList);
				pw.write(test);
			} else if (tokens[1].contentEquals("MyInfo")) {
				int empId = (int) mySession.getAttribute("employeeId");
				emp = employeeService.getEmployee(empId);
				String test = om.writeValueAsString(emp);
				pw.write(test);
			}
			break;
		case "POST":
			if (req.getParameter("employeeId") == null) {
				emp = om.readValue(req.getReader(), Employee.class);
				if(!employeeService.createEmployee(emp)) {
					resp.sendError(400, "Failed to create new employee login");
				} else {
					pw.write("Successful creation");
				}
			} else if (req.getParameter("employeeId") != null) {
				emp = om.readValue(req.getReader(), Employee.class);
				employeeService.updateEmployee(emp);
			}
			
		}
	}

}
