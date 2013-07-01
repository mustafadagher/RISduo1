
package com.cufe.risduo.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cufe.risduo.dao.PatientDaoImpl;
import com.cufe.risduo.dao.ReservationDaoImpl;
import com.cufe.risduo.model.Patient;
import com.cufe.risduo.model.Reservation;

public class ReservationService {
	
	public boolean addReservation(Reservation reservation){
		//getLoggedinUser()
				//getUserRole
				//if role recep.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ReservationDaoImpl dao = ctx.getBean("reservationDaoImpl", ReservationDaoImpl.class);
		
		int numRows = dao.create(reservation);
		
		if (numRows>0){
			return true;
		}
		return false;
	}
	
	public Reservation editReservation(Integer reservationExamTime,
			Integer reservationRoomId, String patientFName, 
			String patientLName){
		//getLoggedinUser()
				//getUserRole
				//if role recep.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ReservationDaoImpl dao = ctx.getBean("reservationDaoImpl", ReservationDaoImpl.class);
		
		Reservation reservation = dao.getEventReservation(reservationExamTime, reservationRoomId, patientFName, patientLName);
		
		return reservation;
	}
	
	public boolean updateReservation(Reservation reservation){
		//getLoggedinUser()
				//getUserRole
				//if role recep.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ReservationDaoImpl dao = ctx.getBean("reservationDaoImpl", ReservationDaoImpl.class);
		
		int numRows = dao.update(reservation);
		
		if (numRows>0){
			return true;
		}
		return false;
	}
	
}