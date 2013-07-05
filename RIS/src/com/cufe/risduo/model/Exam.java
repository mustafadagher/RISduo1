package com.cufe.risduo.model;

public class Exam {
	
	 private Integer examId;
	 private Integer examStartTime;
	 private Integer examEndTime;
	 private String examReport;
	 private String examPatientComplaint;
	 private Integer examPatientId;
	 private Integer examReservationId;
	 private Integer examRoomId;
	 private String examCreator;
	 
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
	public Integer getExamPatientId() {
		return examPatientId;
	}
	public void setExamPatientId(Integer examPatientId) {
		this.examPatientId = examPatientId;
	}
	public Integer getExamReservationId() {
		return examReservationId;
	}
	public void setExamReservationId(Integer examReservationId) {
		this.examReservationId = examReservationId;
	}
	public Integer getExamRoomId() {
		return examRoomId;
	}
	public void setExamRoomId(Integer examRoomId) {
		this.examRoomId = examRoomId;
	}
	public String getExamCreator() {
		return examCreator;
	}
	public void setExamCreator(String examCreator) {
		this.examCreator = examCreator;
	}

}
