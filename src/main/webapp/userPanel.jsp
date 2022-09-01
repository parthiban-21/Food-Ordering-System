<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="userPanelStyle.css">
<link rel="icon" type="image/x-icon" href="images/logo.png">
<title>Foody Order</title>
</head>
<body>
<div class="header">
	<img class = "logo" alt="Logo" src="images/logo.png">
	<label>Foody | Hello, ${userName}</label>
	<div class="header-right">
	<a class="active" href="userPanel.jsp">Home</a>
	<a href="userOrders.jsp">Order</a>
	<a href="userProfile.jsp">Profile</a>
	<a href="#logout">Logout</a>
	</div>
</div>

<div class="split right">
<div class="table">
<label class="formhead">Your Cart</label>
<select>
		<option value="dineIn">Dine-In</option>
		<option value="pickUp">Pick-Up</option>
		<option value="delivery">Delivery</option>
</select>

<table>
		<tr>
			<th>Name</th>
			<th>Quantity</th>
			<th>Price</th>
			
		</tr>
		<tr>
			<td>Dosa</td>
			<td>2</td>
			<td>40.0</td>
		</tr>
	</table>
	<br>
	<label class="total">Total Price: ${totalPrice}</label>
	</div>
	<div class="formbottom">
	<a href="#confirmOrder"><button class="confirmBtn">Confirm Order</button></a>
	<a href="#cancelOrder"><button class="button">Cancel Order</button></a>
	</div>
</div>

<div class="Split left">
<div class="form">
<label class="formhead">Dishes</label>
<div class="menu-section">
	<div class="menu">
		<img alt="Menu-Img" src="/images/default-menu-img.png">
		<div class="grad">
		<p class="menu-name">Name</p>
		<div class="formbottom">
		<p class="menu-price">Rs.100 /- </p>
		<button class="add-btn">Add Cart</button>
		<button class="delete-btn">-</button>
		</div>
		</div>
	</div>
	
	<div class="menu">
		<img alt="Menu-Img" src="/images/default-menu-img.png">
		<div class="grad">
		<p class="menu-name">Name</p>
		<div class="formbottom">
		<p class="menu-price">Rs.100 /- </p>
		<button class="add-btn">Add Cart</button>
		<button class="delete-btn">-</button>
		</div>
		</div>
	</div>
	
	<div class="menu">
		<img alt="Menu-Img" src="/images/default-menu-img.png">
		<div class="grad">
		<p class="menu-name">Name</p>
		<div class="formbottom">
		<p class="menu-price">Rs.100 /- </p>
		<button class="add-btn">Add Cart</button>
		<button class="delete-btn">-</button>
		</div>
		</div>
	</div>
</div>
</div>
</div>
</body>
</html>