<%@ taglib prefix="s" uri="/struts-tags" %>
<head>
<script type='text/javascript' src='/RIS/static/js/cookie'></script>

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
