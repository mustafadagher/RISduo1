package com.cufe.risduo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cufe.risduo.model.Reservation;


public class ReservationMapper implements RowMapper<Reservation>{

	
	public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {

		Reservation reservation = new Reservation();
	      reservation.setR_Id(rs.getInt("r_Id"));
	      reservation.setReservationExamTime(rs.getInt("reservationExamTime"));
	      reservation.setReservationReferringPhysician(rs.getString("reservationReferringPhysician"));
	      reservation.setReservationAttendanceTime(rs.getInt("reservationAttendanceTime"));
	      reservation.setReservationPatientId(rs.getInt("reservationPatientId"));
	      reservation.setReservationRoomId(rs.getInt("reservationRoomId"));
	      reservation.setReservationPatientStatus(rs.getInt("reservationPatientStatus"));
		return reservation;
	}

}