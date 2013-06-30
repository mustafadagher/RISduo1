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
<script type='text/javascript' src='/RIS/static/js/cookie'></script>
</head>
<body>
<div class ="container">
<%@ include file="topBar.jsp" %>
<%@ include file="menu.jsp" %>




			<div class="pageblock">
				<s:form id="searchForm" action="/patient/search">			
					<s:textfield id="patientFName" name="patientFName" label="Patient Name" />
					<s:textfield id="patientMName" name="patientMName" />
					<s:textfield id="patientLName" name="patientLName" />
				
				<sj:datepicker label="Birth Date"  id="patientBDate" key="patientBDate" 
				name="patientBDate" displayFormat="dd/mm/yy" changeMonth="true" changeYear="true" yearRange="-90:+00" />
				<s:select 
				       name="patientSex"
				       id="sex"
				       headerKey="null" headerValue="Select Sex"
				       list="#{'Male':'Male', 'Female':'Female'}"
				       value="patientSex"
				       required="true"
				/>
				
				
				<s:textfield label="Address" id="patientAddress" name="patientAddress" />
				<s:textfield label="Telephone" id="patientTelephone" name="patientTelephone" />
			
			
				<sj:submit value="Search" id="searchbutton" targets="result"/>
				<s:submit value="Add" action="add" id="addbutton"/>
			
			
			</s:form>
		
		</div> <!-- end form -->
	
	<div class="pageblock" >
	<div id="result">
		<table>
			<tr> 
				<th></th>
				<th>First Name </th>
				<th>Middle Name </th>
				<th>Last Name </th>
				<th>Sex</th>
				<th>Birth Date</th>
				<th>Address</th>
				<th>Telephone</th> 
			</tr>
		   <s:iterator value="%{patients}" var="patient">
		      <tr>
		      	<td><s:a href="/RIS/schedule/view" onclick="$.cookie('patientId', '%{PatientId}');
		      	$.cookie('patientName', '%{PatientFName}+' '+%{PatientLName}'); ">
		      	Reserve</s:a> </td>	
		         <td><s:property value="%{PatientFName}"/></td>
		         <td><s:property value="%{PatientMName}"/></td>
		         <td><s:property value="%{PatientLName}"/></td>
		         <td><s:property value="%{PatientSex}"/></td>
		         <td><s:property value="%{PatientBDate}"/></td>
		         <td><s:property value="%{PatientAddress}"/></td>
		         <td><s:property value="%{PatientTelephone}"/></td>
		      </tr>
		   </s:iterator>
   		</table>
	</div>
	</div>
	</div> <!-- end container -->
	<%@ include file="footer.jsp" %>

</body>
</html>