
package com.mainclass.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mainclass.bean.HostelRoom;
import com.mainclass.repository.RoomServices;

@RestController
public class RoomController {
	@Autowired
	HostelRoom hostelRoom;
	@Autowired
	RoomServices roomService;
	
	@RequestMapping("/addingRoom")
	public ModelAndView AddRoom() {
		ModelAndView mv =new ModelAndView("AddRoom");
		return mv;
	}
	@RequestMapping("/addRoom")
	public ModelAndView AddRoom(@ModelAttribute("room") HostelRoom hostelRoom) {
		ModelAndView mv=new ModelAndView("AddRoom");
		roomService.addRoom(hostelRoom);
		mv.addObject("message","Successfully Added");
		return mv;
	}

	@RequestMapping("/updateRoom/{id}")
	public ModelAndView updateRoom(@PathVariable("id") int roomNo) {
		ModelAndView mv=new ModelAndView("UpdateRoom");
		mv.addObject("hostelRoom",roomService.getRoomById(roomNo));
		return mv;
	}
	
	@RequestMapping("/updatingRoom/{id}")
		public ModelAndView updatingMovie(@PathVariable("id") int roomNo,@ModelAttribute("hostelRoom")HostelRoom hs) {
		ModelAndView mv=new ModelAndView("redirect:/ViewRoom");
		HostelRoom h=roomService.getRoomById(roomNo);
		h.setRoomNo(roomNo);
		h.setNoOfBeds(hs.getNoOfBeds());
		roomService.updateRoom(h);
		return mv;
	}
	@RequestMapping("/deleteRoom/{id}")
	public ModelAndView deleteRoom(@PathVariable("id")int roomNo) {
		ModelAndView mv=new ModelAndView("redirect:/ViewRoom");
		roomService.deleteRoom(roomNo);
		return mv;
	}
}

