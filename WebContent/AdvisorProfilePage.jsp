<!DOCTYPE html>
<%@page import="org.AC.dto.AdvisorProfileDTO"%>
<%@page import="org.AC.dto.ProfessionalBackgroundDTO"%>
<%@page import="org.AC.dto.AdvisorServiceDTO"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="assets/img/favicon.png">

    <title>Advisor Profile</title>
	<style type="text/css"> 
		.carousel-control.right{background-image:none !important;}
		.carousel-control.left{background-image:none !important;}
		.bdesign{font-size:20px !important;}
		.imgresize{width:100%}
		@media only screen and (max-width:700px){
		.font_size{font-size:22px !important;}
		.imgresize{width:100%}
		}
		@media only screen and (min-width: 320px) and (max-width: 470px) {
		.bdesign{font-size:14px !important;}
		.font_size{font-size:16px !important;}
		.hode{display:none;}
		.imgresize{width:100%;height:180px !important}
		.resize_height{height:180px}
		}
		
		@media only screen and (min-width: 470px) and (max-width: 700px) {
		.bdesign{font-size:14px !important;}
		.font_size{font-size:16px !important;}
		.imgresize{width:50%;height:180px !important}
		}
		 </style>  		 
    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="assets/css/main.css" rel="stylesheet">
	 <link href="assets/css/full-slider.css" rel="stylesheet">
    <!-- Fonts from Google Fonts -->
	<link href='http://fonts.googleapis.com/css?family=Lato:300,400,900' rel='stylesheet' type='text/css'>
   	<%
   		List<AdvisorProfileDTO> advisors= (List<AdvisorProfileDTO>)request.getAttribute("advisordetails");
   	  	List<ProfessionalBackgroundDTO> profession= (List<ProfessionalBackgroundDTO>)request.getAttribute("advisorprofession");
   	 	List<AdvisorServiceDTO> services= (List<AdvisorServiceDTO>)request.getAttribute("advisorservices");
   			pageContext.setAttribute("advisors", advisors);
   			pageContext.setAttribute("profession", profession);
   			pageContext.setAttribute("services", services);
   	%>
  
  </head>

  <body>

    <!-- Fixed navbar -->
    <div class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header" style="margin-left">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#"><b style="font-size:30px">Advisor </b></br> <b style="font-size:30px;color:#000;font-family: Arial">Circuit</b></a>
        </div>
         
        <div style="height:10px"></div>

        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
		    
            <li><a href="#" style="font-family:Helvetica Neue,Helvetica,Arial,sans-serif;font-size:20px">Home</a></li>
            <li><a href="#" style="font-family:Helvetica Neue,Helvetica,Arial,sans-serif;font-size:20px">About</a></li>
            <li><a href="#" style="font-family:Helvetica Neue,Helvetica,Arial,sans-serif;font-size:20px">Services</a></li>
            <li class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="font-family:Helvetica Neue,Helvetica,Arial,sans-serif;font-size:20px">Advisors<span class="caret"></span> </a>
			<ul class="dropdown-menu"> <li><a href="#">1</a></li> <li><a href="#">2</a></li> <li><a href="#">3</a></li> 
			</ul> </li>
            <li><a href="#" style="font-family:Helvetica Neue,Helvetica,Arial,sans-serif;font-size:20px">Contact</a></li>
			<li class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="font-family:Helvetica Neue,Helvetica,Arial,sans-serif;font-size:20px"> More <span class="caret"></span> </a>
			<ul class="dropdown-menu"> <li><a href="#">1</a></li> <li><a href="#">2</a></li> <li><a href="#">3</a></li> 
		    </ul> </li>
			
			<li>
			<div style="width:180px;">
			<form class="" role="form">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search">
					 <span class="input-group-btn">
					 <button class="btn btn-default" type="button" style="height:42px"><i class="glyphicon glyphicon-search"></i></button> 
					 </span>
			 </div>
			</form>
			</div>
			</li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

	<div style="height:100px"></div>
	
	<div class="container">
					
				<div style="margin-left:8%">	
				
				<div style="width:100%">
					<table width="100%">
					<tr><td style=" width:65%;height:300px;" class="resize_height"><!-- Full Page Image Background Carousel Header -->
    <header id="myCarousel" class="carousel slide">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for Slides -->
        <div class="carousel-inner">
            <div class="item active">
                <!-- Set the first background image using inline CSS below. -->
                <div class="fill" style="background-image:url('assets/img/profile_car2.png');"></div>
                <div class="carousel-caption">
                    <!--<h2>Caption 1</h2>-->
                </div>
            </div>
            <div class="item">
                <!-- Set the second background image using inline CSS below. -->
                <div class="fill" style="background-image:url('http://placehold.it/1900x1080&text=Slide Two');"></div>
                <div class="carousel-caption">
                    <h2>Caption 2</h2>
                </div>
            </div>
            <div class="item">
                <!-- Set the third background image using inline CSS below. -->
                <div class="fill" style="background-image:url('assets/img/profile_car.png');"></div>
                <div class="carousel-caption">
                    <h2>Caption 3</h2>
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>

    </header>

					</td>
					
				<c:forEach items="${advisors}" var="advisor">
					<td valign="top" style="padding:1% 4% 1% 4%">
					<h3 style="color:rgba(123, 119, 125, 1);font-size:34px;letter-spacing:1px" class="font_size">
					<b><c:out value="${advisor.getName()}"/></b></h3><h4 style="font-size:26px;color:#848181" class="font_size"><c:out value="${ advisor.getOccupation()}"/></h4>
					</br>	
					<p  class="font_size"><a class="btn btn-primary btn-lg" role="button">Book Session</a></p>
					</td>
					</tr>
					</table>
					
					<div style="height:40px"></div>
					
					<p style="width:85%"><c:out value="${advisor.getIntroduction()}"/></p>
				</div>
					
					
					<div style="height:40px"></div>
				
				<!--advisor experience table-->
				<table  style="width:90%;background-color:rgba(243, 243, 243, 0.9);border-top:1px solid #ccc">
					<tr>
						<td rowspan="5" valign="top" class="hode">
						<h2 style="font-size:22px;padding:1% 5% 1% 5%;"><b>Kishi is available for the following services : </b></h2>
						
						<c:forEach items="${services}" var="service">
							<div class="centered">
							<img class="hode" src="assets/img/carrier.png" alt="">
							<h4><c:out value="${service.getService()}"></c:out></h4>
							<p><c:out value="${service.getDescription()}"></c:out> </p>
							<a href=# class="btn btn-default btn-sm">Read More</a>
							<hr style="width:80%;margin-left:10%">
							</div>
						</c:forEach>
						</td>
						
						<td valign="top" style="padding:1% 5% 1% 5%;border-bottom:1px solid #ccc;" class="font_size">
						<h2 style="font-size:20px" class="font_size"><b>EDUCATION:<b></h2>
						<h5 style="font-size:16px;" class="font_size">
									<c:out value="${advisor.getUg()}"/><br>
									<c:out value="${advisor.getPg()}"/><br>
									<c:if test="${!empty advisor.getOthersStringArray()}">
										<c:forEach items="${advisor.getOthersStringArray()}" var="others">
												<c:out value="${others}"/>
										</c:forEach>
									</c:if>
								
						</h5>
						
						</td>
					</tr>
					
					<tr>
						
							<td valign="top" style="padding:1% 5% 1% 5%;border-bottom:1px solid #ccc">
							<h2 style="font-size:20px" class="font_size"><b>PROFESSIONAL BACKGROUND:<b></h2>
							<c:forEach items="${profession}" var="prof">
								<h5 style="font-size:16px;" class="font_size">
								<b><c:out value="${prof.getCompany()}"></c:out>,<c:out value="${prof.getDesignation()}"></c:out></b>
								<br>
								<c:forEach items="${prof.getDescriptionArray()}" var="description">
									<ul>
										<li style="margin-top: 10px"><c:out value="${description}"></c:out>
									</ul>
								</c:forEach>
								</h5>
							</c:forEach>
							</td>
					
					</tr>
					
					<tr>
						<td valign="top" style="padding:1% 5% 1% 5%;border-bottom:1px solid #ccc">
						<h2 style="font-size:20px" class="font_size"><b>SKILLS:<b></h2>
						<h5 style="font-size:16px;" class="font_size">
						<c:forEach items="${advisor.getKeyskills()}" var="skill">
							<ul>
									<li><c:out value="${skill}"/>
							</ul>
						</c:forEach>
						</h5>
						</td>
					</tr>
					
					
						<tr>
							<td valign="top" style="padding:1% 5% 1% 5%;border-bottom:1px solid #ccc">
							<h2 style="font-size:20px" class="font_size"><b>AWARDS AND ACHIEVEMENTS :<b></h2>
					
							<h5 style="font-size:16px;" class="font_size"><br>
							<ul>
							<c:forEach items="${advisor.getAchievementsStringArray()}" var="achievement">
									<li><c:out value="${achievement}"/>
							</c:forEach>
							</ul>
							</h5>
							
							</td>
						</tr>
					
					<tr>
						<td valign="top" style="padding:1% 5% 1% 5%;">
						<h2 style="font-size:20px" class="font_size"><b>KNOW YOUR ADVISOR BETTER :<b></h2>
						<h5 style="font-size:16px;" class="font_size"><c:out value="${advisor.getKnowYourAdvisor()}"/>
						</h5>
						<div style="height:60px"></div>
						<a class="btn btn-primary btn-lg" role="button"><b style="font-size:26px" class="font_size">Book Session</b></a>
						</td>
					</tr>
				</table>
				<!--advisor experience table ends-->
			</c:forEach>
		<div style="height:40px"></div>
		<hr style="width:95%">
			<!--review-->
			<div style="padding:0.01% 5% 5% 5%">
			<h2 style="font-size:26px"><b>REVIEWS</b></h2>
			
			<!-- Comment -->
                <div class="media">
                    <a class="pull-left" href="#">
                        <img class="media-object" src="assets/img/aditya.png" alt="" style="width:64px;height:64px">
                    </a>
                    <div class="media-body">
                        <h2 class="media-heading"> 	
								<b style="font-size:18px">Amie Williams</b>
							<small style="font-size:14px">August 25, 2014 at 9:30 PM</small>
                        </h2>
                      <font style="font-size:15px">
					  Definitely the most professional people I've worked with. I got everything I expected and more. Highly recommended. 
					  </font>
					</div>
                </div>
				
				<hr style="width:70%;margin-left:10%">
				
                <!--2nd Comment -->
                <div class="media">
                    <a class="pull-left" href="#">
                        <img class="media-object" src="assets/img/uday.png" alt="" style="width:64px;height:64px">
                    </a>
                    <div class="media-body">
                        <h2 class="media-heading"> 	
								<b style="font-size:18px">Uday Khatry</b>
							<small style="font-size:14px">August 25, 2014 at 9:30 PM</small>
                        </h2>
                      <font style="font-size:15px">
					  Definitely the most professional people I've worked with. I got everything I expected and more. Highly recommended. 
					  </font> 
                        <!-- Nested Comment 
                        <div class="media">
                            <a class="pull-left" href="#">
                                <img class="media-object" src="http://placehold.it/64x64" alt="">
                            </a>
                            <div class="media-body">
                                <h4 class="media-heading">Nested Start Bootstrap
                                    <small>August 25, 2014 at 9:30 PM</small>
                                </h4>
                                Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                            </div>
                        </div>
                        End Nested Comment -->
                    </div>
                </div>

			</div>
			<!--review ends-->

			<hr style="width:95%">
			
			<div class="row mt centered">
			<div class="col-lg-6 col-lg-offset-3">
				<h2><b>Similar Advisors</b></h2>
			</div>
		</div><!-- /row -->
		
		<div class="row mt centered">
			<div style="margin-left:-4%">
			<div class="col-lg-4">
				<img src="assets/img/aditya.png" style="width:200px;height:150px">
				<h2 style="font-size:22px">Aditya</h2>
				<h4 style="font-size:18px"><b>Chef</b></h4>
				<p>Talk to experts about any kind of career related queries you have for cooking</p>
			</div><!--/col-lg-4 -->

			<div class="col-lg-4">
				<img src="assets/img/uday.png" style="width:200px;height:150px">
				<h2 style="font-size:22px">Uday</h2>
				<h4 style="font-size:18px"><b>Consultant</b></h4>
				<p>I am available for career conversations and mock interviews.</p>

			</div><!--/col-lg-4 -->

			<div class="col-lg-4">
				<img src="assets/img/lavi.png" style="width:200px;height:150px">
				<h2 style="font-size:22px">Lavi</h2>
				<h4 style="font-size:18px"><b>Fashion Designer</b></h4>
				<p>Look good, Otherwise don't show me your face - Fashion </p>

			</div><!--/col-lg-4 -->
			</div>
		</div><!-- /row -->
			
			
	</div>
	</div>
	<!--container ends-->
	
	
	<div class="container">
		<hr>
		<div class="row centered">
			<div class="col-lg-6 col-lg-offset-3">
				<form class="form-inline" role="form">
				  <div class="form-group">
				    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter your email address">
				  </div>
				  <button type="submit" class="btn btn-warning btn-lg">Invite Me!</button>
				</form>					
			</div>
			<div class="col-lg-3"></div>
		</div><!-- /row -->
		<hr>
		<p class="centered">Created by Hemant Katyal - 2014</p>
	</div><!-- /container -->
	

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
	<script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>
  </body>
</html>
