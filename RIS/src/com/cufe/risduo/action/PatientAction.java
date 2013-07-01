package com.cufe.risduo.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.cufe.risduo.model.Patient;
import com.cufe.risduo.service.PatientService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PatientAction extends ActionSupport implements ModelDriven<Patient>{
	
	private Patient patient =  new Patient();
	private List<Patient> patients =  new ArrayList<Patient>();
	private String condtion = new String();
	
	
	public void validate (){
		String cond =  new String();
		cond = "";
		if (!StringUtils.isEmpty(patient.getPatientFName()))
			cond+="patientFName='"+patient.getPatientFName()+"' and ";
		if (!StringUtils.isEmpty(patient.getPatientMName()))
			cond+="patientMName='"+patient.getPatientMName()+"' and ";
		if (!StringUtils.isEmpty(patient.getPatientLName()))
			cond+="patientLName='"+patient.getPatientLName()+"' and ";
		if (!StringUtils.isEmpty(patient.getPatientSex()))
			cond+="patientSex='"+patient.getPatientSex()+"' and ";
		if (!StringUtils.isEmpty(patient.getPatientBDate()))
			cond+="patientBDate='"+patient.getPatientBDate()+"' and ";
		if (!StringUtils.isEmpty(patient.getPatientAddress()))
			cond+="patientAddress='"+patient.getPatientAddress()+"' and ";
		if ((Integer.valueOf(patient.getPatientTelephone()))!=null)
			cond+="patientTelephone="+patient.getPatientTelephone();
			
		if ("".equals(cond))	
		{
			addFieldError("patientFName", "At least, ONE field must be filled.");		
			
		}
		else
		{
			setCondtion(cond);
			System.out.println(getCondtion());
		}	
	}
	
	public String execute() {
		return SUCCESS;
	}
	
	public String addPatient(){
		if (StringUtils.isNotEmpty(patient.getPatientFName())){
		PatientService PatientService= new PatientService();
		if (PatientService.addPatient(patient))
			return SUCCESS;
		return LOGIN;
		}
		else
			return INPUT;
		
	}
	public String searchPatient(){
		PatientService patientService= new PatientService();
		setPatients(patientService.searchPatients(getCondtion()));
		System.out.println(getPatients());
		return INPUT;
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

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public String getCondtion() {
		return condtion;
	}

	public void setCondtion(String condtion) {
		this.condtion = condtion;
	}

}
