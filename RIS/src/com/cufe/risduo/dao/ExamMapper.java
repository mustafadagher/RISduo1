package com.cufe.risduo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cufe.risduo.model.Exam;


public class ExamMapper implements RowMapper<Exam>{

	
	public Exam mapRow(ResultSet rs, int rowNum) throws SQLException {

		Exam exam = new Exam();
	      exam.setExamId(rs.getInt("examId"));
	      exam.setExamStartTime(rs.getInt("examStartTime"));
	      exam.setExamEndTime(rs.getInt("examEndTime"));
	      exam.setExamReport(rs.getString("examReport"));
	      exam.setExamReport(rs.getString("ExamPatientComplaint"));
	      exam.setExamPatientId(rs.getInt("examPatientId"));
	      exam.setExamReservationId(rs.getInt("examReservationId"));
	      exam.setExamRoomId(rs.getInt("examRoomId"));
	      exam.setExamCreator(rs.getString("examCreator"));
		return exam;
	}

}