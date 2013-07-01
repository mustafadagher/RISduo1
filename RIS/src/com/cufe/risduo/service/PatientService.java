package com.cufe.risduo.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cufe.risduo.dao.PatientDaoImpl;
import com.cufe.risduo.dao.ReservationDaoImpl;
import com.cufe.risduo.model.Patient;
import com.cufe.risduo.model.Reservation;

public class PatientService {
	
	public boolean addPatient(Patient patient){
		//getLoggedinUser()
				//getUserRole
				//if role recep.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		PatientDaoImpl dao = ctx.getBean("patientDaoImpl", PatientDaoImpl.class);
		System.out.println("Adding new Patient");
		int numRows = dao.create(patient.getPatientFName(), patient.getPatientMName(), patient.getPatientLName(), patient.getPatientSex(), patient.getPatientBDate(), patient.getPatientAddress(), patient.getPatientTelephone());
		
		if (numRows>0){
			System.out.println("Patient Added");
			return true;
		}
		System.out.println("No Patient added");
		return false;
	}
	public List<Patient> searchPatients(String condition){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		PatientDaoImpl dao = ctx.getBean("patientDaoImpl", PatientDaoImpl.class);
		List<Patient> patients = dao.listPatients(condition);
		
		return patients;
	}
	
	public Patient getEventPatient(Integer reservationExamTime,
			Integer reservationRoomId, String patientFName, 
			String patientLName){
		//getLoggedinUser()
				//getUserRole
				//if role recep.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		PatientDaoImpl dao = ctx.getBean("patientDaoImpl", PatientDaoImpl.class);
		
		Patient patient = dao.getEventPatient(reservationExamTime, reservationRoomId, patientFName, patientLName);
		
		return patient;
	}
	
	public boolean updatePatient(Patient patient){
		//getLoggedinUser()
				//getUserRole
				//if role recep.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		PatientDaoImpl dao = ctx.getBean("patientDaoImpl", PatientDaoImpl.class);
		
		int numRows = dao.update(patient);
		
		if (numRows>0){
			return true;
		}
		return false;
	}
	
}
