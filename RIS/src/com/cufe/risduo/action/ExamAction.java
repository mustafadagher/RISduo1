package com.cufe.risduo.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.cufe.risduo.model.Exam;
import com.cufe.risduo.model.ExamView;

import com.cufe.risduo.service.ExamService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ExamAction extends ActionSupport implements ModelDriven<Exam>, ServletResponseAware, ServletRequestAware{
	
	protected HttpServletResponse servletResponse;
	protected HttpServletRequest servletRequest;
	
	public static final boolean REPORTED = true;
	
	private Exam exam =  new Exam();
	private List<ExamView> exams = new ArrayList<ExamView>();
	 
	
	public void validate (){
	}
	
	public String execute() {
		return SUCCESS;
	}
	

	public String startExam(){
		
		Integer currentTimeStamp= (int) (System.currentTimeMillis()/1000);
		
		getExam().setExamStartTime(currentTimeStamp);
		
		Cookie erid = new Cookie("examReservationId", String.format("%d",getExam().getExamReservationId()));
		erid.setPath("/");
		servletResponse.addCookie(erid);
		
		ExamService examService= new ExamService();
		if (examService.createExam(getExam()))
			return SUCCESS;
		return ERROR;
		
		
	}
	
	public String endExam(){
		
		Integer currentTimeStamp= (int) (System.currentTimeMillis()/1000);
		
		Integer examReservationId = null;
		// Load from cookie
		 for(Cookie c : servletRequest.getCookies()) {
		   if (c.getName().equals("examReservationId")){
			   examReservationId = Integer.parseInt(c.getValue());
			   //clearing cookies after assigning them to variables
			   c.setMaxAge(0);
			   c.setValue("");
			   servletResponse.addCookie(c);
		   }
		 }
		getExam().setExamReservationId(examReservationId);
		getExam().setExamEndTime(currentTimeStamp);
		System.out.println("Exam ID: "+getExam().getExamId()+"\nEnd Time:"+ getExam().getExamEndTime()+"\nComplaint:"+getExam().getExamPatientComplaint()+"\nRes. ID:"+getExam().getExamReservationId());
		ExamService examService= new ExamService();
		if (examService.updateExamEnd(getExam().getExamReservationId(), getExam().getExamEndTime(), getExam().getExamPatientComplaint()))
			return SUCCESS;
		return ERROR;
		
		
	}
	
	public String listExams(){
		
		ExamService examService = new ExamService();
		setExams(examService.listExams(!REPORTED));
		return INPUT;
	}
	
	public String report(){
		System.out.println("opening reporting for examID:"+getExam().getExamId()+" ResID:"+getExam().getExamReservationId());
		
		Cookie eid = new Cookie("examId", String.format("%d",getExam().getExamId()));
		eid.setPath("/");
		servletResponse.addCookie(eid);
		
		Cookie eRId = new Cookie("reportReservationId", String.format("%d",getExam().getExamReservationId()));
		eRId.setPath("/");
		servletResponse.addCookie(eRId);
		
		return SUCCESS;
	}
	
	public String createReport(){
		
		Integer examReservationId = null;
		Integer examId = null;
		// Load from cookie
		 for(Cookie c : servletRequest.getCookies()) {
		   if (c.getName().equals("reportReservationId")){
			   examReservationId = Integer.parseInt(c.getValue());
			   //clearing cookies after assigning them to variables
			   c.setMaxAge(0);
			   c.setValue("");
			   servletResponse.addCookie(c);
		   }
		   if (c.getName().equals("examId")){
			   examId = Integer.parseInt(c.getValue());
			   //clearing cookies after assigning them to variables
			   c.setMaxAge(0);
			   c.setValue("");
			   servletResponse.addCookie(c);
		   }
		 }
		 getExam().setExamReservationId(examReservationId);
		 getExam().setExamId(examId);
		 System.out.println("Creating report for Exam:"+ getExam().getExamId()+" Res:"+ getExam().getExamReservationId()+"with report:"+getExam().getExamReport());
		 ExamService examService= new ExamService();
			if (examService.updateExamReport(getExam().getExamId(),getExam().getExamReservationId(), getExam().getExamReport()))
				return SUCCESS;
			return ERROR;
	}
	
	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
	
	public List<ExamView> getExams() {
		return exams;
	}

	public void setExams(List<ExamView> exams) {
		this.exams = exams;
	}

	@Override
	public Exam getModel() {
		
		return exam;
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
