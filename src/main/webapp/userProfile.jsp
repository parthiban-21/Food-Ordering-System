<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>  
<!DOCTYPE html>
<html lang="EN">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="userProfileStyle.css">
<link rel="icon" type="image/x-icon" href="images/logo.png">
<title>User Profile</title>
</head>
<body>

<div class="header">
	<img class = "logo" alt="Logo" src="images/logo.png">
	<label>Foody | Hello, ${userName}</label>
	<div class="header-right">
	<a href="/user">Home</a>
	<a href="/orders">Order</a>
	<a class="active" href="userProfile.jsp">Profile</a>
	<a href="contact.jsp">Contact Us</a>
	<a href="/logout">Logout</a>
	</div>
</div>

<div class="split left">
<div class="table">
<img class="profile" alt="Profile Picture" src="images/profilePicture.png">
<table>
<caption class="table-head">Your Details</caption>
		<tr>
			<th>Name: </th>
			<td>${userName}</td>
		</tr>
		<tr>
			<th>Email-ID: </th>
			<td>${emailID}</td>
		</tr>
		<tr>
			<th>Phone No: </th>
			<td>${mobileNo}</td>
		</tr>
		<tr>
			<th>Address: </th>
			<td>${address}</td>
		</tr>

	</table>
	</div>
</div>

<div class="Split right">
<div class="form">
	<form action="updateInfo" method="get">
	<label class="formhead">Update Your Information</label>
	
	<label class="lable">Name</label>
	<input type="text" name="name" id="edit-name" class="input" placeholder="Enter New Name" value="${userName}"
	pattern="[A-Za-z]+" title="Invalied Name" disabled="disabled" required><br>
	
	<label class="lable">Mobile Number</label>
	<input type="text" name="mobileno" id="edit-phoneNumber" class="input" placeholder="Enter New Mobile Number" value="${mobileNo}"
	pattern="^(0/91)?[7-9][0-9]{9}$" title="Invalied Mobile Number" disabled="disabled" required readonly="readonly"><br>
	
	<label class="lable">Address</label>
	<input type="text" name="address" id="edit-addresss" class="input" placeholder="Enter New Address" value="${address}"
	pattern="^[#.0-9a-zA-Z\s,-]+[-\s]+[6][0-9]{5}$" title="Invalied Address" disabled="disabled" required><br>
	
	<label class="lable">Password</label>
	<input type="password" name="password" id="edit-password" class="input" placeholder="Confirm Password" disabled="disabled" required><br>
	<div class="formbottom">
	<input type="submit" id="edit-submit" class="button" value="Update Info" disabled="disabled">
	<a class="edit-button" onclick="myFunction();">&#9998; Edit</a>
	</div>
	</form>
</div>
</div>
<script src="./script/UserJavaScript.js"></script>
</body>
</html>