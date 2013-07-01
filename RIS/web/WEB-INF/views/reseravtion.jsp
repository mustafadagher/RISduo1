<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<sj:head jqueryui="true" />
<title>Reservation</title>
<link rel= "stylesheet" href="/RIS/static/css/addpatient-style" >
<script>
function update(){
	  var url="/RIS/reservation/update";
	  var res = $.ajax({
          url: resUrl,
          async: false,
          dataType: 'script'
      }).responseText;
  	res= eval(res);
  	if(res=="true"){
  		alert("Reservation Updated Successfully!");
  	}
	}
</script>
</head>
<body>
<div class ="container">
<%@ include file="topBar.jsp" %>
<%@ include file="menu.jsp" %>
	<div class= "maincontent">
	<div class="pageblock">
		<s:form id="reservationForm" action="/reservation/cancel">			
			<s:textfield id="patientFName" name="patientFName" label="Patient Name" />
			<s:textfield id="patientMName" name="patientMName" />
			<s:textfield id="patientLName" name="patientLName" />
			<s:textfield id="patientNID" name="patientNID" cssClass="normalTextBox" label="National ID " />	
			<sj:datepicker label="Exam time"  cssClass="normalTextBox" id="reservationExamTime" key="reservationExamTime" 
				name="reservationExamTime" displayFormat="dd/mm/yy" changeMonth="true" 
				changeYear="true" yearRange="-1:+1" timepicker="true" timepickerAmPm="true"
				timepickerFormat="hh:mm" />
			
			<s:select 
					label = "Room"
					cssClass="normalTextBox"
				       name="reservationRoomId"
				       id="reservationRoomId"
				       headerKey="null" headerValue="Select Room"
				       list="#{'1':'Room1', '2':'Room 2', '3':'Room 3'}"
				       value="reservationRoomId"
				       required="true"
				/>
				
				<s:textfield id="reservationReferringPhysician" cssClass="normalTextBox" name="reservationReferringPhysician" label="Referring Physician" />
				
				<s:select 
					label = "Billing Type"
					cssClass="normalTextBox"
				       name="reservationBillingType"
				       id="reservationBillingType"
				       headerKey="null" headerValue="Select Billing Type"
				       list="#{'cash':'Cash', 'creditCard':'Credit Card', 'insurance':'Insurance'}"
				       value="reservationBillingType"
				       required="true"
				/>
				<s:textfield id="reservationBillingData" cssClass="normalTextBox" name="reservationBillingData" label="Billing Data" />
				<s:submit value="Job Order" action="order" id="JobOrderbutton" cssClass="normalButton" /> 
				<%-- <sj:submit value="Save" action="update" cssClass="normalButton" id="savebutton" targets="formResult" openDialog="resultDialog"/> --%>
				 <sj:submit value="Cancel" action="cancel" cssClass="normalButton" id="cancelbutton" targets="cancelResult" openDialog="cancelDialog"/>
				
			</s:form>
		
		</div> <!-- end pageblock -->
		</div> <!-- end maincontent -->
	<sj:dialog id="resultDialog" autoOpen="false" ><div id="formResult"></div></sj:dialog>
	<sj:dialog id="cancelDialog" autoOpen="false" ><div id="cancelResult"></div></sj:dialog>
	</div> <!-- end container -->
	<%@ include file="footer.jsp" %>

</body>
</html>