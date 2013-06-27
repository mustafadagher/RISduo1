package com.cufe.risduo.model;

public class Room {
	
	private Integer roomId;
	private String roomName;
	
	
	public Room() {
		
	}


	public Room(Integer roomId, String roomName) {
		setRoomId(roomId);
		setRoomName(roomName);
	}


	public Integer getRoomId() {
		return roomId;
	}


	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}


	public String getRoomName() {
		return roomName;
	}


	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	}
