<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="EN">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="userPanelStyle.css">
<link rel="icon" type="image/x-icon" href="images/logo.png">
<title>Foody Order</title>
</head>
<body>
<c:forEach var="info" items="${userDetails}">
	<c:set var="id" scope="session" value="${info.id}"/>
	<c:set var="userName" scope="session" value="${info.name}"/>
	<c:set var="emailID" scope="session" value="${info.mailID}"/>
	<c:set var="mobileNo" scope="session" value="${info.phoneNumber}"/>
	<c:set var="address" scope="session" value="${info.address}"/>
</c:forEach>
<div class="header">
	<img class = "logo" alt="Logo" src="images/logo.png">
	<label>Foody | Hello, ${userName}</label>
	<div class="header-right">
	<a class="active" href="/user">Home</a>
	<a href="/orders">Order</a>
	<a href="userProfile.jsp">Profile</a>
	<a href="/logout">Logout</a>
	</div>
</div>

<div class="split right">
<div class="table">
<table>
<caption class="table-head">Your Cart</caption>
		<tr>
			<th>Name</th>
			<th colspan="3">Quantity</th>
			<th>Price</th>
		</tr>
		<c:forEach var="cart" items="${cartDetails}">
		<c:set var="total" value="${0}"/>
		<c:set var="temp" value="${cart.totalPrice}"/>
		<c:set var="grandTotal" value="${temp+grandTotal+total}"/>
		<tr>
			<td>${cart.itemName}</td>
			<td><a href="/incQuantity?itemID=${cart.itemID}&itemQuantity=${cart.quantity}"><button class = "qty">+</button></a></td>
			<td>${cart.quantity}</td>
			<td><a href="/decQuantity?itemID=${cart.itemID}&itemQuantity=${cart.quantity}"><button class = "qty">-</button></a></td>
			<td>${cart.totalPrice}</td>
			<td><a href="/dropItem?userID=${id}&itemID=${cart.itemID}"><button class = "remove-cart">&#9747;</button></a></td>
		</tr>
		</c:forEach>
	</table>
	<br>
	<label class="total">Total Price : Rs. ${grandTotal} /-</label>
	</div>
	<div class="user-address" id="show-address">
	<p><b>Delivery Address:</b> ${address}</p>
	<a href="userProfile.jsp">Edit Address</a>
	</div>	
	<div class="formbottom">
	<form action="/confirmOrder">
		<select name="orderType" onchange="showAddress('show-address',this)">
			<option value="pickUp" selected="selected">Pick-Up</option>
			<option value="delivery">Delivery</option>
		</select>
		<input type="submit" class="confirmBtn" value="Confirm Order">
	</form>
		<a href="/dropAll?userID=${id}"><button class="cancelBtn">Cancel</button></a>
	</div>
</div>

<div class="Split left">
<div class="form">
<label class="formhead">Dishes</label>
<form action="/searchItem">
	<input type="search" name="itemName">
	<input type="submit">
</form>
<div class="menu-section">
	<c:forEach var="menu" items="${menuDetails}">
		<div class="menu">
			<img alt="Menu-Img" src="data:image/jpg;base64,${menu.imgPath}">
			<div class="grad">
				<p class="menu-name">${menu.itemName}</p>
				<div class="menubottom">
					<p class="menu-price">Rs.${menu.itemPrice} /-</p>
					<a href="/addToCart?userID=${id}&itemID=${menu.itemID}"><button class="add-btn" onclick='this.disabled = true;'>Add to Cart</button></a>
				</div>
			 </div>
		</div>
	</c:forEach>
</div>
</div>
</div>
<script type="text/javascript">
function showAddress(divId, element) {
	document.getElementById(divId).style.display = element.value == 'delivery' ? 'block' : 'none';
}
</script>
</body>
</html>