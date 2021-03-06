package com.revature.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;
import com.revature.service.Validate;

import java.sql.*;

public class Login extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();
    	EmployeeService es = new EmployeeService();
        
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        HttpSession mySession = request.getSession();
        mySession.setAttribute("loggedin", false);
        Employee emp = es.getEmployee(username, pass);
        
        
        if(emp != null)
        {
        	mySession.setAttribute("loggedin", true);
        	mySession.setAttribute("employeeId", emp.getEmployeeId());
        	mySession.setAttribute("firstName", emp.getEmployeeFirstName());
        	mySession.setAttribute("lastName", emp.getEmployeeLastName());
        	mySession.setAttribute("isManager", emp.getManager());
        	mySession.setAttribute("email", emp.getEmail());
        	if (emp.getManager()) {
        		response.sendRedirect("managermenu.html");
        	} else {
        		response.sendRedirect("menu.html");
        	}
        	
        	
//            RequestDispatcher rs = request.getRequestDispatcher("menu.html");
//            rs.forward(request, response);
        }
        else
        {
           System.out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("index.html");
           rs.include(request, response);
        }
    }  
}