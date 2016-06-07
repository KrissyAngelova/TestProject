<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Wellcome</title>
  <link rel="stylesheet" href="/resources/static/css/indexCss.css">
</head>
    <body class="align">

  <div class="site__container">

    <div class="grid__container">

      <form action="/Login" method="post" class="form form--login">

 		<div class="form__field">
          <label for="login__username"><span class="hidden">Username</span></label>
          <input type="text" name="uname" class="form__input" required placeholder="Username" autocomplete="off" >
        </div>

        <div class="form__field">
          <label for="login__password"><span class="hidden">Password</span></label>
          <input type="password" name="pass" class="form__input" placeholder="Password" required autocomplete="off" >
        </div>

        <div class="form__field">
          <input type="submit" value="Login"/>
        </div>
        <div class="form__field">
          <input type="reset" value="Reset" />
        </div>

      </form>
    
      <center>
      <br>
      ${loginErrorMessage}
      <br>
      <c:set var="loginErrorMessage" value="" scope="session"  />
      
      <p class="text--center"> <a href="/reg"> Yet Not Registered!!</a></p>
      </center>
    </div>

  </div>

</body>
</html>