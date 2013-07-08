package com.cufe.risduo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cufe.risduo.model.ExamView;
import com.cufe.risduo.model.Procedure;


public class ExamViewMapper implements RowMapper<ExamView>{

	
	public ExamView mapRow(ResultSet rs, int rowNum) throws SQLException {

		ExamView examView = new ExamView();
	      examView.setR_Id(rs.getInt("r_Id"));
	      examView.setPatientId(rs.getInt("patientId"));
	      examView.setRoomId(rs.getInt("roomId"));
	      examView.setExamId(rs.getInt("examId"));
	      
	      examView.setReservationPatientStatus(rs.getInt("reservationPatientStatus"));
	      
	      examView.setPatientFName(rs.getString("patientFName"));
	      examView.setPatientMName(rs.getString("patientMName"));
	      examView.setPatientLName(rs.getString("patientLName"));
	      
	      examView.setRoomName(rs.getString("roomName"));
	      
	      examView.setExamEndTime(rs.getInt("examEndTime"));
	      examView.setExamStartTime(rs.getInt("examStartTime"));
	      examView.setExamPatientComplaint(rs.getString("examPatientComplaint"));
	      examView.setExamReport(rs.getString("examReport"));
		return examView;
	}

}