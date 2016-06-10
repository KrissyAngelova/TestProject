$(function() {
		   document.getElementById("logout").onclick=function() {
		     var myForm = document.createElement("form");
		     myForm.action=this.href;// the href of the link
		     myForm.method="POST";
		     myForm.submit();
		     return false; // cancel the actual link
		   }
		 });
	 
$(function() {
		   document.getElementById("myProfile").onclick=function() {
		     var myForm = document.createElement("form");
		     myForm.action=this.href;// the href of the link
		     myForm.method="GET";
		     myForm.submit();
		     return false; // cancel the actual link
		   }
		 });