package com.mainclass.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainclass.bean.HostelRoom;
import com.mainclass.bean.HostelStudent;

@Service
public class RoomImplementation implements RoomServices{
	@Autowired
	HostelRepository roomRepo;

	@Override
	public HostelRoom addRoom(HostelRoom hostelRoom) {
		//if(hostelRoom.getNoOfBeds()>0&&hostelRoom.getNoOfBeds()<5)
			return roomRepo.save(hostelRoom);
		//return null;
	}
	@Override
	public List<HostelRoom> viewRoom() {
		List<HostelRoom> totalrooms = (List<HostelRoom>) roomRepo.findAll();
		List<HostelRoom> availrooms = new ArrayList<>();
		for(HostelRoom hr:totalrooms)
		{
			if(hr.getNoOfBeds()>0)
			{
				availrooms.add(hr);
			}
		}
		return availrooms;
	}

	@Override
	public HostelRoom updateRoom(HostelRoom hostelRoom) {
		return roomRepo.save(hostelRoom);
	}

	@Override
	public HostelRoom getRoomById(int roomNo) {
			return roomRepo.findById(roomNo).get();
	}

	@Override
	public void deleteRoom(int roomNo) {
		roomRepo.deleteById(roomNo);
		
	}
	@Override
	public boolean existsRoomById(int roomNo) {
		return roomRepo.existsById(roomNo);
	}
	

}
