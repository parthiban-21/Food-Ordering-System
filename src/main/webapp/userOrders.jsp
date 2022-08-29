<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="userOrderStyle.css">
<link rel="icon" type="image/x-icon" href="images/logo.png">

<title>Orders</title>
</head>
<body>
<div class="header">
	<img class = "logo" alt="Logo" src="images/logo.png">
	<label>Foody | Hello, ${userName}</label>
	<div class="header-right">
	<a href="userPanel.jsp">Home</a>
	<a class="active" href="userOrders.jsp">Order</a>
	<a href="userProfile.jsp">Profile</a>
	<a href="logout">Logout</a>
	</div>
</div>

<div class="tab">
	<label class="formhead">Your Orders</label>
	<table>
		<tr>
			<th>Order ID</th>
			<th>Order Date</th>
			<th>Order Type</th>
			<th>Total Price</th>
			<th>Order Status</th>
		</tr>
		<tr>
			<td>#${orderID}</td>
			<td>${orderDate}</td>
			<td>${orderType}</td>
			<td>Rs. ${totalPrice}</td>
			<td>${orderStatus}</td>
		</tr>
	</table>
</div>

</body>
</html>