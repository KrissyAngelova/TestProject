<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
      <li><a id = "back">Back</a></li>
      <li><a href = "/loggedUserPage" id ="myProfile"><span class="glyphicon glyphicon-user"></span> ${user.username}</a></li>
      <form action="/Search" method="post" id="custom-search-input">
           <li class="dropdown">
        	<select name = "choice" id = "choice">
   			<option value="user">User</option>
   			<option value="event">Event</option>
 			</select>
    		</li>
   		    <li>
			  <div class="row"> 		      
			  <div class="col-lg-6">
			    <div class="input-group">
			      	<input type="text" class="form-control" name = "name" placeholder="Search for...">
			   		 <span class="input-group-btn">
			        <button class="btn btn-default" type="submit">Go!</button>
			    	</span>
			    </div>
			    </div>
			    </div>

             </li>
             </form>
    </ul>
  </div>
</nav>
</body>

<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
		<script type="text/javascript" src = "/resources/static/js/navigationBar.js"></script>
	
</html>