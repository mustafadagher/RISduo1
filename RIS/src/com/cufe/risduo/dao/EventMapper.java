package com.cufe.risduo.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

import com.cufe.risduo.model.Event;
import com.cufe.risduo.model.Reservation;
import com.cufe.risduo.model.Room;

public class EventMapper implements RowMapper<Event>{

	
	public Event mapRow(ResultSet rs, int rowNum) throws SQLException {

		String fName = rs.getNString("patientFName");
		String lName = rs.getNString("patientLName");
		String title = fName+" "+lName;
		long examDuration = rs.getInt("roomScanDuration")*60;
		int patientStatus= rs.getInt("patientStatus");
		String color= "blue";
		String textColor= "white";
		//yyyy-mm-dd hh:mm:ss
		
		DateFormat df = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
		
		Long startTimestamp = rs.getLong("reservationExamTime");
		Long endTimestamp = startTimestamp + examDuration;
		
		String start = df.format(new Date((startTimestamp*1000)));
		String end = df.format(new Date ((endTimestamp*1000)));
		
		
		switch (patientStatus){
		case 0:
			color = "blue";
			textColor= "white";
			break;
		case 1: 
			color = "green";
			textColor= "black";
			break;
		case 2:
			color = "red";
			textColor= "blue";
			break;
		case 3:
			color = "brown";
			textColor= "white";
			break;
		case 4:
			color = "white";
			textColor= "black";
			break;
		case -1:
			color = "black";
			textColor= "white";
			break;
		default:
			color = "blue";
			textColor= "white";
			break;
		}
		
		
		Event event = new Event();
	    event.setTitle(title);
	    event.setStart(start); 
	    event.setEnd(end);
	    event.setResourceId(rs.getInt("reservationRoomId"));
	    event.setColor(color);
	    event.setTextColor(textColor);
		return event;
	}

}