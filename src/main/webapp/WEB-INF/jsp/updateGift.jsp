<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        <form method="post" action="/UpdateGift/${gift.id}">
            <center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Enter Information Here</th>
                    </tr>
                </thead>
                <tbody>
                   
                    <tr>
                        <td>Gift name</td>
                        <td><input type="text" name="name" value="${gift.name}" required/></td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td><input type="text" name="description" value="${gift.description}" required/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
        <p>${updateGiftMessage}</p>
        <c:set var="updateGiftMessage" value="" scope="session"  />
         <form method="get" action="/openEvent/${event.id}">
		<input type="submit" value="Back" />
		</form>
</body>
</html>