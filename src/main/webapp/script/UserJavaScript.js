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
function showAddress(divId, element,pincode) {
	
	let delivery = document.getElementById(divId);
	let pickup = document.getElementById('pickup-total');
	let y = document.getElementById('addressError');
	let z = document.getElementById('confirmOrder');
	if(element.value === 'delivery'){
		if(checkPincode(pincode)){
			delivery.style.display = 'block';
			pickup.style.display = 'none';
			y.style.display = 'none';
		}
		else{
			delivery.style.display = 'block';
			pickup.style.display = 'none';
			y.style.display = 'block';
			z.disabled = true;
		}
	}
	else{
		delivery.style.display = 'none';
		pickup.style.display = 'block';
		y.style.display = 'none';
		z.disabled = false;
	}
}

//check pincode
function checkPincode(pincode){
	const code = pincode;
	if(code>=600001 && code<=602107) {
		console.log("true");
		return true;
	}
	else{
		console.log("false");
		return false;
	}
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