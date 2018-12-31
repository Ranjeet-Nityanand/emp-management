<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@include file="resource.jsp"%>
    
    
    
    <!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Flattern - Flat and trendy bootstrap site template</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta name="description" content="" />
  <meta name="author" content="" />


  <!-- =======================================================
    Theme Name: Flattern
    Theme URL: https://bootstrapmade.com/flattern-multipurpose-bootstrap-template/
    Author: BootstrapMade.com
    Author URL: https://bootstrapmade.com
  ======================================================= -->
</head>

<body>
  <div id="wrapper">
    <!-- toggle top area -->
    <div class="hidden-top">
      <div class="hidden-top-inner container">
        <div class="row">
          <div class="span12">
            <ul>
              <li><strong>We are available for any custom works this month</strong></li>
              <li>Main office: Springville center X264, Park Ave S.01</li>
              <li>Call us <i class="icon-phone"></i> (123) 456-7890 - (123) 555-7891</li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <!-- end toggle top area -->
    <!-- start header -->
    <header>
      <div class="container">
			
			       <!-- hidden top area toggle link -->
        <div id="header-hidden-link">
          <a href="#" class="toggle-link" title="Click me you'll get a surprise" data-target=".hidden-top"><i></i>Open</a>
        </div>
        <!-- end toggle link -->
        <div class="row nomargin">
       
          <div class="span12">
            <!-- Signup Modal -->
            <div id="mySignup" class="modal styled hide fade" tabindex="-1" role="dialog" aria-labelledby="mySignupModalLabel" aria-hidden="true">
              <div class="modal-header">
              
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 id="mySignupModalLabel">Create an <strong>account</strong></h4>
              </div>
              <div class="modal-body">
                <form class="form-horizontal">
                  <div class="control-group">
                    <label class="control-label" for="inputEmail">Email</label>
                    <div class="controls">
                      <input type="text" id="inputEmail" placeholder="Email">
                    </div>
                  </div>
                  <div class="control-group">
                    <label class="control-label" for="inputSignupPassword1">Password</label>
                    <div class="controls">
                      <input type="password" id="inputSignupPassword1" placeholder="Password">
                    </div>
                  </div>
                  <div class="control-group">
                    <label class="control-label" for="inputSignupPassword2">Confirm Password</label>
                    <div class="controls">
                      <input type="password" id="inputSignupPassword2" placeholder="Password">
                    </div>
                  </div>
                  <div class="control-group">
                    <div class="controls">
                      <button type="submit" class="btn">Sign up</button>
                    </div>
                    <p class="aligncenter margintop20">
                      Already have an account? <a href="#mySignin" data-dismiss="modal" aria-hidden="true" data-toggle="modal">Sign in</a>
                    </p>
                  </div>
                </form>
              </div>
            </div>
            <!-- end signup modal -->
            <!-- Sign in Modal -->
            <div id="mySignin" class="modal styled hide fade" tabindex="-1" role="dialog" aria-labelledby="mySigninModalLabel" aria-hidden="true">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 id="mySigninModalLabel">Login to your <strong>account</strong></h4>
              </div>
              <div class="modal-body">
                <form class="form-horizontal">
                  <div class="control-group">
                    <label class="control-label" for="inputText">empname</label>
                    <div class="controls">
                      <input type="text" id="inputText" placeholder="empname">
                    </div>
                  </div>
                  <div class="control-group">
                    <label class="control-label" for="inputSigninPassword">Password</label>
                    <div class="controls">
                      <input type="password" id="inputSigninPassword" placeholder="Password">
                    </div>
                  </div>
                  <div class="control-group">
                    <div class="controls">
                      <button type="submit" class="btn">Sign in</button>
                    </div>
                    <p class="aligncenter margintop20">
                      Forgot password? <a href="#myReset" data-dismiss="modal" aria-hidden="true" data-toggle="modal">Reset</a>
                    </p>
                  </div>
                </form>
              </div>
            </div>
      
            
                   <!-- end signin modal -->
            <!-- Reset Modal -->
            <div id="myReset" class="modal styled hide fade" tabindex="-1" role="dialog" aria-labelledby="myResetModalLabel" aria-hidden="true">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 id="myResetModalLabel">Reset your <strong>password</strong></h4>
              </div>
              <div class="modal-body">
                <form class="form-horizontal">
                  <div class="control-group">
                    <label class="control-label" for="inputResetEmail">Email</label>
                    <div class="controls">
                      <input type="text" id="inputResetEmail" placeholder="Email">
                    </div>
                  </div>
                  <div class="control-group">
                    <div class="controls">
                      <button type="submit" class="btn">Reset password</button>
                    </div>
                    <p class="aligncenter margintop20">
                      We will send instructions on how to reset your password to your inbox
                    </p>
                  </div>
                </form>
              </div>
            </div>
            <!-- end reset modal -->
          </div>
        </div>
        <div class="row">
          <div class="span4">
            <div class="logo">
              <a href="index.html"><img src="img/logo.png" alt="" class="logo" /></a>
              <h1>Flat and trendy bootstrap template</h1>
            </div>
          </div>
          <div class="span8">
            <div class="navbar navbar-static-top">
              <div class="navigation">
                <nav>
                  <ul class="nav topnav">
                    <li class="dropdown">
                      <a href="">Manage Employee <i class="icon-angle-down"></i></a>
                      <ul class="dropdown-menu">
                        <li><a href="index-alt2.html">Add Employee</a></li>
                        <li><a href="index-alt3.html">Edit Employee</a></li>
                      </ul>
                    </li>
                   </ul>
                     <%--  
                        <li class="dropdown"><a href="#">3 Sliders <i class="icon-angle-right"></i></a>
                          <ul class="dropdown-menu sub-menu-level1">
                            <li><a href="index.html">Nivo slider</a></li>
                            <li><a href="index-alt2.html">Slit slider</a></li>
                            <li><a href="index-alt3.html">Parallax slider</a></li>
                          </ul>
                        </li>
                      </ul>
                    </li>
                    --%>
                   
                </nav>
              </div>
              <!-- end navigation -->
            </div>
          </div>
        </div>
      </div>
    </header>
    <!-- end header -->
    <div class="container color dark">
     ${successmsg}
     ${message1}
     </div>
     <section id="inner-headline">
     
      <div class="container">
        <div class="row">
          <div class="span4">
            <div class="inner-heading">
              <div class="container"> <h2>Fetching all Records</h2> </div>
            </div>
          </div>
           	
           </div>
      </div>
    </section>
    <div class="container" id="bodydiv">
    <div class="container-fluid">
		
		<table class="table table-hover table table-dark" border="2" style="width: 100%">
			<thead>
				<tr>
					<th>Employee_ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Address</th>
					<th>Contact</th>
					<th>Role</th>
					<th>Action</th>
					<th>Edit User</th>
				</tr>
			</thead>
			<tbody id="empdata">

				<c:forEach items="${allUser}" var="emp">

					<tr style="font-size: 16px">
					<!--  <input type="hidden" name="hid" value="${emp.id}">-->
						<td>${emp.id}</td>
						<td>${emp.name}</td>
						<td>${emp.email}</td>
						<td>${emp.address}</td>
						<td>${emp.mobileno}
						<td>${emp.rollName}</td>
						<c:if test="${emp.status_id==1}">
							<td><button type="button" class="btn-danger" id="dangerbtn"
									onclick="changestatus('${emp.email}','2')">Inactive</button>
									</td>
									
						</c:if>
						<c:if test="${emp.status_id==2}">
							<td><button type="button" class="btn-success" id="successbtn"
									onclick="changestatus('${emp.email}','1')">Active</button>
								</td>
							</c:if>
							<td><button type="button" class="btn-success" id="successbtn"
									onclick="editProfile('${emp.id}','${emp.name}','${emp.email}','${emp.mobileno}','${emp.address}','${emp.roll_id}')">Edit</button></td>
					</tr>
					
				</c:forEach>


			</tbody>
		</table>
    
    </div>
   
   
   
          <div class="span8">
            <ul class="breadcrumb">
              <li><a href="#"><i class="icon-home"></i></a><i class="icon-angle-right"></i></li>
              <li><a href="#">Features</a><i class="icon-angle-right"></i></li>
              <li class="active">Icons</li>
            </ul>
          </div>
        </div>
      </div>
    </section>
    
       
    
    
    <!-- change     -->
   
      <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Edit Record</h4>
        </div>
          <form action="editEmployee" method="post" onsubmit="return validation()" >
         <div class="container">
        <div class="modal-body">
          <div class="container-fluid" >
          <input type="hidden" name="id" id="id">
          <label>Name </label> <input type="text" class="form-control" id="name" name="name" required>
          <span id="names" class="text-danger font-weight-bold"> </span>
          </div>
          <div class="container-fluid">
          <label>Email</label> <input type="text" class="form-control" id="email" name="email" required>
                    <span id="emails" class="text-danger font-weight-bold"> </span>
          
          </div>
          <div class="container-fluid">
          <label>Contact</label><input type="text"class="form-control" id="contact" name="contact" required>
                    <span id="contacts" class="text-danger font-weight-bold"> </span>
          
          </div>
          <div class="container-fluid">
          <label>Address</label><input type="text"class="form-control" id="address" name="address" required>	
                    <span id="addresss" class="text-danger font-weight-bold"> </span>
          
          </div>
          <div class="container-fluid">
          <label>Role</label><input type="text" class="form-control" id="role" name="role" required>
          <span id="roles" class="text-danger font-weight-bold"> </span>
          
         </div>
        </div>
        </div>
       
          <button type="submit" class="btn btn-success" >Save</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
       
       </form>
      </div>
      
    </div>
  </div>
  
    
      <footer>
      <div class="container">
        <div class="row">
          <div class="span3">
            <div class="widget">
              <h5 class="widgetheading">Browse pages</h5>
              <ul class="link-list">
                <li><a href="#">About our company</a></li>
                <li><a href="#">Our services</a></li>
                <li><a href="#">Meet our team</a></li>
                <li><a href="#">Explore our portfolio</a></li>
                <li><a href="#">Get in touch with us</a></li>
              </ul>
            </div>
          </div>
          <div class="span3">
            <div class="widget">
              <h5 class="widgetheading">Important stuff</h5>
              <ul class="link-list">
                <li><a href="#">Press release</a></li>
                <li><a href="#">Terms and conditions</a></li>
                <li><a href="#">Privacy policy</a></li>
                <li><a href="#">Career center</a></li>
                <li><a href="#">Flattern forum</a></li>
              </ul>
            </div>
          </div>
          <div class="span3">
            <div class="widget">
              <h5 class="widgetheading">Flickr photostream</h5>
              <div class="flickr_badge">
                <script type="text/javascript" src="http://www.flickr.com/badge_code_v2.gne?count=8&amp;display=random&amp;size=s&amp;layout=x&amp;source=emp&amp;emp=34178660@N03"></script>
              </div>
              <div class="clear">
              </div>
            </div>
          </div>
          <div class="span3">
            <div class="widget">
              <h5 class="widgetheading">Get in touch with us</h5>
              <address>
								<strong>Flattern studio, Pte Ltd</strong><br>
								 Springville center X264, Park Ave S.01<br>
								 Semarang 16425 Indonesia
					 		</address>
              <p>
                <i class="icon-phone"></i> (123) 456-7890 - (123) 555-7891 <br>
                <i class="icon-envelope-alt"></i> email@domainname.com
              </p>
            </div>
          </div>
        </div>
      </div>
      <div id="sub-footer">
        <div class="container">
          <div class="row">
            <div class="span6">
              <div class="copyright">
                <p>
                  <span>&copy; Flattern - All right reserved.</span>
                </p>
                <div class="credits">
                  <!--
                    All the links in the footer should remain intact.
                    You can delete the links only if you purchased the pro version.
                    Licensing information: https://bootstrapmade.com/license/
                    Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Flattern
                  -->
                  Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
                </div>
              </div>
            </div>
            <div class="span6">
              <ul class="social-network">
                <li><a href="#" data-placement="bottom" title="Facebook"><i class="icon-facebook icon-square"></i></a></li>
                <li><a href="#" data-placement="bottom" title="Twitter"><i class="icon-twitter icon-square"></i></a></li>
                <li><a href="#" data-placement="bottom" title="Linkedin"><i class="icon-linkedin icon-square"></i></a></li>
                <li><a href="#" data-placement="bottom" title="Pinterest"><i class="icon-pinterest icon-square"></i></a></li>
                <li><a href="#" data-placement="bottom" title="Google plus"><i class="icon-google-plus icon-square"></i></a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </footer>
  </div>
  <a href="#" class="scrollup"><i class="icon-chevron-up icon-square icon-32 active"></i></a>
 

 

<script>
function editProfile(id,name,email,mobileno,address,roll_id){
	//document.getElementById("myModal").innerHTML=""+name+""+email+""+mobileno+""+address+""+roleName+".";
	$("#name").val(name);
	$("#email").val(email);
	$("#contact").val(mobileno);
	$("#address").val(address);
	$("#role").val(roll_id);
	$("#id").val(id);
	$("#myModal").modal();
}

	
function changestatus(email, status) {
	alert(email + "----" + status);
	$.ajax({
		url : "update-emp-status?email=" + email +"&status=" +status,
		type:"GET",
		success:function(data){
					$("#empdata").empty();
					if(data!=null && data.length>0){
						for(var i=0;i<data.length;i++){
							var trtable="<tr>"+
							"<td>"+data[i].id+"</td>"+
							"<td>"+data[i].name+"</td>"+
							"<td>"+data[i].email+"</td>"+
							"<td>"+data[i].address+"</td>"+
							"<td>"+data[i].mobileno+"</td>"+
							"<td>"+data[i].rollName+"</td>"
							if(data[i].status_id==1){
								trtable+=" <td><button type='button' class='btn-danger' "+
								"onclick=changestatus('"+data[i].email+"',2)>Inactive</button></td>";
								}
								else{
									trtable+="<td><button type='button' class='btn-success' "+
									"onclick=changestatus('"+data[i].email+"',1)>Active</button></td>";
									}
							        trtable+="<td><button type='button' class='btn btn-success' "+
									"onclick=editProfile('"+data[i].id+"','"+data[i].name+"','"+data[i].email+"','"+data[i].mobileno+"','"+data[i].address+"','"+data[i].roll_id+"')>Edit</button></td>";
							trtable+="</tr>";
							$("#empdata").append(trtable);
							}
					}
					else{
						alert("No Data found");
					}
						
						},
	error : function(response)
	{
		alert("Error");
	}
				
	});
}



</script>
<script>

function validation(){

	var name1 = document.getElementById('name').value;
	var email1 = document.getElementById('email').value;
	var contact1 = document.getElementById('contact').value;
	var address1 = document.getElementById('address').value;
	var role1 = document.getElementById('role').value;





	if(name1 == ""){
		document.getElementById('names').innerHTML =" ** Please fill the Name field";
		return false;
	}
	if((name1.length <= 2) || (name1.length > 40)) {
		document.getElementById('names').innerHTML =" ** Name lenght must be between 2 and 40";
		return false;	
	}
	if(!isNaN(name1)){
		document.getElementById('names').innerHTML =" ** only characters are allowed";
		return false;
	}







	if(address1 == ""){
		document.getElementById('addresss').innerHTML =" ** Please fill the Address field";
		return false;
	}
	if((address1.length <= 2) || (address1.length > 90)) {
		document.getElementById('addresss').innerHTML =" ** Address lenght must be between  2 and 90";
		return false;	
	}


	//if((role1.length <= 1) || (role1.length > 10)){
		//document.getElementById('roles').innerHTML =" ** Role Must be between 1 to 10";
		//return false;
//	}



	if(role1 == ""){
		document.getElementById('roles').innerHTML =" ** Please fill the Role field";
		return false;
	}




	if(contact1 == ""){
		document.getElementById('contacts').innerHTML =" ** Please fill the mobile NUmber field";
		return false;
	}
	if(isNaN(contact1)){
		document.getElementById('contacts').innerHTML =" ** Mobline Number must write digits only not characters";
		return false;
	}
	if(contact1.length!=10){
		document.getElementById('contacts').innerHTML =" ** Mobile Number must be 10 digits only";
		return false;
	}



	if(email1 == ""){
		document.getElementById('emails').innerHTML =" ** Please fill the email idx` field";
		return false;
	}
	if(email1.indexOf('@') <= 0 ){
		document.getElementById('emails').innerHTML =" ** @ Invalid Position";
		return false;
	}

	if((email1.charAt(email1.length-4)!='.') && (email1.charAt(email1.length-3)!='.')){
		document.getElementById('emails').innerHTML =" ** . Invalid Position";
		return false;
	}
}

</script>

</body>

</html>
    