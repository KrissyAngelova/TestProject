<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test = "${empty events}">
			<p>No Events to show</p>
	</c:if>
	
	<c:if test = "${not empty events}">
	<table  border="1" width="30%" cellpadding="3">
	<tr>	
		<td colspan = "6">EVENTS</td>
	</tr>
	<tr>
		<td>N</td>
		<td>Name</td>
		<td>Date</td>
		
	</tr>
		<c:forEach items="${events}" var="event" varStatus="myIndex">
			<tr>
				<td> ${myIndex.index+1}</td>
	    		<td> ${event.name}</td>
	    		<td><fmt:formatDate pattern="dd-MM-YYYY" value="${event.date}"/></td>
	    	</tr>
		</c:forEach>
	</table>
	</c:if>
</body>
</html>