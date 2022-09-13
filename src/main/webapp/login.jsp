<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="EN">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="loginStyle.css">
<link rel="icon" type="image/x-icon" href="images/logo.png">
<title>Login Foody</title>
</head>
<body>
<div class="split left">
	<div class="left-design">
		<div class="logo-des">
			<img class = "logo" alt="Logo" src="images/logo.png">
		</div>
		<p class="desc-head">Foody</p>
		<p class="desc">Discover unique tastes near you</p>
	</div>
</div>

<div class="Split right">
<div class="form">
	<form action="signIn" method="get">
		<label class="formhead">Foody Login</label>
		<label class="lable">Email ID</label>
		<input type="email" name="emailID" class="input" placeholder="Enter Your Email-ID" required><br>
		<label class="lable">Password</label>
		<input type="password" name="password" id = "show-Password" class="input" placeholder="Enter Your Password" required><br>
		<div>
		<input type="checkbox" onclick="showPassword();"><label class="show-password">Show Password | </label>
		<a href="forgotPassword.jsp">Forgot Password</a>
		</div>
		<input type="submit" class="button" value="Sign-In">
		<label class="opac">Or</label>
	</form>
	<a href="signup.jsp"><button class="button">Sign-Up</button></a>
	<label class="errorLabel">${errMsg}</label>
</div>
</div>
<script>
function showPassword() {
	let x = document.getElementById("show-Password");
	if (x.type === "password") {
		x.type = "text";
	} else {
		x.type = "password";
	}
}
</script>
</body>
</html>