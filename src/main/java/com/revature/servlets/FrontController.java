package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

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

	private ExpenseService expenseService;
	private EmployeeService employeeService;

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
		case "expenses":
			handleExpenses(req, resp, tokens);
			break;
		case "register":
			handleEmployees(req, resp, tokens);
			break;
		case "addreimbursement":
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
		

		switch (req.getMethod()) {
		case "GET":
			if (tokens.length == 1) {
				String jsonExpenses = om.writeValueAsString(expenseService.getAllExpenses());
				pw.write(jsonExpenses);
			} else {
				int expId = Integer.parseInt(tokens[1]);
				String jsonExpense = om.writeValueAsString(expenseService.getExpense(expId));
			}
			break;
		case "POST":
			exp = om.readValue(req.getReader(), Expense.class);
			int empId = (int) mySession.getAttribute("employeeId");
			exp.setEmployeeId(empId);
	
			if (!expenseService.createExpense(exp)) {
				resp.sendError(400, "Failed to creat Expense");
			} else {
				pw.write("Created expense succussfuly");
			}
			break;
		}
	}

	private void handleEmployees(HttpServletRequest req, HttpServletResponse resp, String[] tokens)
			throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = resp.getWriter();
		Employee emp = null;

		switch (req.getMethod()) {
		case "GET":
			if (tokens.length == 1) {
				String jsonEmployees = om.writeValueAsString(employeeService.getAllEmployees());
				pw.write(jsonEmployees);
			} else {
				int empId = Integer.parseInt(tokens[1]);
				String jsonEmployee = om.writeValueAsString(expenseService.getExpense(empId));
				pw.write(jsonEmployee);
			}
			break;
		case "POST":
			emp = om.readValue(req.getReader(), Employee.class);
			if(!employeeService.createEmployee(emp)) {
				resp.sendError(400, "Failed to create new employee login");
			} else {
				pw.write("Successful creation");
			}
		}
	}

}
