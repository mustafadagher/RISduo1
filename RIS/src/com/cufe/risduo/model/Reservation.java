package com.cufe.risduo.model;



public class Reservation {
	
	private Integer r_Id;
	private Integer reservationExamTime;
	private String reservationReferringPhysician;
	private Integer reservationAttendanceTime;
	private Integer reservationPatientId;
	private Integer reservationRoomId;
	
	public Integer getR_Id() {
		return r_Id;
	}
	public void setR_Id(Integer r_Id) {
		this.r_Id = r_Id;
	}
	public Integer getReservationExamTime() {
		return reservationExamTime;
	}
	public void setReservationExamTime(Integer reservationExamTime) {
		this.reservationExamTime = reservationExamTime;
	}
	public String getReservationReferringPhysician() {
		return reservationReferringPhysician;
	}
	public void setReservationReferringPhysician(
			String reservationReferringPhysician) {
		this.reservationReferringPhysician = reservationReferringPhysician;
	}
	public Integer getReservationAttendanceTime() {
		return reservationAttendanceTime;
	}
	public void setReservationAttendanceTime(Integer reservationAttendanceTime) {
		this.reservationAttendanceTime = reservationAttendanceTime;
	}
	public Integer getReservationPatientId() {
		return reservationPatientId;
	}
	public void setReservationPatientId(Integer reservationPatientId) {
		this.reservationPatientId = reservationPatientId;
	}
	public Integer getReservationRoomId() {
		return reservationRoomId;
	}
	public void setReservationRoomId(Integer reservationRoomId) {
		this.reservationRoomId = reservationRoomId;
	}
	
	
	
}
