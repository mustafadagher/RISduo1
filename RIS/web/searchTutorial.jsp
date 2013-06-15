<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Tutorial</title>
</head>
<body>
	<s:form action="tutorials/getTutorial">
		<s:textfield label="Enter a language" key="language"/>
		<s:submit />
	
	</s:form>
	
	<!--  <form method="POST" action="tutorials/getTutorial.action">
		<input name="language" id="language"/>
		<input type="submit"/>
	</form>  -->
</body>
</html>