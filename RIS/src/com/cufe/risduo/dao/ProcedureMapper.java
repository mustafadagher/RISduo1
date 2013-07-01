package com.cufe.risduo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cufe.risduo.model.Procedure;


public class ProcedureMapper implements RowMapper<Procedure>{

	
	public Procedure mapRow(ResultSet rs, int rowNum) throws SQLException {

		Procedure procedure = new Procedure();
	      procedure.setR_Id(rs.getInt("r_Id"));
	      procedure.setReservationExamTime(rs.getInt("reservationExamTime"));
	      procedure.setReservationAttendanceTime(rs.getInt("reservationAttendanceTime"));
	      procedure.setReservationPatientStatus(rs.getInt("reservationPatientStatus"));
	      procedure.setPatientId(rs.getInt("patientId"));
	      procedure.setPatientFName(rs.getString("patientFName"));
	      procedure.setPatientMName(rs.getString("patientMName"));
	      procedure.setPatientLName(rs.getString("patientLName"));
	      procedure.setRoomId(rs.getInt("roomId"));
	      procedure.setRoomName(rs.getString("roomName"));
		return procedure;
	}

}