package com.cufe.risduo.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.cufe.risduo.model.Patient;
import com.cufe.risduo.model.Reservation;
import com.cufe.risduo.service.PatientService;
import com.cufe.risduo.service.ReservationService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReservationAction extends ActionSupport implements ModelDriven<Reservation>{
	
	private Reservation reservation =  new Reservation();
	private List<Reservation> reservations =  new ArrayList<Reservation>();
	private String condtion = new String();
	
	
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

}
