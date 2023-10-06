package com.klinsman.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Connection con = null;
		RequestDispatcher dispatcher = null;
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		
		if(firstName.isEmpty() ||
				lastName.isEmpty() ||
				password.isEmpty() ||
				confirmPassword.isEmpty()) {
			out.print("firstName/lastName/password/ is missing!");
		}
		
		//create database connection
		String db_username = "root";
		String db_url = "jdbc:mysql://localhost:3306/studentAdmin";
		String db_password = "good123";
		
		//query
		String query = "INSERT INTO student(firstName, lastName, password) VALUES(?,?,?)";
		
				
		try {
			//register the drive
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create connection
			con = DriverManager.getConnection(db_url, db_username, db_password);
			
			//create a statement
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, firstName);
			pst.setString(2, lastName);
			pst.setString(3, password);
			
			//rows affected
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("login.jsp");
			
			if(rowCount > 0) {
				//record was inserted
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}
			dispatcher.forward(request, response);
			
			
		} catch (Exception e) {
			out.print("status: FAILED");
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}

}
