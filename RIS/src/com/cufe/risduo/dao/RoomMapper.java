package com.cufe.risduo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cufe.risduo.model.Room;

public class RoomMapper implements RowMapper<Room>{

	
	public Room mapRow(ResultSet rs, int rowNum) throws SQLException {

		Room room = new Room();
	      room.setRoomId(rs.getInt("roomId"));
	      room.setRoomName(rs.getString("roomName"));
		return room;
	}

}