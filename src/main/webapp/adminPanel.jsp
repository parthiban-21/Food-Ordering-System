<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="adminPanelStyle.css">
<link rel="icon" type="image/x-icon" href="images/logo.png">
<title>Admin Window</title>
</head>
<body>

<div class="header">
	<img class = "logo" alt="Logo" src="images/logo.png">
	<label>Foody | Hello, Admin</label>
	<div class="header-right">
	<a href="Orders.jsp">Orders</a>
	<a href="#edit">Edit</a>
	<a href="logout">Logout</a>
	</div>
</div>
<div class="split left">
<div class="table">
<table>
		<tr>
			<th>Menu ID</th>
			<th>Menu Name</th>
			<th>Menu Type</th>
			<th>Menu Price</th>
		</tr>
		<tr>
			<td>101</td>
			<td>Dosa</td>
			<td>Breakfast</td>
			<td>20.0</td>
			<td><a href="#delete">Delete</a></td>
		</tr>
	</table>
	</div>
</div>
<div class="Split right">
<div class="form">
<form action="addMenu">
	<label class="formhead">Add Menu</label>
	<label class="lable">Menu Name:</label>
	<input type="text" name="menuName" class="input" placeholder="Enter Menu Name" required><br>
	<label class="lable">Menu Price:</label>
	<input type="text" name="menuPrice" class="input" placeholder="Enter Menu Price" required><br>
	<label class="lable">Menu Type:</label>
	<select>
		<option value="breakfast">Breakfast</option>
		<option value="lunce">Lunch</option>
		<option value="snacks">Snack</option>
		<option value="dinner">Dinner</option>
	</select>
	<div class="formbottom">
	<br>
	<input type="submit" value="Add Menu" class="button">
	</div>
</form>
</div>
</div>
</body>
</html>