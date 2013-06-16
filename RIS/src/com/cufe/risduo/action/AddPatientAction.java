package com.cufe.risduo.action;

import org.apache.commons.lang.StringUtils;

import com.cufe.risduo.model.Patient;
import com.cufe.risduo.service.AddPatientService;
import com.cufe.risduo.service.LoginService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddPatientAction extends ActionSupport implements ModelDriven<Patient>{
	
	private Patient patient =  new Patient();
	
	public void validate (){
		/*if (StringUtils.isEmpty(patient.getpatientName()))
			addFieldError("patientId", "patient Name must be set.");
		if (StringUtils.isEmpty(patient.getPassword()))
			addFieldError("password", "Passowrd must be set.");*/
			
	}
	
	public String execute() {
		
		AddPatientService addPatientService= new AddPatientService();
		if (addPatientService.addPatient(patient))
			return SUCCESS;
		return LOGIN;
	}

	public Patient getpatient() {
		return patient;
	}

	public void setpatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public Patient getModel() {
		
		return patient;
	}

}
