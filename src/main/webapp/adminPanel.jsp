<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="EN">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="adminPanelStyle.css">
<link rel="icon" type="image/x-icon" href="images/logo.png">
<title>Admin Window</title>
</head>
<body>

	<div class="header">
		<img class="logo" alt="Logo" src="images/logo.png"> <label>Foody
			| Hello, Admin</label>
		<div class="header-right">
			<a class="active" href="/admin">Home</a> <a href="/adminOrders">Orders</a>
			<a href="/logout">Logout</a>
		</div>
	</div>
	<div class="split left">
		<div class="form">
			<form action="/addMenu" method="post" enctype="multipart/form-data">
				<label class="formhead">Add Item</label> <label class="lable">Item
					Name:</label> <input type="text" name="menuName" class="input"
					placeholder="Enter Menu Name" required><br> <label
					class="lable">Item Price:</label> <input type="text"
					name="menuPrice" class="input" placeholder="Enter Menu Price"
					required><br> <label class="lable">Item Type:</label>
				<select name="menuType">
					<option value="breakfast">Breakfast</option>
					<option value="lunch">Lunch</option>
					<option value="snacks">Snack</option>
					<option value="dinner">Dinner</option>
				</select>
				<div class=upload>
					<label class="lable">Item Image:</label> <input type="file"
						id="file" class="uploadBtn" name="menuImg"> <label
						for="file">Choose a file</label>
				</div>
				<div class="formbottom">
					<br> <input type="submit" value="Add Item" class="button">
				</div>
			</form>
		</div>
	</div>
	<div class="Split right">
	
	<div class="table">
			<div>
				<label class="menu-lable">Item-ID</label> <label class="menu-lable">Item
					Name</label> <label class="menu-lable">Item Type</label> <label
					class="menu-lable">Item Price</label><br>
			</div>
			<section>
				<c:forEach var="menu" items="${menuDetails}">
					<form action="/editItem" class="edit-form">
						<input type="text" name="itemID" class="menu-input"
							value="${menu.itemID}" readonly="readonly"> <input
							type="text" name="itemName" id="item-input" class="menu-input"
							value="${menu.itemName}"> <select name="itemType"
							id="item-input" class="selection">
							<option value="breakfast">Breakfast</option>
							<option value="lunch">Lunch</option>
							<option value="snacks">Snack</option>
							<option value="dinner">Dinner</option>
							<option value="none">None</option>
							<option selected="selected">--${menu.itemType}--</option>
						</select> <input type="text" name="itemPrice" id="item-input"
							class="menu-input" value="${menu.itemPrice}"> <input
							type="submit" value="Update" class="viewBtn">
							</form>
			</c:forEach>
			</section>
			
		</div>
		
	</div>
</body>
</html>