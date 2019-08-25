<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="resource.jsp"%>
</head>

<body>
	<div id="wrapper">
		<!-- toggle top area -->
		<div class="hidden-top">
			<div class="hidden-top-inner container">
				<div class="row">
					<div class="span12">
						<ul>
							<li><strong>We are available for any custom works
									this month</strong></li>
							<li>Main office: JMD Megapolis Gurugaon,Haryana</li>
							<li>Call us <i class="icon-phone"></i>+918923496827
							</li>
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
					<a href="#" class="toggle-link"
						title="Click me you'll get a surprise" data-target=".hidden-top"><i></i>Open</a>
				</div>
				<!-- end toggle link -->
				<div class="row">
					<div class="span4">
						<div class="logo">
							<a href="index.html"><img src="img/logo.png" alt=""
								class="logo" /></a>
							<h1>We solve your Problems</h1>
						</div>
					</div>
					<div class="span8">
						<div class="navbar navbar-static-top">
							<div class="navigation">
								<nav>
									<ul class="nav topnav">
										<li class="dropdown"><a href="index.html">Home <i
												class="icon-angle-down"></i></a>
											<ul class="dropdown-menu">
												<li><a href="index-alt2.html">Homepage 2</a></li>
												<li><a href="index-alt3.html">Homepage 3</a></li>
											</ul></li>
										<li class="dropdown"><a href="#">Features <i
												class="icon-angle-down"></i></a>
											<ul class="dropdown-menu">
												<li><a href="typography.html">Typography</a></li>
												<li><a href="components.html">Components</a></li>
												<li><a href="animations.html">56 Animations</a></li>
												<li><a href="icons.html">Icons</a></li>
												<li><a href="icon-variations.html">Icon variations</a></li>
												<li class="dropdown"><a href="#">3 Sliders <i
														class="icon-angle-right"></i></a>
													<ul class="dropdown-menu sub-menu-level1">
														<li><a href="index.html">Nivo slider</a></li>
														<li><a href="index-alt2.html">Slit slider</a></li>
														<li><a href="index-alt3.html">Parallax slider</a></li>
													</ul></li>
											</ul></li>
										<li class="dropdown active"><a href="#">Pages <i
												class="icon-angle-down"></i></a>
											<ul class="dropdown-menu">
												<li><a href="about.html">About us</a></li>
												<li><a href="pricingbox.html">Pricing boxes</a></li>
												<li><a href="testimonials.html">Testimonials</a></li>
												<li><a href="404.html">404</a></li>
											</ul></li>
										<li class="dropdown"><a href="#">Portfolio <i
												class="icon-angle-down"></i></a>
											<ul class="dropdown-menu">
												<li><a href="portfolio-2cols.html">Portfolio 2
														columns</a></li>
												<li><a href="portfolio-3cols.html">Portfolio 3
														columns</a></li>
												<li><a href="portfolio-4cols.html">Portfolio 4
														columns</a></li>
												<li><a href="portfolio-detail.html">Portfolio
														detail</a></li>
											</ul></li>
										<li class="dropdown"><a href="#">Blog <i
												class="icon-angle-down"></i></a>
											<ul class="dropdown-menu">
												<li><a href="blog-left-sidebar.html">Blog left
														sidebar</a></li>
												<li><a href="blog-right-sidebar.html">Blog right
														sidebar</a></li>
												<li><a href="post-left-sidebar.html">Post left
														sidebar</a></li>
												<li><a href="post-right-sidebar.html">Post right
														sidebar</a></li>
											</ul></li>
										<li><a href="contact.html">Contact </a></li>
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
		<section id="inner-headline">
			<div class="container">
				<div class="row">
					<div class="span4">
						<div class="inner-heading">
							<h2>
								
							</h2>
						</div>
					</div>
					<div class="span8">
						<ul class="breadcrumb">
							<li><a href="#"><i class="icon-home"></i></a><i
								class="icon-angle-right"></i></li>

							<li class="active">User ID-${user.getEmail()}</li>
						</ul>
					</div>
				</div>
			</div>
		</section>
		<section id="content">
			<div class="container">
				<div class="row marginbot30">
					<div class="span12">
						<div class="row">
							<div class="span4">
								<div class="wrapper">
									<div class="testimonial">
										<table class="table">
											<thead>
												<tr>
													<th align="LEFT">S.no.</th>
													<th align="LEFT">Item Name</th>
													<th align="LEFT">Quantity</th>
													<th align="LEFT">Price</th>
												</tr>
											
											<thead>
											<tbody id="itemdata">
												
											</tbody>
									
				
											
										</table>
										<div class="container" id="div1"></div>
									</div>
								</div>
							</div>

			<c:forEach items="${allitem}" var="prod">
				<div class="span3">
					<div class="wrapper">
					<div class="testimonial">
						<!--<img src="img/productpng/appleiphone.jpeg"
						style="height: 200px;padding-left:70px"alt="" />-->
						<figure class="figure">
						<a href="${prod.filename}">
					
					<img src="${prod.filename}" class="figure-img img-fluid rounded" style="height: 150px;width:200px;padding-left:0px"alt="Image" /></a>
					</figure>
					</div>
					
					<br />
				<div align="center">
				<button type="button" class="btn btn-primary btn"
				style="background-color: #f44336;"
				onclick="removeItem('${user.getId()}','${prod.id}','${prod.quantity}','${prod.price}','${prod.name}')">-</button>
				<button type="button" class="btn btn-primary btn"
				style="background-color: #009900;"
				onclick="addItem('${user.getId()}','${prod.id}','1','${prod.price}','${prod.name}')">+</button>
				<div>
					<span id="name">${prod.name}</span> <br /> <span id="id">${prod.id}</span>
					<br /> <span class="quantity">Left #${prod.quantity}</span>
					<br /> <span class="price" id="price">RS.${prod.price}</span>
				</div>
			</div>
		</div>
</div>
			</c:forEach>
			
		</div>
	</div>
	</div>
</div>
</section>

<script type="text/javascript">
	
		 
		function removeItem(userid,itemid,itemquantity,itemprice,itemname) {
			var userId = userid;
	     	var itemId = itemid;
			var selectedItem = itemquantity;
			var itemPrice = itemprice;
			var itemName=itemname;
			$.ajax({
				type:"POST",
				url:'/process-item1',
				data:JSON.stringify({"userid":userId,"itemid":itemId,"selecteditem":selectedItem,"itemprice":itemPrice,"itemname":itemName}),
				
				contentType :'application/json',		
			    
				success : function(data){
					$("#itemdata").empty();
					
					if(data!=null && data.length>0){
						for(var i=0;i<data.length;i++){
							var srno=i+1;
							var trtable ="<tr>"+
							"<td>"+srno+"</td>"+
							"<td>"+data[i].itemname+"</td>"+
							"<td>"+data[i].itemquantity+"</td>"+
							"<td>"+data[i].totalprice+"</td>"
							trtable +="</tr>";
							$("#itemdata").append(trtable);
							//$("#itemdata").DataTable();
						}
						
							var totalamount1=0;
							for(var j=0;j<data.length;j++){
								totalamount1=totalamount1+data[j].totalprice;
							}
							
							$("#itemdata").append("<tr>"+
									"<td>Total Amount<td><td>"+ totalamount1+"</td>"+
									"</tr>");
							
					}
					
					else{
						//alert("No Data found");
					}
				},error :function(){
					
				}
				
			});
		}
		function addItem(userid,itemid,selecteditem,itemprice,itemname) {
			var selectedItem=selecteditem;
			var userId=userid;
			var itemId=itemid;
			var itemPrice=itemprice;
			var itemName=itemname;
			$.ajax({
				type:"POST",
				url:'/process-item',
				data:JSON.stringify({"userid":userId,"itemid":itemId,"selecteditem":selectedItem,"itemprice":itemPrice,"itemname":itemName}),
				contentType :'application/json',		
			    success : function(data){
					$("#itemdata").empty();
					if(data!=null && data.length>0){
						for(var i=0;i<data.length;i++){
							var srno=i+1;
							var trtable ="<tr>"+
							"<td>"+srno+"</td>"+
							"<td>"+data[i].itemname+"</td>"+
							"<td>"+data[i].itemquantity+"</td>"+
							"<td>"+data[i].totalprice+"</td>"
							trtable +="</tr>";
							$("#itemdata").append(trtable);
						}
						
						var totalamount1=0;
						for(var j=0;j<data.length;j++){
							totalamount1=totalamount1+data[j].totalprice;
						}
						
						$("#itemdata").append("<tr>"+
								"<td>Total Amount<td><td>"+ totalamount1+"</td>"+
								"</tr>");
								
					}
					else{
						alert("No Data found");
					}
				},error :function(msg){
					alert("ERROR!!!!")
				}
				
			});
		}
		 $(document).ready(function(){
			 $("#div1").append('<button type="button" id="btn" class="btn btn-primary">Place Order</button>')
			 $('#btn').disabled=true;	
			 });
		 
</script>
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
								<script type="text/javascript"
									src="http://www.flickr.com/badge_code_v2.gne?count=8&amp;display=random&amp;size=s&amp;layout=x&amp;source=user&amp;user=34178660@N03"></script>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="span3">
						<div class="widget">
							<h5 class="widgetheading">Get in touch with us</h5>
							<address>
								<strong>Flattern studio, Pte Ltd</strong><br> Springville
								center X264, Park Ave S.01<br> Semarang 16425 Indonesia
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
								<li><a href="#" data-placement="bottom" title="Facebook"><i
										class="icon-facebook icon-square"></i></a></li>
								<li><a href="#" data-placement="bottom" title="Twitter"><i
										class="icon-twitter icon-square"></i></a></li>
								<li><a href="#" data-placement="bottom" title="Linkedin"><i
										class="icon-linkedin icon-square"></i></a></li>
								<li><a href="#" data-placement="bottom" title="Pinterest"><i
										class="icon-pinterest icon-square"></i></a></li>
								<li><a href="#" data-placement="bottom" title="Google plus"><i
										class="icon-google-plus icon-square"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</footer>
	</div>
	<a href="#" class="scrollup"><i
		class="icon-chevron-up icon-square icon-32 active"></i></a>
</body>
</html>