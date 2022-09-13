function show() {
	var x = document.getElementById("show-Password");
	if (x.type === "password") {
		x.type = "text";
	} else {
		x.type = "password";
	}
}

function myFunction() {
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