package com.mainclass.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainclass.bean.HostelStudent;


@Service
public class HostelStudentImplementation implements HostelStudentService {

	@Autowired
	StudentRepository studentRepo;
	
	@Override
	public HostelStudent addStudent(HostelStudent hostelStudent) {
		return studentRepo.save(hostelStudent);
	}
	
	@Override
	public List<HostelStudent> viewStudent() {
		return (List<HostelStudent>) studentRepo.findAll();
	}
	
	@Override
	public HostelStudent updateStudent(HostelStudent hostelStudent) {
		return studentRepo.save(hostelStudent);
	}
	
	@Override
	public HostelStudent getStudentById(int studentId) {
		return studentRepo.findById(studentId).get();
	}
	
	@Override
	public void deleteStudent(int studentId) {
		studentRepo.deleteById(studentId);
	}
}
