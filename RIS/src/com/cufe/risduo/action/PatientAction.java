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
		int count = 0;
		cond = "";
		
		if (!StringUtils.isEmpty(patient.getPatientFName())){
			cond+="patientFName='"+patient.getPatientFName()+"' and ";
			count++;
		}
		if (!StringUtils.isEmpty(patient.getPatientMName())){
			cond+="patientMName='"+patient.getPatientMName()+"' and ";
			count++;
		}
		if (!StringUtils.isEmpty(patient.getPatientLName())){
			cond+="patientLName='"+patient.getPatientLName()+"' and ";
			count++;
		}
		if ((!StringUtils.isEmpty(patient.getPatientSex()))&&(patient.getPatientSex()!="null")){
			cond+="patientSex='"+patient.getPatientSex()+"' and ";
			count++;
		}
		if (!StringUtils.isEmpty(patient.getPatientBDate())){
			cond+="patientBDate='"+patient.getPatientBDate()+"' and ";
			count++;
		}
		if (!StringUtils.isEmpty(patient.getPatientAddress())){
			cond+="patientAddress='"+patient.getPatientAddress()+"' and ";
			count++;
		}
		if ((Integer.valueOf(patient.getPatientTelephone()))!=null)
			if((Integer.valueOf(patient.getPatientTelephone()))!=0){
				cond+="patientTelephone="+patient.getPatientTelephone();
				count++;
			}
			
		if ("".equals(cond))	
		{
			addFieldError("patientFName", "At least, ONE field must be filled.");		
			
		}
		else
		{
			if (count<2){
				cond= cond.replace("and", " ");
			}
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
