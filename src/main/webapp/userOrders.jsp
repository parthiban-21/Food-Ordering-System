<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="EN">
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
<div class="split right">
	<div id="order-details" class="form">
	<table class="table-details">
		<caption class="table-head">Order Details</caption>
		<tr>
		<th>Name</th>
		<th>Quantity</th>
		<th>Price</th>
		<th>Total</th>
		</tr>
		<c:forEach var="OrderItems" items="${orderItemDetails}">
		<c:set var="total" value="${0}"/>
		<c:set var="temp" value="${OrderItems.totalPrice}"/>
		<c:set var="grandTotal" value="${temp+grandTotal+total}"/>
		<c:set var="charge" value="${0}"/>
		<c:if test="${orderType eq 'delivery'}">
			<c:set var="charge" value="${25}"/>
		</c:if> 
			<tr>
			<td>${OrderItems.itemName}</td>
			<td>${OrderItems.quantity}</td>
			<td>${OrderItems.unitPrice}</td>
			<td>${OrderItems.totalPrice}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="3">Total Price</td>
			<td><strong>&#8377; ${grandTotal+charge}</strong></td>
		</tr>
		<tr>
			<td colspan="2">Type</td>
			<td colspan="2"><strong>${orderType}</strong></td>
		</tr>
	</table>
	</div>
</div>
<div class="Split left">
		<div class="tab" id="tab">
	<table class="order-table">
	<caption class="table-head">Your Orders</caption>
		<tr>
			<th>Order ID</th>
			<th>Order Date</th>
			<th>Order Type</th>
			<th>Order Status</th>
		</tr>
		<c:forEach var="orders" items="${orderDetails}">
			<tr>
				<td>#${orders.orderID}</td>
				<td>${orders.orderDate}</td>
				<td>${orders.orderType}</td>
				<td>${orders.orderStatus}</td>
				<td><a href="/orderItems?orderID=${orders.orderID}&orderType=${orders.orderType}"><button class="viewBtn">View Order</button></a></td>
				<td><a href="/cancelOrder?orderID=${orders.orderID}"><button class="button">Cancel Order</button></a></td>
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
		<a href="/orderItems?orderID=${completeOrders.orderID}&orderType=${completeOrders.orderType}"><button class="viewBtn">View Order</button></a>
	</div>
	</c:forEach>
</div>
</div>
</body>
</html>