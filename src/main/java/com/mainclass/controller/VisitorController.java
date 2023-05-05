package com.mainclass.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mainclass.bean.Visitor;
import com.mainclass.repository.VisitorService;

@RestController
public class VisitorController {

	@Autowired
	VisitorService vs;
	
	@Autowired
	Visitor visit;
	
	@RequestMapping("/addingVisitor")
	public ModelAndView addVisitor() {
		ModelAndView mv =new ModelAndView("AddVisitor");
		return mv;
	}
	@RequestMapping("/addVisitor")
	public ModelAndView addVisitor(@ModelAttribute("Visitor") Visitor visitor) {
		ModelAndView mv=new ModelAndView("AddVisitor");
		vs.addVisitor(visitor);
		mv.addObject("message","Successfully Added");
		return mv;
	}
	@RequestMapping("/updateVisitor/{id}")
	public ModelAndView updateVisitor(@PathVariable("id") int studentId) {
		ModelAndView mv=new ModelAndView("UpdateVisitor");
		mv.addObject("vsr",vs.getVisitorById(studentId));
		return mv;
	}
	@RequestMapping("/updatingVisitor/{id}")
	public ModelAndView updatingMovie(@PathVariable("id") int studentId,@ModelAttribute("Visitor")Visitor visitor) {
		ModelAndView mv=new ModelAndView("redirect:/viewVisitor");
		Visitor h=vs.getVisitorById(studentId);
		h.setStudentId(studentId);
		h.setVisitorName1(visitor.getVisitorName1());
		h.setVisitorName2(visitor.getVisitorName2());
		h.setVisitorName3(visitor.getVisitorName3());
		h.setVisitorName4(visitor.getVisitorName4());
		vs.updateVisitor(h);
		mv.addObject("message","Updated Successfully!!");
		return mv;
	}
	@RequestMapping("/deleteVisitor/{id}")
	public ModelAndView deleVisitor(@PathVariable("id")int studentId) {
		ModelAndView mv=new ModelAndView("redirect:/viewVisitor");
		vs.deleteVisitor(studentId);
		return mv;
	}
	@RequestMapping("/validateVisitor")
	public ModelAndView validate(@ModelAttribute("visitor") Visitor vsr) {
		ModelAndView mv1=new ModelAndView("visitor");
		if(vs.findVisitorById(vsr.getStudentId()))
		{
			List<String> vst = new ArrayList<>();
			Visitor vste = vs.getVisitorById(vsr.getStudentId());
			vst.add(vste.getVisitorName1());
			vst.add(vste.getVisitorName2());
			vst.add(vste.getVisitorName3());
			vst.add(vste.getVisitorName4());
			
			if(vste.getStudentName().equalsIgnoreCase(vsr.getStudentName()))
			{
				if(vst.contains(vsr.getVisitorName1()))
				{
					mv1.addObject("message","Valid Visitor!!");
					return mv1;
				}
				else
				{
					mv1.addObject("message","Visitor Restricted!!");
					return mv1;
				}
			}
			else
			{
			mv1.addObject("message","Enter Correct Stu dent Name!!");
			return mv1;
			}
		}
		else
		{
		mv1.addObject("message","Enter Correct Student Id!!");
		return mv1;
		}
	}
}