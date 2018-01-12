function onlyNos(e, t) {
	try {
		if (window.event) {
			var charCode = window.event.keyCode;
		} else if (e) {
			var charCode = e.which;
		} else {
			return true;
		}
		if (charCode > 31 && (charCode < 48 || charCode > 57)) {
			return false;
		}
		return true;
	} catch (err) {
		alert(err.Description);
	}
}

function testFunction(){
	var date = document.getElementById("date").value;
	alert(date);
	location.href="view.jsp?date=" + date;
}