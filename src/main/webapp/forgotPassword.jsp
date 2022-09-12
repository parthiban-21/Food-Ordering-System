<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="EN">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="loginStyle.css">
<link rel="icon" type="image/x-icon" href="images/logo.png">
<title>Forgot Password</title>
</head>
<body>
<div class="forgot-password">
	<form action="/forgotPassword" method="post">
		<label class="formhead">Foody Lost Password</label>
		<label class="lable">Email ID</label>
		<input type="email" name="emailID" class="input" placeholder="Enter Your Email-ID" required><br>
		<label class="lable">New Password</label>
		<input type="password" name="password" id = "showPassword" class="input" placeholder="Enter New Password" 
		pattern="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$" title="Invalied Password" required><br>
		<div>
		<input type="checkbox" onclick="myFunction()"><label class="show-password">Show Password</label>
		</div>
		<input type="submit" class="button" value="Update">
	</form>
	<label class="errorLabel">${errMsg}</label>
</div>
<script type="text/javascript">
function myFunction() {
	var x = document.getElementById("showPassword");
	if (x.type === "password") {
		x.type = "text";
	} else {
		x.type = "password";
	}
}
</script>
</body>
</html>