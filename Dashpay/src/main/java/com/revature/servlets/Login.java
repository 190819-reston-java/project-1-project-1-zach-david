package com.revature.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.revature.service.Validate;

import java.sql.*;

public class Login extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();
        
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        System.out.println(username);
        
        if(Validate.checkUser(username, pass))
        {
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