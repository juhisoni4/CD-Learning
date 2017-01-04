<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload='document.f.j_username.focus();'>
<c:url value="j_spring_security_check" var="loginUrl" />
 <form name='f' action="${loginUrl}"
  method='POST'>
  User:<input type='text' name='j_username' value=''>
  Password:<input type='password' name='j_password' />
  <input name="submit" type="submit"
     value="submit" />
  </form>
</body>
</html>