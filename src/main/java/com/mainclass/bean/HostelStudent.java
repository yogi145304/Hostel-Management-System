package com.mainclass.bean;

//import java.util.String;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table
public class HostelStudent {

	@Id
	private int studentId;
	private String studentName;
	private String fatherName;
	private int roomNumber;
	private String dob;
	private String gender;
	private long contactNumber;
	private String emailId;
	private String address;
	public HostelStudent() {
		
	}
	public HostelStudent(int studentId, String studentName, String fatherName, int roomNumber, String dob, String gender,
			long contactNumber, String emailId, String address) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.fatherName = fatherName;
		this.roomNumber = roomNumber;
		this.dob = dob;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.address = address;
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
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}