<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="/resources/static/css/createEventCss.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create event</title>
</head>

<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <link rel="stylesheet" href="/resources/static/css/navigationBarStyle.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav navbar-left">
<li class="nav navbar-nav navbar-right"><a href = "/Logout" id = "logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>

      <li><a href = "/loggedUserPage" id ="myProfile"><span class="glyphicon glyphicon-user"></span> ${user.username}</a></li>
      
    </ul>
  </div>
</nav>
</body>

<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
		<script type="text/javascript" src = "/resources/static/js/navigationBar.js"></script>
 <body>
        
   <form method="post" action="/CreateEvent">>
<ul class="form-style-1">
    <li><label>Event name <span class="required">*</span></label><input type="text" name="name" class="field-divided" />
    
    <li>
        <label>Description <span class="required">*</span></label>
        <textarea name="description" id="field5" class="field-long field-textarea"></textarea>
    </li>
    <li>
   		 <label>Date<span class="required">*</span></label>
         <input type="date" name="date" value="" required/>
   </li>
    
    <li>
        <input type="submit" value="Create" />&nbsp;<input type = "reset" value = "Reset"/>
        <p>${createEventMessage}</p>
    </li>
</ul>
</form>
 
        <c:set var="createEventMessage" value="" scope="session"  />
         <form method="get" action="/loggedUserPage" class="form-style-1">
         <center>
		<input type="submit" value="Back" />
		</center>
		</form>
    </body>
</html>