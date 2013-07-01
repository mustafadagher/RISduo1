<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel= "stylesheet" href="/RIS/static/css/login-style" >
</head>
<body>
<div class="container">

<div id="header">
		<h1>RIS duo</h1>
		<h2>RIS</h2>
</div><!-- end header -->

	<div id ="login-form">
		<s:form action="login" name="loginForm">
			<s:textfield style="color:#696969" id="username" name="userName" placeholder="%{getText('user name')}"/>
			<s:password style="color:#696969" id="password" name="password" placeholder="%{getText('password')}"/>
			<s:submit id="button" value="login" type="image" src="/RIS/static/image/button"/>
		</s:form>
	</div> 
	
</div> <!-- end container -->

<div id="footer"><p>Copyrights(c)2012-2013 RISduo team</p>
</div> <!-- end footer -->
</body>
</html>