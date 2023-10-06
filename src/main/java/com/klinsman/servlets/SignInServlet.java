package com.klinsman.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	Connection con = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		//create database connection
		String db_username = "root";
		String db_url = "jdbc:mysql://localhost:3306/studentAdmin";
		String db_password = "good123";
		
		//db query
		String query = "SELECT * FROM student WHERE firstName = ? AND password = ?";
		
		try {
			//register the drive
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//establish the connection
			con = DriverManager.getConnection(db_url, db_username, db_password);
			
			//statement
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, userName);
			pst.setString(2, password);
			
			//execute the query
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				// user is valid
				
				//set session to name
				session.setAttribute("name", rs.getString("firstName"));
				dispatcher = request.getRequestDispatcher("index.jsp");
			} else {
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			dispatcher.forward(request, response);
					
		} catch (Exception e) {
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
