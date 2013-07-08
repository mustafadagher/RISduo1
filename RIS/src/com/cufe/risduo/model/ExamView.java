package com.cufe.risduo.model;

public class ExamView {
	private Integer patientId;
	private Integer r_Id;
	private Integer roomId;
	private Integer examId;
	
	private String patientFName;
	private String patientMName;
	private String patientLName;

	private String roomName;
	
	private Integer examStartTime;
	private Integer examEndTime;
	private String examReport;
	private String examPatientComplaint;
	
	private Integer reservationPatientStatus;
	
	
	public Integer getR_Id() {
		return r_Id;
	}
	public void setR_Id(Integer r_Id) {
		this.r_Id = r_Id;
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
	
	
	public Integer getExamId() {
		return examId;
	}
	public void setExamId(Integer examId) {
		this.examId = examId;
	}
	public Integer getExamStartTime() {
		return examStartTime;
	}
	public void setExamStartTime(Integer examStartTime) {
		this.examStartTime = examStartTime;
	}
	public Integer getExamEndTime() {
		return examEndTime;
	}
	public void setExamEndTime(Integer examEndTime) {
		this.examEndTime = examEndTime;
	}
	public String getExamReport() {
		return examReport;
	}
	public void setExamReport(String examReport) {
		this.examReport = examReport;
	}
	public String getExamPatientComplaint() {
		return examPatientComplaint;
	}
	public void setExamPatientComplaint(String examPatientComplaint) {
		this.examPatientComplaint = examPatientComplaint;
	}
}
