package com.mainclass.repository;


import java.util.List;

import com.mainclass.bean.Visitor;

public interface VisitorService {

	Visitor addVisitor(Visitor visitor);
	
	List<Visitor> viewVisitor();
	
	Visitor updateVisitor(Visitor visitor);
	
	Visitor getVisitorById(int studentId);
	
	void deleteVisitor(int studentId);
	
	boolean findVisitorById(int studentId);
	
	boolean findVisitorByName(String studentName);
	
	boolean existsByvisitorName1(String visitorName1);
	
	boolean existsByvisitorName2(String visitorName2);
	
	boolean existsByvisitorName3(String visitorName3);
	
	boolean existsByvisitorName4(String visitorName4);

}
