package com.cufe.risduo.model;

public class Procedure {
	private Integer r_Id;
	private Integer reservationExamTime;
	private Integer reservationAttendanceTime;
	private Integer reservationPatientStatus;
	private Integer patientId;
	private String patientFName;
	private String patientMName;
	private String patientLName;
	private Integer roomId;
	private String roomName;
	
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
	public Integer getReservationAttendanceTime() {
		return reservationAttendanceTime;
	}
	public void setReservationAttendanceTime(Integer reservationAttendanceTime) {
		this.reservationAttendanceTime = reservationAttendanceTime;
	}
	public Integer getReservationPatientStatus() {
		return reservationPatientStatus;
	}
	public void setReservationPatientStatus(Integer reservationPatientStatus) {
		this.reservationPatientStatus = reservationPatientStatus;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public String getPatientFName() {
		return patientFName;
	}
	public void setPatientFName(String patientFName) {
		this.patientFName = patientFName;
	}
	public String getPatientMName() {
		return patientMName;
	}
	public void setPatientMName(String patientMName) {
		this.patientMName = patientMName;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getPatientLName() {
		return patientLName;
	}
	public void setPatientLName(String patientLName) {
		this.patientLName = patientLName;
	}
	
	
}
