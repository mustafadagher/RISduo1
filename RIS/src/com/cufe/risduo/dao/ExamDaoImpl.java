package com.cufe.risduo.dao;



import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cufe.risduo.model.Exam;



@Component
public class ExamDaoImpl implements ExamDao{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	
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
	
	
	public int create(Exam exam) {
		String sql = "INSERT INTO exam ( examStartTime, examRoomId," +
				"examPatientId, examReservationId) " +
				"VALUES (?, ?, ?, ?)";
		 
		int numRows =  jdbcTemplate.update(sql, new Object[] {exam.getExamStartTime(), 
				exam.getExamRoomId(), exam.getExamPatientId(), exam.getExamReservationId()});
		 return numRows;
	}

	public Exam getExam(Integer examId) {
		String SQL = "select * from exam where examId = ?";
		Exam exam= (Exam)jdbcTemplate.queryForObject(SQL, 
                new Object[]{examId}, new ExamMapper());
		return exam;
	}

	public List<Exam> listExams() {
		String sql = "SELECT * FROM exam";
		List<Exam> exams = jdbcTemplate.query(sql, new ExamMapper()); 
		return exams;
	}

	
	public int update(Exam exam) {
		String sql = "UPDATE exam set examStartTime=?, " +
				"examEndTime= ?, examPatientId = ?," +
				"examReservationId= ?, examRoomId= ?, " +
				"where examId = ?";
		 
		int numRows =  jdbcTemplate.update(sql, new Object[] {exam.getExamStartTime(),
				exam.getExamEndTime(), exam.getExamPatientId(), exam.getExamReservationId(),
				exam.getExamRoomId(), exam.getExamId()});
		 return numRows;
		
	}
	
	public int updateExamEnd(Integer examReservationId, Integer examEndTime, String ExamPatientComplaint){
		
		String sql = "UPDATE exam set examEndTime= ?, ExamPatientComplaint= ? where examReservationId = ?";
		 
		int numRows =  jdbcTemplate.update(sql, new Object[] {examEndTime, ExamPatientComplaint,examReservationId});
		 return numRows;
	}
	
	public void delete() {
		
		
	}

	
	/*public Reservation getEventReservation(Integer reservationExamTime,
			Integer reservationRoomId, String patientFName, 
			String patientLName) {
		String SQL = "select * from reservation, patient where reservationPatientId=patientId and reservationExamTime = ? and reservationRoomId= ? and patientFName = ? and patientLName = ?";
		Reservation reservation= (Reservation)jdbcTemplate.queryForObject(SQL, 
                new Object[]{reservationExamTime, reservationRoomId, patientFName, patientLName}, new ReservationMapper());
		return reservation;
	}*/
	

	

	
	
}
