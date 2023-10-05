package com.auca.models;

public class User {
	private int userId;
	private int studentId;
	private String username;
	private String password;
	
	public User() {
	    
	}
	 
	public User(int userId) {
		super();
		this.userId = userId;
	}


	public User(int studentId, String username, String password) {
		super();
		
		this.studentId = studentId;
		this.username = username;
		this.password = password;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public int getStudentId() {
		return studentId;
	}



	public void setStudentId(int studentId) {
		this.studentId = studentId;
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


			 
}
