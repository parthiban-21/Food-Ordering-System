<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<a class="active" href="#adminPanel">Home</a>
	<a href="orders.jsp">Orders</a>
	<a href="login.jsp">Logout</a>
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
		<c:set var="allMenu" scope="session" value="${menuDetails}"/>
		<c:forEach var="menu" items="${allMenu}">
		<tr>
			<td>#${menu.menuID}</td>
			<td>${menu.menuName}</td>
			<td>${menu.menuType}</td>
			<td>Rs.${menu.menuPrice}</td>
			<td><a href="/delete?id=${menu.menuID}">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
	</div>
</div>
<div class="Split right">
<div class="form">
<form action="addMenu" method="post" enctype="multipart/form-data">
	<label class="formhead">Add Menu</label>
	
	<label class="lable">Menu Name:</label>
	<input type="text" name="menuName" class="input" placeholder="Enter Menu Name" required><br>
	
	<label class="lable">Menu Price:</label>
	<input type="text" name="menuPrice" class="input" placeholder="Enter Menu Price" required><br>
	
	<label class="lable">Menu Type:</label>
	<select name="menuType">
		<option value="breakfast">Breakfast</option>
		<option value="lunch">Lunch</option>
		<option value="snacks">Snack</option>
		<option value="dinner">Dinner</option>
	</select>
	<div class = upload>
	<label class="lable">Menu Image:</label>
	<input type="file" id="file" class="uploadBtn" name="menuImg" >
	<label for="file">Choose a file</label>
	</div>
	<div class="formbottom">
	<br>
	<input type="submit" value="Add Menu" class="button">
	</div>
</form>
</div>
</div>
</body>
</html>