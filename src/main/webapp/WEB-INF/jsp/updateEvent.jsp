<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <form method="post" action="/UpdateEvent/${event.id}">
            <center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Enter Information Here</th>
                    </tr>
                </thead>
                <tbody>
                   
                    <tr>
                        <td>Event name</td>
                        <td><input type="text" name="name"  value="${event.name}" required/></td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td><input type="text" name="description" value="${event.description}"" required/></td>
                    </tr>
                    <tr>
                    	<td>Current date</td>
                    	<td><p><fmt:formatDate pattern="dd-MM-YYYY" value="${event.date}"/></p></td>
                    </tr>
                     <tr>
                        <td>Set new date</td>
                        <td><input type="date" name="date" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
        <p>${updateEventMessage}</p>
       
        <form method="put" action="/addGiftPage">
		<input type="submit" value="Add gift" />
		</form>
        <form method="get" action="/loggedUserPage">
		<input type="submit" value="Back" />
		</form>
		 <c:set var="updateEventMessage" value="" scope="session"></c:set>
</body>
</html>