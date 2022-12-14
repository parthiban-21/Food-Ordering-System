<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="EN">
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
	<a href="/logout">Logout</a>
	</div>
</div>
<div class="split right">
	<div id="order-details" class="form">
	<table class="table-details">
	<caption class="table-head">Order Item Details</caption>
		<tr>
		<th scope="col">Name</th>
		<th scope="col">Quantity</th>
		<th scope="col">Price</th>
		<th scope="col">Total</th>
		</tr>
		<c:forEach var="OrderItems" items="${userOrderItemDetails}">
			<c:set var="orderID" value="${OrderItems.orderID}"/>
			<c:set var="total" value="${0}"/>
			<c:set var="temp" value="${OrderItems.totalPrice}"/>
			<c:set var="grandTotal" value="${temp+grandTotal+total}"/>
			<c:set var="charge" value="${0}"/>
			<c:if test="${orderType eq 'delivery'}">
				<c:set var="charge" value="${25}"/>
			</c:if> 
			
			<c:set var="user" value="${OrderItems.userName}"/>
			<c:set var="userAddress" value="${OrderItems.userAddress}"/>
			<c:set var="userPhoneNumber" value="${OrderItems.userPhoneNumber}"/>
			<c:set var="userMailID" value="${OrderItems.userMailID}"/>
				<tr>
				<td>${OrderItems.itemName}</td>
				<td>${OrderItems.quantity}</td>
				<td>${OrderItems.unitPrice}</td>
				<td>${OrderItems.totalPrice}</td>
				</tr>
		</c:forEach>
		<tr>
		<td colspan="3">Total Price</td>
		<td colspan="1">&#8377; ${grandTotal+charge}</td>
		</tr>
	</table>
	<div class="customer-details">
		<label>Order-ID: ${orderID}</label>
		<label>Order Type: ${orderType}</label>
		<label>Name: ${user}</label>
		<label>Mail-ID: ${userMailID}</label>
		<label>Phone Number: ${userPhoneNumber}</label>
		<label>Address: ${userAddress}</label>
	</div>
	
	</div>
</div>
<div class="Split left">
	<div class="tab" id="tab">
	<table class="order-table">
	<caption class="table-head">Orders</caption>
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
				<td><a href="/userOrderItems?orderID=${orders.orderID}&orderType=${orders.orderType}"><button class="viewBtn">View Order</button></a></td>
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
		<label class="completed"> <strong> ${completeOrders.orderStatus} </strong></label>
		<a href="/userOrderItems?orderID=${completeOrders.orderID}&orderType=${completeOrders.orderType}"><button class="viewBtn">View Order</button></a>
	</div>
	</c:forEach>
</div>
</div>
</body>
</html>