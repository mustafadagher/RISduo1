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




<div id="form">
		<s:form id="searchForm" action="/patient/search">
		
			
					<s:textfield id="patientFName" name="patientFName" label="Patient Name" value="First" onfocus="this.value==this.defaultValue?this.value='':null" onblur="if(this.value=='')this.value=this.defaultValue"/>
					<s:textfield id="patientMName" name="patientMName" value="Middle" onfocus="this.value==this.defaultValue?this.value='':null" onblur="if(this.value=='')this.value=this.defaultValue"/>
					<s:textfield id="patientLName" name="patientLName" value="Last" onfocus="this.value==this.defaultValue?this.value='':null" onblur="if(this.value=='')this.value=this.defaultValue"/>
				
				<sj:datepicker label="Birth Date"  id="patientBDate" key="patientBDate" value="Birth Date" onfocus="this.value==this.defaultValue?this.value='':null" onblur="if(this.value=='')this.value=this.defaultValue"
				name="patientBDate" displayFormat="dd/mm/yy" showButtonPanel="true" changeMonth="true" changeYear="true" />
				<s:select 
				       name="patientSex"
				       id="sex"
				       headerKey="null" headerValue="Select Sex"
				       list="#{'Male':'Male', 'Female':'Female'}"
				       value="patientSex"
				       required="true"
				/>
				
				
				<s:textfield label="Address" id="patientAddress" name="patientAddress" value="Patient Address" onfocus="this.value==this.defaultValue?this.value='':null" onblur="if(this.value=='')this.value=this.defaultValue"/>
				<s:textfield label="Telephone" id="patientTelephone" name="patientTelephone" value="Patient Telephone" onfocus="this.value==this.defaultValue?this.value='':null" onblur="if(this.value=='')this.value=this.defaultValue"/>
			
			
			<s:submit value="Search" id="searchbutton"/>
			<s:submit value="Add" action="add" id="addbutton"/>
			
			
		</s:form>
		
</div> <!-- end form -->
	
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
	</div> <!-- end container -->
	<%@ include file="footer.jsp" %>

</body>
</html>