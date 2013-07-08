package com.cufe.risduo.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cufe.risduo.dao.ExamDaoImpl;
import com.cufe.risduo.dao.ReservationDaoImpl;
import com.cufe.risduo.model.Exam;
import com.cufe.risduo.model.ExamView;

public class ExamService {
	
	public boolean createExam(Exam exam){
		//getLoggedinUser()
				//getUserRole
				//if role recep.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ExamDaoImpl dao = ctx.getBean("examDaoImpl", ExamDaoImpl.class);
		System.out.println("Creating new Exam");
		int numRows = dao.create(exam);
		////////////////////////////////
		/* Updating Reservation Status to flag starting Exam*/
		ReservationDaoImpl dao1 = ctx.getBean("reservationDaoImpl", ReservationDaoImpl.class);
		int resNumRows = dao1.updateStatus(exam.getExamReservationId(), 2);
		///////////////////////////////
		if (numRows>0){
			System.out.println("Exam Created");
			if(resNumRows>0)
				return true;
			else{
				System.out.println("status not updated");
				return false;
			}
		}
		System.out.println("No Exam added");
		return false;
	}
		public boolean updateExamEnd(Integer examReservationId ,Integer examEndTime, String ExamPatientComplaint){
		//getLoggedinUser()
				//getUserRole
				//if role recep.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ExamDaoImpl dao = ctx.getBean("examDaoImpl", ExamDaoImpl.class);
		
		int numRows = dao.updateExamEnd(examReservationId, examEndTime, ExamPatientComplaint);
		
		////////////////////////////////
		/* Updating Reservation Status to flag starting Exam */
		ReservationDaoImpl dao1 = ctx.getBean("reservationDaoImpl", ReservationDaoImpl.class);
		int resNumRows = dao1.updateStatus(examReservationId, 3);
		///////////////////////////////
		
		if (numRows>0){
			System.out.println("Exam updated");
			if(resNumRows>0)
				return true;
			else{
				System.out.println("status not updated");
				return false;
			}
		}
		System.out.println("Exam Not Updated");
		return false;
	}
	public List<ExamView> listExams( boolean reported){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ExamDaoImpl dao = ctx.getBean("examDaoImpl", ExamDaoImpl.class);
		List<ExamView> exams = dao.listExams(reported);
		return exams;
	}
	public boolean updateExamReport(Integer examId, Integer examReservationId, String ExamReport){
		//getLoggedinUser()
				//getUserRole
				//if role recep.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ExamDaoImpl dao = ctx.getBean("examDaoImpl", ExamDaoImpl.class);
		
		int numRows = dao.updateExamReport(examId, ExamReport);
		
		////////////////////////////////
		/* Updating Reservation Status to flag starting Exam */
		ReservationDaoImpl dao1 = ctx.getBean("reservationDaoImpl", ReservationDaoImpl.class);
		int resNumRows = dao1.updateStatus(examReservationId, 4);
		///////////////////////////////
		
		if (numRows>0){
			System.out.println("Exam updated");
			if(resNumRows>0)
				return true;
			else{
				System.out.println("status not updated");
				return false;
			}
		}
		System.out.println("Exam Not Updated");
		return false;
	}
	
}

/*

public Patient getEventPatient(Integer reservationExamTime,
	Integer reservationRoomId, String patientFName, 
	String patientLName){
//getLoggedinUser()
		//getUserRole
		//if role recep.
ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
PatientDaoImpl dao = ctx.getBean("patientDaoImpl", PatientDaoImpl.class);

Patient patient = dao.getEventPatient(reservationExamTime, reservationRoomId, patientFName, patientLName);

return patient;
}
*/
