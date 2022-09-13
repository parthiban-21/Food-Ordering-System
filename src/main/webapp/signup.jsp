<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="EN">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="signupStyle.css">
<link rel="icon" type="image/x-icon" href="images/logo.png">
<title>Sign-Up Foody</title>
</head>
<body>
<div class="split left">
	<div class="form">
	<form name="signupForm" action="signUp" method="post">
		<label class="formhead">Create an Account</label>
		
		<label class="lable">Name</label>
		<input type="text" name="name" class="input" placeholder="Enter Your Name"
		pattern="[A-Za-z]+" title="Invalied Name" required><br>
		
		<label class="lable">Mobile Number</label>
		<label class="errorLabel">${errMsgPhoneNumber}</label>
		<input type="text" name="mobileno" class="input" placeholder="Enter Your Mobile Number"
		pattern="^(0/91)?[7-9][0-9]{9}$" title="Invalied Mobile Number" required><br>
		
		<label class="lable">Address</label>
		<input type="text" name="address" class="input" placeholder="Enter Your Address"
		pattern="^[#.0-9a-zA-Z\s,-]+$" title="Invalied Address" required><br>
		
		<label class="lable">Email ID</label>
		<label class="errorLabel">${errMsg}</label>
		<input type="email" name="emailID" class="input" placeholder="Enter Your Email-ID" required><br>
		
		<label class="lable">Password</label>
		<input type="password" name="password" class="input" placeholder="Set Password" 
		pattern="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$" title="Invalied Password" required><br>
		
		<div class="formbottom">
			<input type="submit" class="button" value="Create Account">
			<label class="opac">If you already have account <a href="login.jsp">Login</a></label>
		</div>
		</form>
	</div>
</div>
<div class="Split right">
	<div class="left-design">
		<div class="logo-des">
			<img class = "logo" alt="Logo" src="images/logo.png">
		</div>
		<p class="desc-head">Foody</p>
		<p class="desc">Everything Begins here...</p>
	</div>
</div>
</body>
</html>