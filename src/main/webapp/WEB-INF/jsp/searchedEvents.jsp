<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="/resources/static/css/eventTableStyle.css">
<link rel="stylesheet" href="/resources/static/css/mainStyleCss.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:include page="navigationBar.jsp" />
<body>

<c:if test = "${empty events}">
			<p>No Events to show</p>
	</c:if>
	
	<c:if test = "${not empty events}">
	<table>
	<center>
	<thead>
    <tr>
      <th colspan="4">Events</th>
    </tr>
  </thead>
  	<tr>
		<td>N</td>
		<td>Name</td>
		<td>Date</td>
		<td>User</td>
		
	</tr>
  
		<c:forEach items="${events}" var="event"  varStatus="myIndex">
			<tr>
			<td> ${myIndex.index+1}</td>
			<td><a id = "event" href ="/openOtherEvent2/${event.id}"> ${event.name}</a></td>
			<td><fmt:formatDate pattern="dd-MM-YYYY" value="${event.date}"/></td>
			<td><a id = "user" href ="/viewProfile/${event.user.getId()}">${event.user.getUsername()}</a></td>
	    	</tr>
		</c:forEach>
		</center>
	</table>
	</c:if>
</body>
</html>