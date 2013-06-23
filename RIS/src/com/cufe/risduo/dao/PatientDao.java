package com.cufe.risduo.dao;

import java.util.List;
import javax.sql.DataSource;

import com.cufe.risduo.model.Patient;

public interface PatientDao {
   /** 
    * This is the method to be used to initialize
    * database resources ie. connection.
    */
   public void setDataSource(DataSource ds);
   /** 
    * This is the method to be used to create
    * a record in the patient table.
    */
   public int create(String patientFName, String patientMName,
			String patientLName, String patientSex, String patientBDate,
			String patientAddress, int patientTelephone);
   /** 
    * This is the method to be used to list down
    * a record from the patient table corresponding
    * to a passed patient id.
    */
   public Patient getPatient(String patientFName);
   /** 
    * This is the method to be used to list down
    * all the records from the patient table.
    */
   public List<Patient> listPatients(String condition);
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
   
   void update(String patientFName, String patientMName,
			String patientLName, String patientSex, String patientBDate,
			String patientAddress, int patientTelephone);
}

