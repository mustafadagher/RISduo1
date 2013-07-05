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
<link rel= "stylesheet" href="/RIS/static/css/tablestyle" >
<script type='text/javascript' src='/RIS/static/js/cookie'></script>
<script type="text/javascript">

function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode;
   if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57))
      return false;

   return true;
}
$('#nav-bar ul li a').click(function()
		{

		  $('#nav-bar ul li a.selected').addClass('link');
		   $('#nav-bar ul li a.selected').removeClass('selected');
		   $(this).removeClass('link');
		   $(this).addClass('selected');

		});
function AllowAlphabet(evt)
{
	evt = (evt) ? evt : event;
    var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode :
((evt.which) ? evt.which : 0));
    if ((charCode > 31) && ((charCode < 65) || (charCode > 90)) &&((charCode < 97) || (charCode > 122)))
        return false;
    else
        return true;
}

</script>
</head>
<body>
<div class ="container">
<%@ include file="topBar.jsp" %>
<%@ include file="menu.jsp" %>
	<div class= "maincontent">
			<div class="pageblock">
			<s:form id="searchForm" action="/patient/search">			
					<s:textfield id="patientFName" name="patientFName" label="Patient Name" placeholder="%{getText('First')}" onkeypress="return AllowAlphabet(event)" />
					<s:textfield id="patientMName" name="patientMName" placeholder="%{getText('Middle')}" onkeypress="return AllowAlphabet(event)"/>
					<s:textfield id="patientLName" name="patientLName" placeholder="%{getText('Last')}" onkeypress="return AllowAlphabet(event)"  />
					
				<s:textfield label="Address" id="patientAddress" name="patientAddress" placeholder="%{getText('Patient Address')}"  />
				<s:textfield label="Telephone" id="patientTelephone" name="patientTelephone" placeholder="%{getText('Patient Telephone')}" onkeypress="return isNumberKey(event)"/>	
				
				<sj:datepicker label="Birth Date"  id="patientBDate" key="patientBDate" placeholder="%{getText('Birth Date')}" 
				name="patientBDate" displayFormat="dd/mm/yy" changeMonth="true" changeYear="true" yearRange="-90:+00" />
				
				
				<s:select cssClass="selectBox"
				       name="patientSex"
				       label="Sex" headerValue="Gender"
				       headerKey="null" id="sex"
				       list="#{'Male':'Male', 'Female':'Female'}"
				       value="patientSex"
				       required="true"
				/>
				<sj:submit value="Search" id="searchbutton" targets="result" />
				<s:submit value="Create New Patient" action="add" id="addbutton"/>
			
			</s:form>
		
		</div> <!-- end form -->
	
	<div class="pageblock" >
	<div id="result" >
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
		  
   		</table>
   		</div> <!-- end table-format -->
	</div>
	</div> <!-- end pageblock -->
	</div>
	</div> <!-- end container -->
	<%@ include file="footer.jsp" %>

</body>
</html>