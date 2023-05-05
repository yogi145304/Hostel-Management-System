package com.mainclass.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class HostelRoom {
	
	@Id
	private int roomNo;
	private int noOfBeds;
	public HostelRoom() {
		super();
	}
	public HostelRoom(int roomNo, int noOfBeds) {
		super();
		this.roomNo = roomNo;
		this.noOfBeds = noOfBeds;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public int getNoOfBeds() {
		return noOfBeds;
	}
	public void setNoOfBeds(int noOfBeds) {
		this.noOfBeds = noOfBeds;
	}
	
	

}
