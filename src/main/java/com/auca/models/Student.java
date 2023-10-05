package com.auca.models;

import java.sql.Timestamp;

public class Student {
	private int studentId;
    private String firstName;
    private String lastName;
    private String email;
    private byte[] profilePicture; 
    private Timestamp registrationDate;
    
    public Student() {
        
    }

    
    // id constructor
    public Student(int studentId) {
		super();
		this.studentId = studentId;
	}
    
    
    // all attribute constructor
	public Student(String firstName, String lastName, String email, byte[] profilePicture) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.profilePicture = profilePicture;
		this.registrationDate = new Timestamp(System.currentTimeMillis());

	}

	
	//getters and setters
	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public byte[] getProfilePicture() {
		return profilePicture;
	}


	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}


	public Timestamp getRegistrationDate() {
		return registrationDate;
	}


	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}
	

	

	
    
    
}
