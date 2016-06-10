$(function() {
		   document.getElementById("back").onclick=function() {
		     var myForm = document.createElement("form");
		     myForm.action="/loggedUserPage"; 
		     myForm.method="GET";
		     myForm.submit();
		     return false; // cancel the actual link
		   }
		 });