<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="EN">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="contactStyle.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="icon" type="image/x-icon" href="images/logo.png">
<title>Contact Foody</title>
</head>
<body>
<!-- Header -->
<div class="header">
	<img class = "logo" alt="Logo" src="images/logo.png">
	<label>Foody | Hello, ${userName}</label>
	<div class="header-right">
	<a href="/user">Home</a>
	<a href="/orders">Order</a>
	<a href="userProfile.jsp">Profile</a>
	<a class="active" href="contact.jsp">Contact Us</a>
	<a href="/logout">Logout</a>
	</div>
</div>

<div class="split left">
	<div class="left-design">
		<div class="logo-des">
			<img class = "logo-img" alt="Logo" src="images/logo.png">
		</div>
		<p class="desc-head">Foody</p>
		<p class="desc">Discover unique tastes near you</p>
	</div>
</div>

<div class="Split right">
<div class="form">
	<label class="formhead">Contact Us</label>
	<p>
	<strong>&#128222; Call Us: </strong><a href="tel:+91 7639659287">+91 7639659287</a><br><br>
	<strong>&#128231; Mail Us: </strong><a href="mailto:contact@foody.com">contact@foody.com</a><br><br>
	<strong><em class="fa fa-map-marker"></em> Address:</strong>
	#131, West Mogappair, Chennai - 600027</p> 	
</div>
</div>
</body>
</html>