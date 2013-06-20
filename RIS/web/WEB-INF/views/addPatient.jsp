<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<sj:head />
<title>Add Patient</title>
</head>
<body>
	<s:form action="/patient/add">
		<s:textfield label="First Name" key="patientFName"/>
		<s:textfield label="Middle Name" key="patientMName"/>
		<s:textfield label="Last Name" key="patientLName"/>
		<s:select label="Sex"
		       name="patientSex"
		       headerKey="-1" headerValue="Select Sex"
		       list="#{'Male':'Male', 'Female':'Female'}"
		       value="patientSex"
		       key="patientSex"
		       required="true"
		/>
		<sj:datepicker label="Birth Date"  value="today" id="patientBDate" key="patientBDate" 
		name="patientBDate" displayFormat="dd.mm.yy" showButtonPanel="true" changeMonth="true" changeYear="true" />
		<s:textfield label="Address" key="patientAddress"/>
		<s:textfield label="Telephone" key="patientTelephone"/>	
		<s:submit value="Save"/>
	</s:form>
</body>
</html>