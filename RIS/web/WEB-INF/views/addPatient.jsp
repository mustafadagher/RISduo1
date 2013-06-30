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
<link rel= "stylesheet" href="/RIS/static/css/addpatient-style" >
</head>
<body>
<div id ="container">
<div id="top-bar">
		<h1>RIS duo</h1>
		<h2><a href="#">logout</a></h2>
		<h3>username</h3>
</div><!-- end top-bar -->

<div id="nav-bar">
		<ul>
			<li id="Active"><a href="#"><img src ="/RIS/static/image/patients"/><br>Patients</a></li>
			<li><a href="#"><img src ="/RIS/static/image/schedule"/><br>Schedule</a></li>
			<li><a href="#"><img src ="/RIS/static/image/procedures"/><br>Procedures</a></li>
			<li><a href="#"><img src ="/RIS/static/image/reports"/><br>Reports</a></li>
			<li><a href="#"><img src ="/RIS/static/image/statistics"/><br>Statistics</a></li>
			<li><a href="#"><img src ="/RIS/static/image/settings"/><br>Settings</a></li>
			
		</ul>
</div>

<div id="form">
	<div id="inform">
	<s:form action="/patient/add">
	<p>Patient Name</p>
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
		<div id="font2">Birth Date</div>
		<sj:datepicker label="Birth Date"  value="today" id="patientBDate" key="patientBDate" 
		name="patientBDate" displayFormat="dd.mm.yy" showButtonPanel="true" changeMonth="true" changeYear="true" />
		<s:textfield label="Address" key="patientAddress"/>
		<s:textfield label="Telephone" key="patientTelephone"/>	
		<s:submit value="Save"/>
	</s:form>
</div> <!-- end inform -->
</div> <!-- end form -->
	
</div> <!-- end container -->
<div id="footer"><p>Copyrights(c)2012-2013 RISduo team</p>
</div> <!-- end footer -->
</body>
</html>