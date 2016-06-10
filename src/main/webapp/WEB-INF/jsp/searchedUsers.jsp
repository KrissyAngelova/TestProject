<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
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

<c:if test = "${empty users}">
			<p>No Users to show</p>
	</c:if>
	
	<c:if test = "${not empty users}">
	<table>
	<center>
	<thead>
    <tr>
      <th>Users</th>
    </tr>
  </thead>
		<c:forEach items="${users}" var="user" >
			<tr>
			<td><a id = "user" href ="/viewProfile/${user.id}">${user.username}</a></td>
	    	</tr>
		</c:forEach>
		</center>
	</table>
	</c:if>
</body>
</html>