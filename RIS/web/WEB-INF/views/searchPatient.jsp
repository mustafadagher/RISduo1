<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<sj:head />
<title>Search Patient</title>
</head>
<body>
	
	<div id="main" >
		<s:form action="/patient/search">
			<s:textfield label="First Name" key="patientFName"/>
			<s:textfield label="Middle Name" key="patientMName"/>
			<s:textfield label="Last Name" key="patientLName"/>
			<s:select label="Sex"
			       name="patientSex"
			       headerKey="null" headerValue="Select Sex"
			       list="#{'Male':'Male', 'Female':'Female'}"
			       value="patientSex"
			       key="patientSex"
			       required="true"
			/>
			<sj:datepicker label="Birth Date"  id="patientBDate" key="patientBDate" 
			name="patientBDate" displayFormat="dd.mm.yy" showButtonPanel="true" changeMonth="true" changeYear="true" />
			<s:textfield label="Address" key="patientAddress"/>
			<s:textfield label="Telephone" key="patientTelephone"/>	
			<sj:submit value="search" targets="result"/>
			
		</s:form>
	</div>
	
	<div id="result">
		<table>
			<tr> 
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
	
</body>
</html>