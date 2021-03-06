package com.cufe.risduo.dao;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.cufe.risduo.model.Patient;
import com.cufe.risduo.model.Reservation;

@Component
public class PatientDaoImpl implements PatientDao{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public Patient getPatient(String patientFName){
		
		String SQL = "select * from patient where patientFName = ?";
		Patient patient = (Patient)jdbcTemplate.queryForObject(SQL, 
                new Object[]{patientFName}, new PatientMapper());
		return patient;
		
	      
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdpcTemplate() {
		return jdbcTemplate;
	}

	public void setJdpcTemplate(JdbcTemplate jdpcTemplate) {
		this.jdbcTemplate = jdpcTemplate;
	}

	
	public int create(String patientFName, String patientMName,
			String patientLName, String patientSex, String patientBDate,
			String patientAddress, int patientTelephone) {
		String sql = "INSERT INTO risduo.patient " +
				"(patientFName, patientMName, patientLName, patientSex, " +
				"patientBDate, patientAddress, patientTelephone) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?)";
		 
		int numRows =  jdbcTemplate.update(sql, new Object[] { patientFName, patientMName, patientLName, 
				 patientSex, patientBDate, patientAddress, patientTelephone });
		 return numRows;
	}

	
	public List<Patient> listPatients(String condition) {
		
		String sql = "SELECT * FROM Patient WHERE "+condition;
		List<Patient> patients = jdbcTemplate.query(sql, new PatientMapper()); 
		return patients;
		
	}

	
	public void delete() {
		
		
	}

	
	public int update(Patient patient) {
		
		String sql = "UPDATE patient set patientFName=?, " +
				"patientMName= ?, patientLName = ?," +
				"patientNID= ? where patientID = ?";
			 
		int numRows =  jdbcTemplate.update(sql, new Object[] {patient.getPatientFName(), 
				patient.getPatientMName(), patient.getPatientLName(), patient.getPatientNID(), patient.getPatientId()});
		 return numRows;
			
	}

	
	public Patient getEventPatient(Integer reservationExamTime,
			Integer reservationRoomId, String patientFName, String patientLName) {
		String SQL = "select * from reservation, patient where reservationPatientId=patientId and reservationExamTime = ? and reservationRoomId= ? and patientFName = ? and patientLName = ?";
		Patient patient = (Patient)jdbcTemplate.queryForObject(SQL, 
                new Object[]{reservationExamTime, reservationRoomId, patientFName, patientLName}, new PatientMapper());
		return patient;
	}
}
