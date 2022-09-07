<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="userPanelStyle.css">
<link rel="icon" type="image/x-icon" href="images/logo.png">
<title>Foody Order</title>
</head>
<body>
<c:forEach var="info" items="${userDetails}">
	<c:set var="userName" scope="session" value="${info.name}"/>
	<c:set var="emailID" scope="session" value="${info.mailID}"/>
	<c:set var="mobileNo" scope="session" value="${info.phoneNo}"/>
	<c:set var="address" scope="session" value="${info.address}"/>
</c:forEach>
<div class="header">
	<img class = "logo" alt="Logo" src="images/logo.png">
	<label>Foody | Hello, ${userName}</label>
	<div class="header-right">
	<a class="active" href="/user">Home</a>
	<a href="userOrders.jsp">Order</a>
	<a href="userProfile.jsp">Profile</a>
	<a href="/logout">Logout</a>
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
		<c:forEach var="cart" items="${cartDetails}">
		<c:set var="total" value="${0}"/>
		<c:set var="temp" value="${cart.totalPrice}"/>
		<c:set var="grandTotal" value="${temp+grandTotal+total}"/>
		<tr>
			<td>${cart.menuName}</td>
			<td>${cart.quantity}</td>
			<td>${cart.totalPrice}</td>
		</tr>
		</c:forEach>
	</table>
	<br>
	<label class="total">Total Price : Rs. ${grandTotal} /-</label>
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
	<c:forEach var="menu" items="${menuDetails}">
		<div class="menu">


			<img alt="Menu-Img" src="data:image/jpg;base64,${menu.imgPath}">
			<div class="grad">
				<p class="menu-name">${menu.menuName}</p>
				<div class="formbottom">
					<p class="menu-price">Rs.${menu.menuPrice} /-</p>
					<button class="add-btn">Add Cart</button>
					<button class="delete-btn">-</button>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
</div>
</div>
</body>
</html>