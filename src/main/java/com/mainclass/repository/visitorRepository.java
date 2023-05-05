package com.mainclass.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mainclass.bean.Visitor;

@Repository
public interface visitorRepository extends CrudRepository<Visitor,Integer>{

	boolean existsBystudentName(String studentName);
	
	boolean existsByvisitorName1(String visitorName1);
	
	boolean existsByvisitorName2(String visitorName2);
	
	boolean existsByvisitorName3(String visitorName3);
	
	boolean existsByvisitorName4(String visitorName4);
}