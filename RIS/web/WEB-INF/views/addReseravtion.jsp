<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<sj:head />
<title>Patients</title>
<link rel= "stylesheet" href="/RIS/static/css/addpatient-style" >
</head>
<body>
<div class ="container">
<%@ include file="topBar.jsp" %>
<%@ include file="menu.jsp" %>

	<div class="pageblock">
		<s:form id="reservationForm" action="/patient/search">			
			<s:textfield id="patientFName" name="patientFName" label="Patient Name" />
			<s:textfield id="patientMName" name="patientMName" />
			<s:textfield id="patientLName" name="patientLName" />
				
			<sj:datepicker label="Exam time"  id="reservationExamTime" key="reservationExamTime" 
				name="reservationExamTime" displayFormat="dd/mm/yy" changeMonth="true" 
				changeYear="true" yearRange="-1:+1" timepicker="true" timepickerAmPm="true"
				timepickerFormat="hh:mm" />
				<s:select 
					label = "Room"
				       name="reservationRoomId"
				       id="reservationRoomId"
				       headerKey="null" headerValue="Select Room"
				       list="#{'Male':'Male', 'Female':'Female'}"
				       value="reservationRoomId"
				       required="true"
				/>
				
				<s:submit value="Add" action="add" id="addbutton"/>
			</s:form>
		
		</div> <!-- end form -->
	
	
	</div> <!-- end container -->
	<%@ include file="footer.jsp" %>

</body>
</html>