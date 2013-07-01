<%@ taglib prefix="s" uri="/struts-tags" %>
<head>
<script type='text/javascript' src='/RIS/static/js/cookie'></script>
<<<<<<< HEAD

</head>
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
      	<td><s:a href="/RIS/schedule/view" onclick="$.cookie('patientId', '%{patientId}', {path: '/' });
      	$.cookie('patientFName', '%{PatientFName}', {path: '/' }); 
      	$.cookie('patientLName', '%{PatientLName}', {path: '/' });">
      	Reserve</s:a> </td>	
=======
<link rel= "stylesheet" href="/RIS/static/css/tablestyle" >

</head>
<div class="Table-format" >
<table>
	<tr> 
		
		<td>First Name </td>
		<td>Middle Name </td>
		<td>Last Name </td>
		<td>Sex</td>
		<td>Birth Date</td>
		<td>Address</td>
		<td>Telephone</td> 
		<td></td>
	</tr>
   <s:iterator value="%{patients}" var="patient">
      <tr>
      	
>>>>>>> 2157d334380bcea7e2b98ef6d842c314617ceef7
         <td><s:property value="%{PatientFName}"/></td>
         <td><s:property value="%{PatientMName}"/></td>
         <td><s:property value="%{PatientLName}"/></td>
         <td><s:property value="%{PatientSex}"/></td>
         <td><s:property value="%{PatientBDate}"/></td>
         <td><s:property value="%{PatientAddress}"/></td>
         <td><s:property value="%{PatientTelephone}"/></td>
<<<<<<< HEAD
      </tr>
   </s:iterator>
</table>
=======
         <td><s:a href="/RIS/schedule/view" onclick="$.cookie('patientId', '%{patientId}', {path: '/' });
      	$.cookie('patientFName', '%{PatientFName}', {path: '/' }); 
      	$.cookie('patientLName', '%{PatientLName}', {path: '/' });">
      	Reserve</s:a> </td>	
      </tr>
   </s:iterator>
</table>
</div> <!-- end table-format -->
>>>>>>> 2157d334380bcea7e2b98ef6d842c314617ceef7
