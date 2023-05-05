package com.mainclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.mainclass.bean.Admin;
import com.mainclass.bean.HostelStudent;
import com.mainclass.bean.StudentLeave;
import com.mainclass.repository.HostelStudentImplementation;
import com.mainclass.repository.HostelStudentService;
import com.mainclass.repository.RoomServices;
import com.mainclass.repository.StudentLeaveService;
import com.mainclass.repository.VisitorService;

@RestController
public class HostelController {
	@Autowired
	Admin admin;
	
	@Autowired
	HostelStudent hostelStudent;
	
	@Autowired
	HostelStudentService studentService;
	
	@Autowired
	HostelStudentImplementation impl;
	
	@Autowired
	StudentLeaveService leaveService;
	
	@Autowired
	VisitorService vs;
	
	@Autowired
	RoomServices roomService;
	
	@Autowired
	RoomServices rs;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	String mail=null;
	
	
	@RequestMapping("/adminLogin")
	public ModelAndView login() {
		ModelAndView mv =new ModelAndView("AdminLogin");
		return mv;
	}
	
	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mv1 =new ModelAndView("AdminLogin");
		if(mail==null)
		{
			return mv1;
		}
		else {
		ModelAndView mv =new ModelAndView("AdminWork");
		return mv;
		}
	}
	
	@RequestMapping("/validate")
	public ModelAndView validate(@RequestParam("userId") String userId,@RequestParam("password") String password) {
		ModelAndView mv1=new ModelAndView("AdminWork");
		ModelAndView mv2=new ModelAndView("AdminLogin");
		mail = userId;
		if(userId.equals("harini@gmail.com") && password.equals("1234")) {
			return mv1;
		}
		else {
			mv2.addObject("message","Invalid Credentials!!Please Try Again");
			return mv2;
		} 	
		
	}
	
	@RequestMapping("/addingStudent")
	public ModelAndView addStudent() {
		ModelAndView mv1 =new ModelAndView("AdminLogin");
		if(mail==null)
		{
			return mv1;
		}
		else {
			ModelAndView mv =new ModelAndView("AddStudent");
			return mv;
		}
	}
	
	@RequestMapping("/addStudent")
	public ModelAndView addStudent(@ModelAttribute("student") HostelStudent hostelStudent) {
		ModelAndView mv1 =new ModelAndView("AdminLogin");
		if(mail==null)
		{
			return mv1;
		}
		else {
			ModelAndView mv=new ModelAndView("AddStudent");
			if(rs.existsRoomById(hostelStudent.getRoomNumber()))
			{
				if(rs.getRoomById(hostelStudent.getRoomNumber()).getNoOfBeds()<1)
				{
					mv.addObject("message","No bed available");
					return mv;
				}
				else
				{
					studentService.addStudent(hostelStudent);
					String sql = "UPDATE sms.hostel_room SET no_of_beds = no_of_beds - 1 WHERE room_no = ?";
					jdbcTemplate.update(sql, hostelStudent.getRoomNumber());
					mv.addObject("message","Successfully Added");
					return mv;
				}
			}
			else
			{
				mv.addObject("message","No such room Available");
				return mv;
			}
		}
	}
	
	@RequestMapping("/viewStudent")
	public ModelAndView viewStudent() {
		ModelAndView mv1 =new ModelAndView("AdminLogin");
		if(mail==null)
		{
			return mv1;
		}
		else {
			ModelAndView mv =new ModelAndView("ViewStudent");
			mv.addObject("HostelStudents",studentService.viewStudent());
			return mv;
		}
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout() {
		ModelAndView mv1 =new ModelAndView("AdminLogin");
		if(mail==null)
		{
			return mv1;
		}
		else {
			mail = null;
			ModelAndView mv =new ModelAndView("Logout");
			return mv;
		}
	}
	
	@RequestMapping("/updateStudent/{id}")
	public ModelAndView updateStudent(@PathVariable("id") int studentId) {
		ModelAndView mv1 =new ModelAndView("AdminLogin");
		if(mail==null)
		{
			return mv1;
		}
		else {
			ModelAndView mv=new ModelAndView("UpdateStudent");
			mv.addObject("hostelStudent",studentService.getStudentById(studentId));
			return mv;
		}
	}
	
	@RequestMapping("/updatingStudent/{id}")
	public ModelAndView updatingMovie(@PathVariable("id") int studentId,@ModelAttribute("hostelStudent")HostelStudent hs) {
		ModelAndView mv1 =new ModelAndView("AdminLogin");
		if(mail==null)
		{
			return mv1;
		}
		else {
			ModelAndView mv=new ModelAndView("UpdateStudent");
			HostelStudent h=studentService.getStudentById(studentId);
			int previousRoom = h.getRoomNumber();
			System.out.println(previousRoom);
			h.setStudentId(studentId);
			h.setStudentName(hs.getStudentName());
			h.setFatherName(hs.getFatherName());
			h.setRoomNumber(hs.getRoomNumber());
			h.setDob(hs.getDob());
			h.setGender(hs.getGender());
			h.setContactNumber(hs.getContactNumber());
			h.setEmailId(hs.getEmailId());
			h.setAddress(hs.getAddress());
			studentService.updateStudent(h);
			String sql1 = "UPDATE sms.hostel_room SET no_of_beds = no_of_beds + 1 WHERE room_no = ?";
			jdbcTemplate.update(sql1, previousRoom);
			int roomNo = hs.getRoomNumber();
			String sql2 = "UPDATE sms.hostel_room SET no_of_beds = no_of_beds - 1 WHERE room_no = ?";
			jdbcTemplate.update(sql2, roomNo);
			mv.addObject("message","Updated Successfully!!");
			return mv;
		}
	}
	
	@RequestMapping("/deleteStudent/{id}")
	public ModelAndView deleStudent(@PathVariable("id")int studentId) {
		ModelAndView mv1 =new ModelAndView("AdminLogin");
		if(mail==null)
		{
			return mv1;
		}
		else {
			ModelAndView mv=new ModelAndView("redirect:/viewStudent");
			studentService.deleteStudent(studentId);
			return mv;
		}
	}
	
	@RequestMapping("/leaveApplication")
	public ModelAndView leaveappication()
	{
		ModelAndView mv1 =new ModelAndView("AdminLogin");
		if(mail==null)
		{
			return mv1;
		}
		else {
			ModelAndView mv = new ModelAndView("LeaveApplication");
			return mv;
		}
	}
	
	@RequestMapping("/addLeave")
	public ModelAndView addLeave(@ModelAttribute("studentLeave") StudentLeave studentLeave) {
		ModelAndView mv1 =new ModelAndView("AdminLogin");
		if(mail==null)
		{
			return mv1;
		}
		else {
			ModelAndView mv=new ModelAndView("LeaveApplication");
			leaveService.addLeave(studentLeave);
			mv.addObject("message","Leave applied Successfully");
			return mv;
		}
	}
	
	@RequestMapping("/Visitor")
	public ModelAndView visitor()
	{
		ModelAndView mv1 =new ModelAndView("AdminLogin");
		if(mail==null)
		{
			return mv1;
		}
		else {
			ModelAndView mv = new ModelAndView("Visitor");
			return mv;
		}
	}
	
	@RequestMapping("/viewVisitor")
	public ModelAndView viewVisitor() {
		ModelAndView mv1 =new ModelAndView("AdminLogin");
		if(mail==null)
		{
			return mv1;
		}
		else {
			ModelAndView mv =new ModelAndView("ViewVisitor");
			mv.addObject("Visitors",vs.viewVisitor());
			return mv;
		}
	}
	
	@RequestMapping("/viewRoom")
	public ModelAndView viewRoom() {
		ModelAndView mv1 =new ModelAndView("AdminLogin");
		if(mail==null)
		{
			return mv1;
		}
		else {
			ModelAndView mv =new ModelAndView("AvailableRooms");
			mv.addObject("HostelRooms",roomService.viewRoom());
			return mv;
		}
	}
	
	@RequestMapping("/viewLeave")
	public ModelAndView viewLeave() {
		ModelAndView mv1 =new ModelAndView("AdminLogin");
		if(mail==null)
		{
			return mv1;
		}
		else {
			ModelAndView mv =new ModelAndView("LeaveList");
			mv.addObject("StudentLeave",leaveService.viewLeave());
			return mv;
		}
	}
	
	@RequestMapping("/deleteLeave/{id}")
	public ModelAndView deleLeave(@PathVariable("id")int studentId) {
		ModelAndView mv1 =new ModelAndView("AdminLogin");
		if(mail==null)
		{
			return mv1;
		}
		else {
			ModelAndView mv=new ModelAndView("LeaveList");
			leaveService.deleteLeave(studentId);
			return mv;
		}
	}
}