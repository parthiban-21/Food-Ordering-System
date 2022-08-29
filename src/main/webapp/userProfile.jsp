<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<a href="userPanel.jsp">Home</a>
	<a href="userOrders.jsp">Order</a>
	<a class="active" href="userProfile.jsp">Profile</a>
	<a href="logout">Logout</a>
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
	<form action="">
	<label class="formhead">Update Your Information</label>
	<label class="lable">Name</label>
	<input type="text" name="username" class="input" placeholder="${userName}" required><br>
	<label class="lable">Mobile Number</label>
	<input type="text" name="mobileno" class="input" placeholder="${mobileNo}" required><br>
	<label class="lable">Address</label>
	<input type="text" name="address" class="input" placeholder="${address}" required><br>
	<label class="lable">Email ID</label>
	<input type="email" name="emailID" class="input" placeholder="${emailID}" required><br>
	<label class="lable">Password</label>
	<input type="password" name="password" class="input" placeholder="Confirm Password" required><br>
	<div class="formbottom">
	<input type="submit" class="button" value="Update">
	</div>
	</form>
</div>
</div>
</body>
</html>