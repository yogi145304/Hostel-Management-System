package com.mainclass.bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class StudentLeave {
	
	@Id
	private int studentId;
	private String studentName;
	private int roomNumber;
	private Date leavingDate;
	private Date returnDate;
	private double contactNumber;
	private String Reason;
	public StudentLeave() {
		super();
	}
	public StudentLeave(int studentId, String studentName, int roomNumber, Date leavingDate, Date returnDate,
			double contactNumber, String reason) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.roomNumber = roomNumber;
		this.leavingDate = leavingDate;
		this.returnDate = returnDate;
		this.contactNumber = contactNumber;
		Reason = reason;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getLeavingDate() {
		return leavingDate;
	}
	public void setLeavingDate(Date leavingDate) {
		this.leavingDate = leavingDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public double getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(double contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	
	
}
