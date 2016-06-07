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
<c:if test = "${empty users}">
			<p>No Users to show</p>
	</c:if>
	
	<c:if test = "${not empty users}">
	<table  border="1" width="30%" cellpadding="3">
	<tr>	
		<td colspan = "6">USERS</td>
	</tr>
	<tr>
		<td>N</td>
		<td>Name</td>
		
	</tr>
		<c:forEach items="${users}" var="user" varStatus="myIndex">
			<tr>
				<td> ${myIndex.index+1}</td>
	    		<td> ${user.username}</td>
	    		<td><form method="get" action="/viewProfile/${user.id}">
						<input type="submit" value="view profile" />
						</form>
						</td>
	    	</tr>
		</c:forEach>
	</table>
	</c:if>
	<form method="get" action="/loggedUserPage">
		<input type="submit" value="Back" />
		</form>
</body>
</html>