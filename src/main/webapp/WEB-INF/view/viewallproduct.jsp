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
                      <a href="">Manage Product <i class="icon-angle-down"></i></a>
                      <ul class="dropdown-menu">
                        <li><a href="add-product">Add More Product</a></li>
                      </ul>
                    </li>
                   </ul>
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
              <div class="container"> <h2>Fetching all Product</h2> </div>
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
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Edit Data</th>
				</tr>
			</thead>
			<tbody id="pdata">

				<c:forEach items="${allUser}" var="prod">

					<tr style="font-size: 16px">
					<!--  <input type="hidden" name="hid" value="${emp.id}">-->
						<td>${prod.id}</td>
						<td>${prod.name}</td>
						<td>${prod.price}</td>
						<td>${prod.quantity}</td>
						<td><button type="button" class="btn-success" id="successbtn"
  						onclick="editProduct('${prod.id}','${prod.name}','${prod.price}','${prod.quantity}')">Edit</button></td>
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
    
       
    
    
    <!-- change     -->
   
      <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Edit Product</h4>
        </div>
          <form action="editProduct" method="post" onsubmit="return validation()" >
         <div class="container">
        <div class="modal-body">
          <div class="container-fluid" >
          <input type="hidden" name="id" id="id">
          <label>Product Name</label> <input type="text" class="form-control" id="name" name="name" required>
          <span id="names" class="text-danger font-weight-bold"> </span>
          </div>
          <div class="container-fluid">
          <label>Product Price</label> <input type="text" class="form-control" id="price" name="price" required>
                    <span id="prices" class="text-danger font-weight-bold"> </span>
          
          </div>
          <div class="container-fluid">
          <label>Quantity</label><input type="text"class="form-control" id="quantity" name="quantity" required>
                    <span id="quantitys" class="text-danger font-weight-bold"> </span>
          
          </div>
          <button type="submit" class="btn btn-success" >Edit</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
       </div>
       </div>
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
  
  <a href="#" class="scrollup"><i class="icon-chevron-up icon-square icon-32 active"></i></a>
 

 

<script>
function editProduct(id,product_name,price,quantity){
	//document.getElementById("myModal").innerHTML=""+name+""+email+""+mobileno+""+address+""+roleName+".";
	$("#name").val(product_name);
	$("#price").val(price);
	$("#quantity").val(quantity);
	$("#id").val(id);
	$("#myModal").modal();
}
</script>
<script>

function validation(){

	var name1 = document.getElementById('name').value;
	var price1 = document.getElementById('price').value;
	var quant = document.getElementById('quantity').value;





	if(name1 == ""){
		document.getElementById('names').innerHTML =" ** Please fill the Name Product field";
		return false;
	}
	if((name1.length <= 2) || (name1.length > 40)) {
		document.getElementById('names').innerHTML =" ** Product Name lenght must be between 2 and 40";
		return false;	
	}
	if(!isNaN(name1)){
		document.getElementById('names').innerHTML =" ** only characters are allowed";
		return false;
	}


	if(quant == ""){
		document.getElementById('quantitys').innerHTML =" ** Please fill the Quantity field";
		return false;
	}
	if(isNaN(quant)){
		document.getElementById('quantitys').innerHTML =" ** Quantity must write digits only not characters";
		return false;
	}
	
	
	if(price1 == ""){
		document.getElementById('prices').innerHTML =" ** Please fill the Price field";
		return false;
	}
	if(isNaN(price1)){
		document.getElementById('prices').innerHTML =" ** Price must write digits only not characters";
		return false;
	}

</script>

</body>

</html>
    