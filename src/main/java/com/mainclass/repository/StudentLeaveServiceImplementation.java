package com.mainclass.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainclass.bean.HostelStudent;
import com.mainclass.bean.StudentLeave;

@Service
public class StudentLeaveServiceImplementation implements StudentLeaveService{
	
	@Autowired
	LeaveRepository leaverep;

	@Override
	public StudentLeave addLeave(StudentLeave studentLeave) {
		return leaverep.save(studentLeave);
	}

	@Override
	public List<StudentLeave> viewLeave() {
		return (List<StudentLeave>)leaverep.findAll();
	}

	@Override
	public void deleteLeave(int studentId) {
		 leaverep.deleteById(studentId);;
	}
	
	

}
