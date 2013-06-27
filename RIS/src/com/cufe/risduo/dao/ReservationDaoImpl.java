package com.cufe.risduo.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cufe.risduo.model.Event;
import com.cufe.risduo.model.Reservation;
import com.cufe.risduo.model.Resource;
import com.cufe.risduo.model.Room;

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

	public void update(Reservation reservation) {

		
	}

	
	public void delete() {
		
		
	}
	
}
