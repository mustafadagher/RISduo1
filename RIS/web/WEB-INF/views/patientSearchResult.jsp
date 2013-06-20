<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patients</title>
</head>
<body>
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
</body>
</html>