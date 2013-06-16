package com.cufe.risduo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cufe.risduo.model.Patient;

public class PatientMapper implements RowMapper<Patient>{

	
	public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {

		Patient patient = new Patient();
	      patient.setPatientFName(rs.getString("patientFName"));
	      patient.setPatientMName(rs.getString("patientMName"));
	      patient.setPatientLName(rs.getString("patientLName"));
	      patient.setPatientSex(rs.getString("patientSex"));
	      patient.setPatientBDate(rs.getString("patientBDate"));
	      patient.setPatientAddress(rs.getString("patientAddress"));
	      patient.setPatientTelephone(rs.getInt("patientTelephone"));
	      return patient;
		
	}

}