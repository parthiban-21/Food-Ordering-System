
function myFunction(d) {
	d.preventDefault();
	var x = document.getElementById("order-details");
	var y = document.getElementById("tab");
	if (x.style.display === "none") {
		x.style.display = "flex";
		y.style.width = "75%";
	} else {
		x.style.display = "none";
		y.style.width = "96.6%";
	}
}

function showPassword() {
	var x = document.getElementById("showPassword");
	if (x.type === "password") {
		x.type = "text";
	} else {
		x.type = "password";
	}
}