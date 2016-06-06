<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form method="post" action="/Logout">
	<input type="submit" value="Logout" />
	</form>
	
	<p>User: ${userProfile.username}</p>
	
	<c:if test = "${empty userEvents}">
			<p>No Events to show</p>
	</c:if>
	
	<c:if test = "${not empty userEvents}">
	<table  border="1" width="30%" cellpadding="3">
	<tr>	
		<td colspan = "6">EVENTS</td>
	</tr>
	<tr>
		<td>N</td>
		<td>Name</td>
		<td>Desc</td>
	</tr>
		<c:forEach items="${userEvents}" var="event" varStatus="myIndex">
			<tr>
				<td> ${myIndex.index+1}</td>
	    		<td> ${event.name}</td>
	    		<td> ${event.description}</td>
	    		<td>
	    				<form method="get" action="/openEvent/${event.id}">
						<input type="submit" value="Info" />
						</form>
	    	</tr>
		</c:forEach>
	</table>
	</c:if>
</body>
</html>