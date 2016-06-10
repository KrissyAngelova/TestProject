<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="/resources/static/css/mainStyleCss.css">
<link rel="stylesheet" href="/resources/static/css/eventTableStyle.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Event Info Page</title>
</head>
<jsp:include page="navigationBar.jsp" />
<style>table {
  color: #333;
  font-family: sans-serif;
  font-size: .9em;
  font-weight: 300;
  text-align: left;
  line-height: 40px;
  border-spacing: 0;
  border: 2px solid #5c8a8a;
  width: 50%;
  margin: 50px auto;
}
</style>
<body>

 	<h2>${event.name}</h2>
 	<p></p>
 	<p>Date: <fmt:formatDate pattern="yyyy-MM-dd" value="${event.date}"/></p>
 	<p>Description: ${event.description}</p>
 	<c:if test = "${empty wantedGifts}">
			<p>No Gifts  to show</p>
	</c:if>
	
	<c:if test = "${not empty wantedGifts}">
	<table>
	<thead>
    <tr>
      <th colspan="6">GIFTS</th>
    </tr>
   <tr>
      	<td>N</td>
		<td>Name</td>
		<td>Desc</td>
		<td>Taken</td>
		<td>Buyer</td>

    </tr>
  </thead>
		<c:forEach items="${wantedGifts}" var="gift" varStatus="myIndex">
			<tr>
				<td> ${myIndex.index+1}</td>
	    		<td>${gift.name}</td>
	    		<td> ${gift.description}</td>
	    		<c:if test = "${gift.isTaken()}">
	    		<td>Yes</td>
	    		<td><a id = "user" href ="/viewProfile/${gift.buyer.getId()}">${gift.buyer.getUsername()}</a></td>
	    		<c:if test = "${gift.buyer.getUsername() == sessionScope.username}">
	    		<td>
	    				<form method="post" action="/removeGift2/${gift.id}">
						<button type = "submit"> <span class = "glyphicon glyphicon-remove foo"></span></button>
						</form>
 				
				</td>
	    		</c:if>
	    		</c:if>
	    		<c:if test = "${not gift.isTaken()}">
	    		<td> No </td>
	    		<td> - </td>
	    		<td>
	    		<form method="post" action="/takeGift2/${gift.id}">
						<button type = "submit"> <span class = "glyphicon glyphicon-ok foo"></span></button>
						</form>
	    		</td>
	    		</c:if>
				
	    	</tr>
		</c:forEach>
	</table>
	
	</c:if>
	<form method="get" action="/viewProfile/${userProfile.id}" class = "form-style-1">
	<center>
	<input type="submit" value="Back" />
	</center>
	</form>
	<p>${takeErrorMessage}</p>
	<c:set var="takeErrorMessage" value="" scope="session"  />
	<p>${updateErrorMessage}</p>
	<c:set var="takeErrorMessage" value="" scope="session"  />

	
</body>
</html>