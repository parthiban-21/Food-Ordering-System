
let modal = document.getElementById("myModal");

let btn = document.getElementById("myBtn");

let span = document.getElementsByClassName("close")[0];

let pickup = document.getElementById('pickup-total');

function buttonAction(price){
	if(price!=0){
		modal.style.display = "block";
		pickup.style.display = 'block';
	}
	else{
		alert("Add Some Item to Cart");
	}
}

span.onclick = function() {
	modal.style.display = "none";
}

window.onclick = function(event) {
	if (event.target == modal) {
		modal.style.display = "none";
	}
}