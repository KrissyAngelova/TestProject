<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
        <link rel="stylesheet" href="/resources/static/css/indexCss.css">
</head>
<body>

    <body class="align">

  <div class="site__container">

    <div class="grid__container">

      <form action="/Registration" method="post" class="form form--login">

        <div class="form__field">
          <label for="login__username"><span class="hidden">Username</span></label>
          <input type="text" value="" name="uname" class="form__input" placeholder="Username" required autocomplete="off" >
        </div>
        
        <div class="form__field">
          <label for="login__password"><span class="hidden">Password</span></label>
          <input id="password" type="password" name="pass" class="form__input" placeholder="Password" required autocomplete="off" >
        </div>

		<div class="form__field">
          <label for="login__password"><span class="hidden">Confirm password</span></label>
          <input id="confrimPassword" type="password" name="confirmPass" class="form__input" placeholder="Confirm password" required autocomplete="off" >
        </div>
        
        <div class="form__field">
          <input id="submit" type="submit" value="Sign up">
        </div>

		<div class="form__field">
          <input type="reset" value="Reset">
        </div>
        
      </form>
      <br>
      <center> <h7>${pswdMessage}</h7> </center>
      <center> <h7>${regMessage}</</h7> </center>
      <br>
      <c:set var="regMessage" value="" scope="session"  />
      
      <p class="text--center"> <a href="/">Already registered!!!</a></p>
    </div>
  </div>

</body>

<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#submit").click(function() {
				var password = $("#password").val();
				var confirmPassword = $("#confirmPassword").val();
				if (password != confirmPassword) {
					alert("Passwords do not match!");
					return false;
				}
				return true;
			});
		});
	</script>
</html>