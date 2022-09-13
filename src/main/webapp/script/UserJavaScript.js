//Show and Hide Password
function showPassword() {
	let x = document.getElementById("show-Password");
	if (x.type === "password") {
		x.type = "text";
	} else {
		x.type = "password";
	}
}

//Display User Address
function showAddress(divId, element) {
	document.getElementById(divId).style.display = element.value == 'delivery' ? 'block' : 'none';
}

//Edit
function myFunction() {
		let name = document.getElementById("edit-name");
		let phoneNumber = document.getElementById("edit-phoneNumber");
		let address = document.getElementById("edit-addresss");
		let password = document.getElementById("edit-password");
		let submit = document.getElementById("edit-submit");
		if (submit.disabled === true) {
			name.disabled = false;
			phoneNumber.disabled = false;
			address.disabled = false;
			password.disabled = false;
			submit.disabled = false;
		}
	}

//Order Items*
function showOrderItem() {
	let x = document.getElementById("order-details");
	let y = document.getElementById("tab");
	if (x.style.display === "none") {
		x.style.display = "flex";
		y.style.width = "75%";
	} else {
		x.style.display = "none";
		y.style.width = "96.6%";
	}
}