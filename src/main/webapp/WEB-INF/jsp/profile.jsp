<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="/resources/static/css/mainStyleCss.css">
<link rel="stylesheet" href="/resources/static/css/eventTableStyle.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:include page="navigationBar.jsp" />
<body>
	<p>User: ${userProfile.username}</p>
	
	<c:if test = "${empty userEvents}">
			<p>No Events to show</p>
	</c:if>
	
	<c:if test = "${not empty userEvents}">
	<table>
	<thead>
    <tr>
      <th colspan="4">EVENTS</th>
    </tr>
  </thead>
		<c:forEach items="${userEvents}" var="event" varStatus="myIndex">
			<tr>
				<td> ${myIndex.index+1}</td>
	    		<td><a id = "event" href ="/openOtherEvent2/${event.id}">${event.name}</a></td>
	    		
			
	    	</tr>
		</c:forEach>
	</table>
	</c:if>
		<form method="get" action="/searchedUsers">
		<input type="submit" value="Back" />
		</form>
	
</body>
</html>