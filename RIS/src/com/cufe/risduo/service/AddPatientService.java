package com.cufe.risduo.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cufe.risduo.dao.PatientDaoImpl;
import com.cufe.risduo.model.Patient;

public class AddPatientService {
	
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
}
