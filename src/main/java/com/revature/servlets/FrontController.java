package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
			resp.sendError(400, "Usage: /expenses or /employeeinfo");
			return;
		}

		switch (tokens[0]) {
		case "employeeinfo":
			handleEmployees(req, resp, tokens);
			break;
		case "expenses":
			handleExpenses(req, resp, tokens);
			break;
		default:
			resp.sendError(404, "Token not recognized: " + tokens[0]);
			break;
		}
		
	}

	private void handleExpenses(HttpServletRequest req, HttpServletResponse resp, String[] tokens) throws ServletException, IOException {
		ObjectMapper objectMap = new ObjectMapper();
		PrintWriter pw = resp.getWriter();
		
		switch(req.getMethod()) {
		case "GET":
			if (tokens.length == 1) {
				String jsonExpenses = objectMap.writeValueAsString(expenseService.getAllExpenses());
				pw.write(jsonExpenses);
			} else {
				int expId = Integer.parseInt(tokens[1]);
				String jsonExpense = objectMap.writeValueAsString(expenseService.getExpense(expId));

			}
		}
		
	}

	private void handleEmployees(HttpServletRequest req, HttpServletResponse resp, String[] tokens) throws ServletException, IOException {
		ObjectMapper objectMap = new ObjectMapper();
		PrintWriter pw = resp.getWriter();
		
		switch(req.getMethod()) {
		case "GET":
			if (tokens.length == 1) {
				String jsonEmployees = objectMap.writeValueAsString(employeeService.getAllEmployees());
				pw.write(jsonEmployees);
			} else {
				int empId = Integer.parseInt(tokens[1]);
				String jsonEmployee = objectMap.writeValueAsString(expenseService.getExpense(empId));
				pw.write(jsonEmployee);
			}
		}
	}
	 
}
