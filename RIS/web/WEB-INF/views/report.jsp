<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<sj:head />
<title>Report</title>
<link rel= "stylesheet" href="/RIS/static/css/addpatient-style" >
</head>
<body>
	<div class ="container">
		<%@ include file="topBar.jsp" %>
		<%@ include file="menu.jsp" %>
		<div class="pageblock">
			<div class="blockContent">
				<s:form id="reportForm" action="/exam/createReport">			
					<s:textarea name="examReport" id="examReport" />
					<s:submit value="Save Report" cssClass="normalButton" id="saveReportbutton"/>
			</s:form>
		
			 </div>
		</div>
	</div> <!-- end container -->
<%@ include file="footer.jsp" %>
<ckeditor:replace replace="examReport" basePath="/RIS/ckeditor/" />
</body>
</html>