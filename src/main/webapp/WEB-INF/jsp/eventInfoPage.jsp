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
      <th colspan="7">GIFTS</th>
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
	    		<td>${gift.buyer.getUsername()}</td>
	    		</c:if>
	    		<c:if test = "${not gift.isTaken()}">
	    		<td>No</td>
	    		<td>-</td>
	    		</c:if>
	    		<td>
	    				<form method="GET" action="/openUpdateGiftPage/${gift.id}">
	    				<button type = "submit"> <span class="glyphicon glyphicon-pencil  foo"></span></button>	
						</form>
				</td>
				<td>
	    				<form method="post" action="/deleteGift/${gift.id}">
						<button type = "submit"> <span class = "glyphicon glyphicon-trash foo"></span></button>
						</form>
 				
				</td>
	    	</tr>
		</c:forEach>
	</table>
	
	</c:if>
	<form method="put" action="/addGiftPage"class="form-style-1">
       <center>
			<input type="submit" value="Add gift" />
	   </center>
       </form>
	<p>${deleteErrorMessage}</p>
	<c:set var="deleteErrorMessage" value="" scope="session"  />
	<p>${updateErrorMessage}</p>
	<c:set var="deleteErrorMessage" value="" scope="session"  />
		<form method="get" action="/loggedUserPage" class = "form-style-1">
         <center>
		<input type="submit" value="Back" />
		</center>
		</form>
	
</body>
</html>