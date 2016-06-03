<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Event Info Page</title>
</head>
<body>
 	<h2>${event.name}</h2>
 	<p></p>
 	<p>Date: <fmt:formatDate pattern="yyyy-MM-dd" value="${event.date}"/></p>
 	<p>Description: ${event.description}</p>
 	<form method="get" action="/loggedUserPage">
	<input type="submit" value="Back" />
	</form>
</body>
</html>