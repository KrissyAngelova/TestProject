$(function() {
		   document.getElementById("back").onclick=function() {
		     var myForm = document.createElement("form");
		     var event = <%= session.getAttribute("eventId")%>;
		     myForm.action="/openEvent/"+event; 
		     myForm.method="GET";
		     myForm.submit();
		     return false; // cancel the actual link
		   }
		 });