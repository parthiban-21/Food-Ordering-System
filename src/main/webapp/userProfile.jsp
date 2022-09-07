<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>  
<!DOCTYPE html>
<html>
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
	<a href="userOrders.jsp">Order</a>
	<a class="active" href="userProfile.jsp">Profile</a>
	<a href="/logout">Logout</a>
	</div>
</div>

<div class="split left">
<div class="table">
<label class="formhead">Your Details</label>
<img class="profile" alt="Profile Picture" src="images/profilePicture.png">
<table> 
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
	<form action="updateInfo" method="post">
	<label class="formhead">Update Your Information</label>
	
	<label class="lable">Name</label>
	<input type="text" name="name" class="input" placeholder="Enter New Name" value="${userName}"
	pattern="[A-Za-z]+" title="Invalied Name" required><br>
	
	<label class="lable">Mobile Number</label>
	<input type="text" name="mobileno" class="input" placeholder="Enter New Mobile Number" value="${mobileNo}"
	pattern="^(0/91)?[7-9][0-9]{9}$" title="Invalied Mobile Number" required><br>
	
	<label class="lable">Address</label>
	<input type="text" name="address" class="input" placeholder="Enter New Address" value="${address}"
	pattern="[A-Za-z0-9]+" title="Invalied Address" required><br>
	
	<label class="lable">Password</label>
	<input type="password" name="password" class="input" placeholder="Confirm Password" required><br>
	<div class="formbottom">
	<input type="submit" class="button" value="Update Info">
	</div>
	</form>
</div>
</div>
</body>
</html>