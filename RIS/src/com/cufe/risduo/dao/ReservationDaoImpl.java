package com.cufe.risduo.dao;



import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cufe.risduo.model.Event;
import com.cufe.risduo.model.Procedure;
import com.cufe.risduo.model.Reservation;

@Component
public class ReservationDaoImpl implements ReservationDao{
	
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
	
	
	public int create(Reservation reservation) {
		String sql = "INSERT INTO reservation (reservationExamTime, reservationReferringPhysician," +
				"reservationPatientId, reservationRoomId) " +
				"VALUES (?, ?, ?, ?)";
		 
		int numRows =  jdbcTemplate.update(sql, new Object[] {reservation.getReservationExamTime(),reservation.getReservationReferringPhysician(),reservation.getReservationPatientId(),reservation.getReservationRoomId()});
		 return numRows;
	}

	public Reservation getReservation(Integer r_Id) {
		String SQL = "select * from reservation where r_Id = ?";
		Reservation reservation= (Reservation)jdbcTemplate.queryForObject(SQL, 
                new Object[]{r_Id}, new ReservationMapper());
		return reservation;
	}

	public List<Reservation> listReservations() {
		String sql = "SELECT * FROM reservation";
		List<Reservation> reservations = jdbcTemplate.query(sql, new ReservationMapper()); 
		return reservations;
	}

	public List<Event> listEvents() {
		String sql = "SELECT * FROM reservation, patient, room " +
				"WHERE reservationPatientId = patientId AND reservationRoomId = roomId";
		List<Event> events = jdbcTemplate.query(sql, new EventMapper()); 
		return events;
	}

	public int update(Reservation reservation) {
		
		if(reservation.getReservationPatientStatus()==null){
			String sql = "UPDATE reservation set reservationExamTime=?, " +
					"reservationReferringPhysician = ?," +
					"reservationRoomId= ?, " +
					"reservationBillingType= ?,reservationBillingData= ?" +
					"where r_Id = ?";
			 
			int numRows =  jdbcTemplate.update(sql, new Object[] {reservation.getReservationExamTime(),
					reservation.getReservationReferringPhysician(),
					reservation.getReservationRoomId(), 
					reservation.getReservationBillingType(), reservation.getReservationBillingData(),
					reservation.getR_Id()});
			 return numRows;
		}
		else if (reservation.getReservationPatientStatus()==-1){
			String sql = "UPDATE reservation set reservationPatientStatus= ? where r_Id = ?";
			 
			int numRows =  jdbcTemplate.update(sql, new Object[] {reservation.getReservationPatientStatus(),reservation.getR_Id()});
			 return numRows;
		}
		else{
		String sql = "UPDATE reservation set reservationExamTime=?, " +
				"reservationAttendanceTime= ?, reservationReferringPhysician = ?," +
				"reservationPatientStatus= ?, reservationRoomId= ?, " +
				"reservationBillingType= ?,reservationBillingData= ?" +
				"where r_Id = ?";
		 
		int numRows =  jdbcTemplate.update(sql, new Object[] {reservation.getReservationExamTime(),
				reservation.getReservationAttendanceTime(),
				reservation.getReservationReferringPhysician(),reservation.getReservationPatientStatus(),
				reservation.getReservationRoomId(), 
				reservation.getReservationBillingType(), reservation.getReservationBillingData(),
				reservation.getR_Id()});
		 return numRows;
		}
	}

	
	public void delete() {
		
		
	}

	
	public Reservation getEventReservation(Integer reservationExamTime,
			Integer reservationRoomId, String patientFName, 
			String patientLName) {
		String SQL = "select * from reservation, patient where reservationPatientId=patientId and reservationExamTime = ? and reservationRoomId= ? and patientFName = ? and patientLName = ?";
		Reservation reservation= (Reservation)jdbcTemplate.queryForObject(SQL, 
                new Object[]{reservationExamTime, reservationRoomId, patientFName, patientLName}, new ReservationMapper());
		return reservation;
	}
	

	public List<Procedure> listProcedures() {
		Integer secInDay = 60*60*24;
		Integer currentTimeStamp= (int) (System.currentTimeMillis()/1000);
		Integer secPortion = currentTimeStamp%secInDay;
		Integer todayTimestamp = currentTimeStamp- secPortion;
		Integer tomTimestamp = todayTimestamp + secInDay;
		System.out.println("today:"+ todayTimestamp+"\nTom:"+tomTimestamp);
		String sql = "SELECT * FROM reservation, patient, room " +
				"WHERE " +
				"reservationPatientId = patientId AND reservationRoomId = roomId" +
				" and reservationPatientStatus = 1 " +
				"and reservationExamTime >= ? and reservationExamTime < ?";
		List<Procedure> procedures = jdbcTemplate.query(sql,new Object[]{todayTimestamp, tomTimestamp} ,new ProcedureMapper()); 
		return procedures;
	}
	
}
