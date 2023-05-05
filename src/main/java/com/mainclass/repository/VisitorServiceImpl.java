package com.mainclass.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainclass.bean. Visitor;


@Service
public class VisitorServiceImpl implements VisitorService{
	
	@Autowired
	visitorRepository vr;

	@Override
	public Visitor addVisitor(Visitor visitor) {
		return vr.save(visitor);
	}

	@Override
	public List <Visitor> viewVisitor() {
		return (List<Visitor>) vr.findAll();
	}

	@Override
	public Visitor updateVisitor( Visitor visitor) {
		return vr.save(visitor);
	}

	@Override
	public Visitor getVisitorById(int studentId) {
		return vr.findById(studentId).get();
	}

	@Override
	public void deleteVisitor(int studentId) {
		 vr.deleteById(studentId);
	}

	@Override
	public boolean findVisitorById(int studentId) {
		return vr.existsById(studentId);
	}

	@Override
	public boolean findVisitorByName(String studentName) {
		return vr.existsBystudentName(studentName);
	}

	@Override
	public boolean existsByvisitorName1(String visitorName1) {
		return vr.existsByvisitorName1(visitorName1);
	}

	@Override
	public boolean existsByvisitorName2(String visitorName2) {
		return vr.existsByvisitorName2(visitorName2);
	}

	@Override
	public boolean existsByvisitorName3(String visitorName3) {
		return vr.existsByvisitorName3(visitorName3);
	}

	@Override
	public boolean existsByvisitorName4(String visitorName4) {
		return vr.existsByvisitorName4(visitorName4);
	}

}