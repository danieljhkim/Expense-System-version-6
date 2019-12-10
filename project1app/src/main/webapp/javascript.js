

function getAllReim(){
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			let reim = xhttp.responseText;
			setReimValues(reim);
		}
	}
	xhttp.open("POST", "ReimServlet", true);
	xhttp.send();
}

function filter(x){
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			let reim = xhttp.responseText;
			setFilteredValues(reim);
		}
	}
	xhttp.open("POST", "http://localhost:8080/project1app/FilterByStatus.do", true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("status=" + x);
}

function setReimValues(reim){
	document.getElementById("All_Reim").innerHTML = reim;
}
function setFilteredValues(reim){
	document.getElementById("filtered").innerHTML = reim;
}