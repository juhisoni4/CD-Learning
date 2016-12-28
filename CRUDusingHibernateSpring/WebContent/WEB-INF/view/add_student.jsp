<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
<form:form action="addStudent" modelAttribute="student">
	<c:if test = "${student.id != 0}"> 
	<input type="hidden" name="id" value="${student.id}"/> 
	</c:if>
	First Name:<input type="text" name="firstName" value="${student.firstName}"/><br>
	Last Name:<input type="text" name="lastName" value="${student.lastName}"/><br>
	Email:<input type="text" name="email" value="${student.email}"/><br>
	<input type="submit" value="submit">
	</form:form>
</body>
</html>