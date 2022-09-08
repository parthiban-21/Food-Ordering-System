<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<a href="/user">Home</a>
	<a class="active" href="userOrders.jsp">Order</a>
	<a href="userProfile.jsp">Profile</a>
	<a href="/logout">Logout</a>
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
		<c:forEach var="orders" items="${orderDetails}">
			<tr>
				<td>#${orders.orderID}</td>
				<td>${orders.orderDate}</td>
				<td>${orders.orderType}</td>
				<td>Rs. ${orders.totalPrice}</td>
				<td>${orders.orderStatus}</td>
			</tr>
		</c:forEach>
	</table>
</div>

</body>
</html>