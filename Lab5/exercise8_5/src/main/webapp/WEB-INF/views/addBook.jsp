<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Book</title>
</head>
<body>
	<form:form modelAttribute="book" action="books" method="post" >
		<table>
			<tr>
				<td>Title:</td>
				<td><form:input type="text" path="title" /> <form:errors path="title" /></td>
			</tr>
			<tr>
				<td>ISBN:</td>
				<td><form:input type="text" path="ISBN" /><form:errors path="ISBN" /></td>
			</tr>
			<tr>
				<td>Author:</td>
				<td><form:input type="text" path="author" /> <form:errors path="author" /></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><form:input type="number" path="price" /><form:errors path="price" /></td>
			</tr>
		</table>
		<input type="submit" />
	</form:form>
</body>
</html>