<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%-- <%@include file="resource.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Data Tables -->
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">


<!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> -->
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


<title>Insert title here</title>
</head>
<body>

<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>





<%--  <c:set var="user" value="${allUser}" scope="session" />--%>
<div class="container" id="maindiv">
<input type="hidden" value="Ranjeet" id="name"/>
<hr>
<table id="tables" class="table table-bordered table-hover table-striped table-success">
<thead >
<tr>
<th>Name</th>
<th>Email</th>
<th>Contact No.</th>
<th>Address</th>

</tr>
</thead>

<tbody id="itemdata">
<c:forEach items="${allUser}" var="usr">
<tr>
<td>${usr.name }</td>
<td>${usr.email }</td>
<td>${usr.contact}</td>
<td>${usr.address }</td>

</tr>
</c:forEach>
</tbody>
</table>
<hr>
<%-- <div class="container">
<c:out value="${ sessionScope.user}"></c:out>
</div> --%>
<select id="visiblity" style="width: 300px;height: 35px;">
<option value="select">Please Select</option>
<option value="R">ranjeet</option>
<option value="N">nityanand</option>
<option value="R">Raj</option>
<option value="K">Kumar</option>
<option value="M">Maurya</option>
</select>
<select id="test"onchange="chang(event)" style="width: 300px;height: 35px;">
<option value="select">Please Select</option>
<option value="Ran">Ranjeet</option>
<option value="Raj">Raj</option>
<option value="San">Santosh</option>
</select>

<input type="text" id="val"  style="width: 300px;height: 35px;">
<button type="button" class="btn btn-primary" id="fn"><img src="https://cdn5.vectorstock.com/i/1000x1000/59/29/click-here-hand-sign-icon-press-button-vector-20655929.jpg" height="20" width="30"></button>
<button type="button" class="btn btn-danger" id="fnc">Add More</button>
</div>
<div class ="container" id="div2"></div>
<div class="container" id="div3"></div>
<script type="text/javascript">


	chang=function(){
		//var valueSelect=$('#test').val();
		var valueSelect=$('#test option:selected').text();
		alert("hii->"+valueSelect);
		if(valueSelect!=="Please Select"){
			sel.style.borderColor="green";
			$('#val').val(valueSelect);
			$('#div3').empty();
			$('#div3').append('<select id="dynamic" style="width: 300px;height: 35px;"></select>');
			var a=document.createElement("option");
			a.text="Ranjeet Nityanand";
			a.value="Ranjeet Nityanand";
			var b=document.createElement("option");
			b.text="Raj";
			b.value="Raj";
			var select=document.getElementById("dynamic");
			
			select.appendChild(a);
			select.appendChild(b);
		}
		
		else{
			sel.style.borderColor="red";
			$('#div3').empty();
		}
		 
	}
	var sel=document.getElementById('visiblity');
	sel.style.borderColor='red';
	$(document).ready(function() {
	strUser=sel.options[sel.selectedIndex].value;
	});
	var one=document.getElementById('fn');
	var two=document.querySelector("#fnc");
 
	sel.addEventListener('change',function(){
	var strUser = sel.options[sel.selectedIndex].text;//or value	
	alert("You Select=="+strUser);
	if(strUser==="ranjeet"){
		$("#div2").empty();
		$("#div2").append('<button type="button" id="rn" onclick="rnFunction()" class="btn btn-success">Hii Ranjeet</button><br><br>'+
				'<button type="button" onclick="fn()" class= "btn btn-danger">Hey</button>');
		console.log("Hii  '"+strUser+"'  You are Admin");
	}
	else{
		$("#div2").empty();
	}
	if(strUser==="nityanand"){
		$('#div2').empty();
		$('#div2').append('<table class="table table-bordered table-hover table-gray table-striped" id="tbl">'+
				'<tr><th>Name</th>'+
				'<th>Mobile no</th>'+
				'<th>Address</th>'+
				'<th>Email</th>'+
				'</tr><tbody>'+
				'<c:forEach items="${allUser}" var="usr">'+
				'<tr><td>${usr.name}</td>'+
				'<td>${usr.contact}</td>'+
				'<td>${usr.address}</td>'+
				'<td>${usr.email}</td>'+
				'</tr>'+
				'</c:forEach>'+
				
				'</tbody></table>');
		 $('#tbl').DataTable();
	}
	if(strUser!="Please Select")
		$('#val').val(strUser);
	
  });
	fn=function(){
	let strUser=sel.options[sel.selectedIndex].text;
	alert("Done..."+strUser)
	alert(a);
		}

	rnFunction=function(){
	let strUser=sel.options[sel.selectedIndex].text;
	alert("hi "+strUser);
	alert(a);
	<c:forEach items="${allUser}" var="user">
	alert('${user.name}')
	</c:forEach>
}
		
	one.addEventListener('click',function(){
	//alert("Value is "+sel.value);
	console.log(sel.value);
	console.log(strUser);
	//$("#itemdata").empty();
	$("#itemdata").append("<tr><td>Sonu</td><td>sonu@gmail.com</td><td>4587589652</td><td>Noida</td></tr>");
  });
	two.addEventListener('click',function(){
	//alert(" message");
	//alert(a);
	//test();
	//$('#div3').empty();
	$('#div3').append('<div class="form-group"><div class="form-group"><div class="input-group">'+
	'<input type="text" id="cl" class="form-control" style="height:37px;width:220px" placeholder="'+
	'Enter Text"/><i class="icon ion-close"></i><span id="close" class="input-group-addon" onclick="closed()" style="">&#10006;</span>'+
	'<button type="button" id="close" onclick="closed()" style="width:35px">X</button><input type="button"'+
	' id="close" value="Add" name="abc"style="height:37px;width:80px; margin-left:5px;margin-bottom: 8px;"/></div></div></div>');
	 
			
	});
	function closed(){
		var a= document.getElementById('close');
		var b= document.getElementById('cl');
		b.style.visibility = "hidden";
		a.style.visibility = "hidden";
		//$("#close").style.background='red';
		//a.style.background='red';
		
		
			//	alert("clicked");
		
				
	}

$(document).ready(function() {
    $('#tables').DataTable();
   
} );
var a;
/* $(document).ready(function() {
	//a=10;
	//alert(a);
	test=function(){
		<c:forEach items="${allUser}" var="usr">
		alert(('${usr.name}'));
		</c:forEach>
	}
	test();
	
});
 */
</script>
</body>
</html>