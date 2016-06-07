<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Event Info Page</title>
</head>
<body>
<form method="post" action="/Logout">
	<input type="submit" value="Logout" />
	</form>
 	<h2>${event.name}</h2>
 	<p></p>
 	<p>Date: <fmt:formatDate pattern="yyyy-MM-dd" value="${event.date}"/></p>
 	<p>Description: ${event.description}</p>
 	
 	<c:if test = "${empty wantedGifts}">
			<p>No Gifts to show</p>
	</c:if>
	
	<c:if test = "${not empty wantedGifts}">
	<table  border="1" width="30%" cellpadding="3">
	<tr>	
		<td colspan = "6">GIFTS</td>
	</tr>
	<tr>
		<td>N</td>
		<td>Name</td>
		<td>Desc</td>
		<td>Taken</td>
	</tr>
		<c:forEach items="${wantedGifts}" var="gift" varStatus="myIndex">
			<tr>
				<td> ${myIndex.index+1}</td>
	    		<td> ${gift.name}</td>
	    		<td> ${gift.description}</td>
	    		<c:if test = "${gift.isTaken()}">
	    		<td>${gift.buyer.getUsername()}</td>
	    		<c:if test = "${gift.buyer.getUsername() == sessionScope.username}">
	    		<td><form method="post" action="/removeGift2/${gift.id}">
						<input type="submit" value="remove" />
						</form>
						</td>
				</c:if>
	    		</c:if>
	    		<c:if test = "${not gift.isTaken()}">
	    		<td>
	    				<form method="post" action="/takeGift2/${gift.id}">
						<input type="submit" value="take" />
						</form>
				</td>
				</c:if>	
	    	</tr>
		</c:forEach>
	</table>
	</c:if>
 	<form method="get" action="/searchedEvents">
	<input type="submit" value="Back" />
	</form>
	<p>${takeErrorMessage}</p>
	<c:set var="takeErrorMessage" value="" scope="session"  />
	<p>${updateErrorMessage}</p>
	<c:set var="takeErrorMessage" value="" scope="session"  />
</body>
</html>