<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>loggedUserPage</title>
</head>
<body>
    <form method="post" action="/Logout">
	<input type="submit" value="Logout" />
	</form>
	<p>Welcome, ${username}</p>

	<form method="post" action="/Search">
	<h2> Search </h2>
	<input type="text" name="name" value="" required/>
	<select name = "choice">
  	<option value="user">User</option>
  	<option value="event">Event</option>
	</select>
	<input type="submit" value="Search" />
	</form>
	
	</p>
	
	<c:if test = "${empty myEvents}">
			<p>No Events to show</p>
	</c:if>
	
	<c:if test = "${not empty myEvents}">
	<table  border="1" width="30%" cellpadding="3">
	<tr>	
		<td colspan = "6">MY EVENTS</td>
	</tr>
	<tr>
		<td>N</td>
		<td>Name</td>
		<td>Desc</td>
	</tr>
		<c:forEach items="${myEvents}" var="event" varStatus="myIndex">
			<tr>
				<td> ${myIndex.index+1}</td>
	    		<td> ${event.name}</td>
	    		<td> ${event.description}</td>
	    		<td>
	    				<form method="get" action="/openEvent/${event.id}">
						<input type="submit" value="Info" />
						</form>
				</td>
				<td>
	    				<form method="GET" action="/openUpdateEventPage/${event.id}">
						<input type="submit" value="update" />
						</form>
				</td>
				<td>
	    				<form method="post" action="/deleteEvent/${event.id}">
						<input type="submit" value="delete" />
						</form>
				</td>
	    	</tr>
		</c:forEach>
	</table>
	</c:if>
	<p></p>
	<form method="get" action="/createEvent">
	<input type="submit" value="New Event" />
	</form>
</body>
</html>