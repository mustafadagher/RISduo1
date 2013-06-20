package com.cufe.risduo.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cufe.risduo.dao.PatientDaoImpl;
import com.cufe.risduo.model.Patient;

public class PatientService {
	
	public boolean addPatient(Patient patient){
		//getLoggedinUser()
				//getUserRole
				//if role recep.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		PatientDaoImpl dao = ctx.getBean("patientDaoImpl", PatientDaoImpl.class);
		
		int numRows = dao.create(patient.getPatientFName(), patient.getPatientMName(), patient.getPatientLName(), patient.getPatientSex(), patient.getPatientBDate(), patient.getPatientAddress(), patient.getPatientTelephone());
		
		if (numRows>0){
			return true;
		}
		return false;
	}
	public List<Patient> searchPatients(String condition){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		PatientDaoImpl dao = ctx.getBean("patientDaoImpl", PatientDaoImpl.class);
		List<Patient> patients = dao.listPatients(condition);
		
		return patients;
	}
	
}
