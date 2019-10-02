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
        System.out.println(username + pass);
        HttpSession mySession = request.getSession();
        Employee emp = es.getEmployee(username, pass);
        System.out.println(emp);
        
        
        if(emp != null)
        {
        	mySession.setAttribute("employeeId", emp.getEmployeeId());
            RequestDispatcher rs = request.getRequestDispatcher("menu.html");
            rs.forward(request, response);
        }
        else
        {
           System.out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("index.html");
           rs.include(request, response);
        }
    }  
}