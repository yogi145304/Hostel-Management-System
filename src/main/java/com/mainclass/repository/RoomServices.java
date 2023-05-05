package com.mainclass.repository;

import java.util.List;

import com.mainclass.bean.HostelRoom;


public interface RoomServices {
	HostelRoom addRoom(HostelRoom hostelRoom);
	
	List<HostelRoom> viewRoom();
	
	HostelRoom updateRoom(HostelRoom hostelRoom);
	
	HostelRoom getRoomById(int roomNo);
	
	void deleteRoom(int roomNo);

	boolean existsRoomById(int roomNo);
}
