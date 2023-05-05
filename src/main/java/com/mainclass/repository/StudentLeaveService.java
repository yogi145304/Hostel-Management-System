package com.mainclass.repository;

import java.util.List;

import com.mainclass.bean.StudentLeave;

public interface StudentLeaveService {
	
	StudentLeave addLeave(StudentLeave studentLeave);
	
	List<StudentLeave> viewLeave();
	
	void deleteLeave(int studentId);

}
