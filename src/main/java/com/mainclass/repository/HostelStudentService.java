package com.mainclass.repository;

import java.util.List;

import com.mainclass.bean.HostelStudent;



public interface HostelStudentService {

	HostelStudent addStudent(HostelStudent hostelStudent);
	
	List<HostelStudent> viewStudent();
	
	HostelStudent updateStudent(HostelStudent hostelStudent);
	
	HostelStudent getStudentById(int studentId);
	
	void deleteStudent(int studentId);

	}