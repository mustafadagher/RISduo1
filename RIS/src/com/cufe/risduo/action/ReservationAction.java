package com.cufe.risduo.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.cufe.risduo.model.Patient;
import com.cufe.risduo.model.Reservation;
import com.cufe.risduo.service.PatientService;
import com.cufe.risduo.service.ReservationService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReservationAction extends ActionSupport implements ModelDriven<Reservation>, ServletResponseAware, ServletRequestAware{
	
	protected HttpServletResponse servletResponse;
	protected HttpServletRequest servletRequest;
	
	
	private Reservation reservation =  new Reservation();
	private Patient patient = new Patient();
	private List<Reservation> reservations =  new ArrayList<Reservation>();
	private String condtion = new String();
	
	private String patientFName;
	private String patientLName;
	private String patientMName;
	private Long patientNID;
	
	
	public void validate (){
		
	}
	
	public String execute() {
		return SUCCESS;
	}
	
	public String addReservation(){
		
		ReservationService reservationService= new ReservationService();
		if (reservationService.addReservation(getReservation()))
			return SUCCESS;
		return ERROR;
		
	}
	
	public String editReservation(){
		Reservation reservation1 = getReservation();
		Patient patient1 = new Patient(); 
		ReservationService reservationService= new ReservationService();
		PatientService patientService = new PatientService();
		
		patient1 = patientService.getEventPatient(reservation1.getReservationExamTime(), reservation1.getReservationRoomId(), getPatientFName(), getPatientLName());
		reservation1= reservationService.editReservation(reservation1.getReservationExamTime(), reservation1.getReservationRoomId(), getPatientFName(), getPatientLName());
		
		// Save to cookie
		Cookie pid = new Cookie("patientID", String.format("%d",patient1.getPatientId()));
		pid.setPath("/");
		servletResponse.addCookie(pid);
		
		
		Cookie rid = new Cookie("r_Id", String.format("%d",reservation1.getR_Id()));		
		rid.setPath("/");
		servletResponse.addCookie(rid);
		
		setPatient(patient1);
		setReservation(reservation1);
		return INPUT;
	}
	
	public String jobOrder(){
		Integer patientId= null;
		Integer r_Id=null;
		// Load from cookie
		 for(Cookie c : servletRequest.getCookies()) {
		   if (c.getName().equals("patientID")){
			   	patientId  =Integer.parseInt(c.getValue());
			   	c.setMaxAge(0);
			   	c.setValue("");
			   	servletResponse.addCookie(c);
			   }
		   if (c.getName().equals("r_Id")){
			   r_Id= Integer.parseInt(c.getValue());
			   //clearing cookies after assigning them to variables
			   c.setMaxAge(0);
			   c.setValue("");
			   servletResponse.addCookie(c);
		   }
		 }
		  
		  this.patient.setPatientId(patientId);
		  this.patient.setPatientFName(patientFName);
		  this.patient.setPatientMName(patientMName);
		  this.patient.setPatientLName(patientLName);
		  this.patient.setPatientNID(patientNID);
		  
		  this.reservation.setR_Id(r_Id);
		  
		  //job order changes the reservation patient status to flag attending
		  this.reservation.setReservationPatientStatus(1);
		  
		  Integer time = (int) (System.currentTimeMillis()/1000);
		  this.reservation.setReservationAttendanceTime(time);
		System.out.println("Patient ID: "+patientId);
		System.out.println("Reservation ID: "+r_Id);
		
		ReservationService reservationService= new ReservationService();
		PatientService patientService = new PatientService();
		
		if (reservationService.updateReservation(getReservation()) && patientService.updatePatient(getPatient()))
			return SUCCESS;
		
		return ERROR;
		
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public Reservation getModel() {
		
		return reservation;
	}

	

	public String getCondtion() {
		return condtion;
	}

	public void setCondtion(String condtion) {
		this.condtion = condtion;
	}

	public String getPatientFName() {
		return patientFName;
	}

	public void setPatientFName(String patientFName) {
		this.patientFName = patientFName;
	}

	public String getPatientLName() {
		return patientLName;
	}

	public void setPatientLName(String patientLName) {
		this.patientLName = patientLName;
	}

	public String getPatientMName() {
		return patientMName;
	}

	public void setPatientMName(String patientMName) {
		this.patientMName = patientMName;
	}

	public Long getPatientNID() {
		return patientNID;
	}

	public void setPatientNID(Long patientNID) {
		this.patientNID = patientNID;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
		setPatientMName(this.patient.getPatientMName());
	}

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
		
	}

	@Override
	public void setServletResponse(HttpServletResponse servletResponse) {
		this.servletResponse = servletResponse;
		
	}

}
