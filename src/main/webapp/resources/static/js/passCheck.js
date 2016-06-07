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