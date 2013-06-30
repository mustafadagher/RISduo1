<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<sj:head />
<title>Job Order</title>
<link rel= "stylesheet" href="/RIS/static/css/addpatient-style" >
</head>
<body>
<div class ="container">
	<%@ include file="topBar.jsp" %>
	<%@ include file="menu.jsp" %>
	<div class="pageblock">
	<div class="blockContent">
	<div>Name: <s:property value="patientFName" /> <s:property value="patientMName" /> <s:property value="patientLName" /></div>
	<div><span>patient ID: <s:property value="patientId" /></span> <span> Patient NID: <s:property value="patientNID" /></span></div>
	<div>Room: <s:property value="reservationRoomId" />  Referring Physician: <s:property value="reservationReferringPhysician" /></div>
	<div>Attendance Time: <s:property value="reservationAttendanceTime" /> ExamTime: <s:property value="reservationExamTime" /></div>
	<div>Billing Type:<s:property value="reservationBillingType" /> Billing Info: <s:property value="reservationBillingData" /></div>
	<div>
	Complain:
	</div>
	 </div>
	</div>
</div> <!-- end container -->
<%@ include file="footer.jsp" %>

</body>
</html>