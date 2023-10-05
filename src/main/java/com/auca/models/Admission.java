package com.auca.models;

import java.sql.Date;

public class Admission {
    private int admissionId;
    private int studentId;
    private Date admissionDate;
    private String status;
    
    public Admission() {
        
    }

    
	public Admission(int admissionId) {
		super();
		this.admissionId = admissionId;
	}


	public Admission(int studentId, Date admissionDate, String status) {
		super();
		
		this.studentId = studentId;
		this.admissionDate = admissionDate;
		this.status = status;
	}


	public int getAdmissionId() {
		return admissionId;
	}


	public void setAdmissionId(int admissionId) {
		this.admissionId = admissionId;
	}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public Date getAdmissionDate() {
		return admissionDate;
	}


	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
    
    
}
