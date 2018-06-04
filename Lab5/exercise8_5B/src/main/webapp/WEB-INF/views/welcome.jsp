<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="welcome.welcome"/></title>
</head>
<body>
	<h1><spring:message code="welcome.welcome"/></h1>
	
	<p><spring:message code="welcome.please_selelect_one"/></p>
	<a href="books"><spring:message code="welcome.books"/></a> 
	<a href="cars"><spring:message code="welcome.cars"/></a> 
	
</body>
</html>