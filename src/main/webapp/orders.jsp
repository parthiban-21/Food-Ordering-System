<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="ordersStyle.css">
<link rel="icon" type="image/x-icon" href="images/logo.png">
<title>Orders</title>
</head>
<body>
<div class="header">
	<img class = "logo" alt="Logo" src="images/logo.png">
	<label>Foody | Hello, Admin</label>
	<div class="header-right">
	<a href="/admin">Home</a>
	<a class="active" href="/adminOrders">Orders</a>
	<a href="login.jsp">Logout</a>
	</div>
</div>
<div class="split right">
	<div id="order-details" class="form">
	<table class="table-details">
		<tr>
		<th>Name</th>
		<th>Quantity</th>
		<th>Price</th>
		<th>Total</th>
		</tr>
		<c:forEach var="OrderItems" items="${userOrderItemDetails}">
		<c:set var="total" value="${0}"/>
		<c:set var="temp" value="${OrderItems.totalPrice}"/>
		<c:set var="grandTotal" value="${temp+grandTotal+total}"/>
			<tr>
			<td>${OrderItems.itemName}</td>
			<td>${OrderItems.quantity}</td>
			<td>${OrderItems.unitPrice}</td>
			<td>${OrderItems.totalPrice}</td>
			</tr>
		</c:forEach>
		<tr>
		<td colspan="3">Total Price</td>
		<td>Rs: ${grandTotal}</td>
		</tr>
	</table>
	
	</div>
</div>
<div class="Split left">
	<div class="tab" id="tab">
	<label class="formhead">Your Orders</label>
	<table class="order-table">
		<tr>
			<th>Order ID</th>
			<th>Order Date</th>
			<th>Order Type</th>
			<th>Order Status</th>
		</tr>
		<c:forEach var="orders" items="${adminOrderDetails}">
			<tr>
				<td>#${orders.orderID}</td>
				<td>${orders.orderDate}</td>
				<td>${orders.orderType}</td>
				<td>${orders.orderStatus}</td>
				<td><a href="/userOrderItems?orderID=${orders.orderID}"><button class="viewBtn">View Order</button></a></td>
				<td><a href="/updateOrderStatus?orderID=${orders.orderID}"><button class="button">Update Status</button></a></td>
				</tr>
		</c:forEach>
	</table>
</div>
<div class="completed-section">
	<c:forEach var="completeOrders" items="${completedOrderDetails}">
	<div class="completed-orders">
		<label>OrderID: ${completeOrders.orderID}</label>
		<label>OrderDate: ${completeOrders.orderDate}</label>
		<label class="completed">${completeOrders.orderStatus}</label>
		<a href="/userOrderItems?orderID=${completeOrders.orderID}"><button class="viewBtn">View Order</button></a>
	</div>
	</c:forEach>
</div>
</div>
</body>
</html>