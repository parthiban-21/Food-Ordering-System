<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Details</title>
<link rel="stylesheet" href="userOrderStyle.css">
<link rel="icon" type="image/x-icon" href="images/logo.png">
</head>
<body>
<div id="order-details" class="form">
	<table class="table-details">
		<tr>
		<th>Name</th>
		<th>Quantity</th>
		<th>Price</th>
		<th>Total</th>
		</tr>
		<c:forEach var="OrderItems" items="${orderItemDetails}">
		<tr>
		<td>${OrderItems.itemName}</td>
		<td>${OrderItems.quantity}</td>
		<td>${OrderItems.unitPrice}</td>
		<td>${OrderItems.totalPrice}</td>
		</tr>
		</c:forEach>
	</table>
	
	</div>
</body>
</html>