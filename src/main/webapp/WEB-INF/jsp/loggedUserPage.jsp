<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>loggedUserPage</title>
<link rel="stylesheet" href="/resources/static/css/mainStyleCss.css">
<link rel="stylesheet" href="/resources/static/css/eventTableStyle.css">
</head>
<jsp:include page="navigationBar.jsp" />
<body>
   <form method="get" action="/createEvent">
	<input id = "createButton" type="submit" value="New Event" />
	</form>
	</br>
	</br>
<c:if test = "${empty myEvents}">
			<p>No Events to show</p>
	</c:if>
	
	<c:if test = "${not empty myEvents}">
	<table>
	<thead>
    <tr>
      <th colspan="4">MY EVENTS</th>
    </tr>
   <tr>
      <th>#</th>
      <th colspan="3">Event's name</th>
    </tr>
  </thead>
		<c:forEach items="${myEvents}" var="event" varStatus="myIndex">
			<tr>
				<td> ${myIndex.index+1}</td>
	    		<td><a id = "event" href ="/openEvent/${event.id}">${event.name}</a></td>
	    		
				<td>
				
	    				<form method="GET" action="/openUpdateEventPage/${event.id}">
	    				<button type = "submit"> <span class="glyphicon glyphicon-pencil  foo"></span></button>	
						</form>
				</td>
				<td>
	    				<form method="post" action="/deleteEvent/${event.id}">
						<button type = "submit"> <span class = "glyphicon glyphicon-trash foo"></span></button>
						</form>
 				
				</td>
	    	</tr>
		</c:forEach>
	</table>
	</c:if>
</body>
</html>