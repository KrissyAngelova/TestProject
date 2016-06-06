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
		<td>Buyer</td>
	</tr>
		<c:forEach items="${wantedGifts}" var="gift" varStatus="myIndex">
			<tr>
				<td> ${myIndex.index+1}</td>
	    		<td> ${gift.name}</td>
	    		<td> ${gift.description}</td>
	    		<c:if test = "${gift.isTaken()}">
	    		<td>Yes</td>
	    		<td>${gift.buyer.getUsername()}</td>
	    		</c:if>
	    		<c:if test = "${not gift.isTaken()}">
	    		<td>No</td>
	    		<td>-</td>
	    		</c:if>
	    		<td>
	    				<form method="GET" action="/openUpdateGiftPage/${gift.id}">
						<input type="submit" value="update" />
						</form>
				</td>
	    		
	    		<td>
	    				<form method="post" action="/deleteGift/${gift.id}">
						<input type="submit" value="delete" />
						</form>
				</td>
	    	</tr>
		</c:forEach>
	</table>
	</c:if>
	<form method="put" action="/addGiftPage">
		<input type="submit" value="Add gift" />
		</form>
 	<form method="get" action="/loggedUserPage">
	<input type="submit" value="Back" />
	</form>
	<p>${deleteErrorMessage}</p>
	<c:set var="deleteErrorMessage" value="" scope="session"  />
	<p>${updateErrorMessage}</p>
	<c:set var="deleteErrorMessage" value="" scope="session"  />
</body>
</html>