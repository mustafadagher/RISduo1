
package com.cufe.risduo.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cufe.risduo.dao.PatientDaoImpl;
import com.cufe.risduo.dao.ReservationDaoImpl;
import com.cufe.risduo.model.Patient;
import com.cufe.risduo.model.Procedure;
import com.cufe.risduo.model.Reservation;

public class ProcedureService {
	
	public List<Procedure> searchProcedures(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ReservationDaoImpl dao = ctx.getBean("reservationDaoImpl", ReservationDaoImpl.class);
		List<Procedure> procedures = dao.listProcedures();
		
		return procedures;
	}
}