package com.cufe.risduo.dao;

import java.util.List;
import javax.sql.DataSource;

import com.cufe.risduo.model.Exam;



public interface ExamDao {
   /** 
    * This is the method to be used to initialize
    * database resources ie. connection.
    */
   public void setDataSource(DataSource ds);
   /** 
    * This is the method to be used to create
    * a record in the patient table.
    */
   public int create(Exam exam);
   /** 
    * This is the method to be used to list down
    * a record from the patient table corresponding
    * to a passed patient id.
    */
   public Exam getExam(Integer examId);
   
   /** 
    * This is the method to be used to list down
    * all the records from the patient table.
    */
   public List<Exam> listExams();
   /** 
    * This is the method to be used to delete
    * a record from the patient table corresponding
    * to a passed patient id.
    */
   
   public void delete();
   /** 
    * This is the method to be used to update
    * a record into the patient table.
    */
   
   public int update(Exam exam);
   
   public int updateExamEnd(Integer examReservationId, Integer examEndTime, String ExamPatientComplaint);
}


