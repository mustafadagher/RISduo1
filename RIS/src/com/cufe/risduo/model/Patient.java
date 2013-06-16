package com.cufe.risduo.model;

public class Patient {
	
	private String patientFName;
	private String patientMName;
	private String patientLName;
	private String patientSex;
	private String patientBDate;
	private String patientAddress;
	private int patientTelephone;
	
	public Patient() {
		
	}
	
	public Patient(String patientFName, String patientMName,
			String patientLName, String patientSex, String patientBDate,
			String patientAddress, int patientTelephone) {
		
		setPatientFName(patientFName);
		setPatientMName (patientMName);
		setPatientLName (patientLName);
		setPatientSex (patientSex);
		setPatientBDate(patientBDate);
		setPatientAddress(patientAddress);
		setPatientTelephone(patientTelephone);
	}
	public String getPatientFName() {
		return patientFName;
	}
	public void setPatientName(String patientName) {
		this.patientFName = patientName;
	}
	public String getPatientMName() {
		return patientMName;
	}
	public void setPatientMName(String patientMName) {
		this.patientMName = patientMName;
	}
	public String getPatientLName() {
		return patientLName;
	}
	public void setPatientLName(String patientLName) {
		this.patientLName = patientLName;
	}
	public void setPatientFName(String patientFName) {
		this.patientFName = patientFName;
	}
	public String getPatientSex() {
		return patientSex;
	}
	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}
	public String getPatientBDate() {
		return patientBDate;
	}
	public void setPatientBDate(String patientBDate) {
		this.patientBDate = patientBDate;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public int getPatientTelephone() {
		return patientTelephone;
	}
	public void setPatientTelephone(int patientTelephone) {
		this.patientTelephone = patientTelephone;
	}
}
