<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="assets/img/favicon.png">

    <title>Contact Us</title>
	<style type="text/css"> 
		@font-face {
			font-family:"custom_light";
			src: url("assets/fonts/NGCDMC__.TTF") /* EOT file for IE */
		}
		
		@font-face {
			font-family:"custom_bold";
			src: url("assets/fonts/NGCDBC__.TTF") /* TTF file for CSS3 browsers */
		}

		h1,h2,h3,h5{
			font-family:'custom_bold' !important;
			}
			
		h4{ font-family:'custom_light' !important;
			font-size:19px !important;
			}	
		p{font-family:'custom_light' !important;}
		
		video {  
        width:100%;  
        height:650px;  
        position: relative;  
			}
		body{color:#fff !important;}
		.fa-lg{font-size:1.2em !important;}
		.bdesign{font-size:20px !important;}
		.social{padding-bottom:9px !important;}
		.foot-size{font-size:14px !important;}
		.foot-color{color:#717171;}
		@media only screen and (max-width:700px){
		.font_size{font-size:22px !important;}
		}
		@media only screen and (min-width: 320px) and (max-width: 470px) {
		.bdesign{font-size:14px !important;}
		.font_size{font-size:22px !important;}
		}
		
		@media only screen and (min-width: 470px) and (max-width: 700px) {
		.bdesign{font-size:14px !important;}
		.font_size{font-size:22px !important;}
		}
		 </style>  		 
    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="assets/css/main.css" rel="stylesheet">

    <!-- Fonts from Google Fonts -->
	<link href='http://fonts.googleapis.com/css?family=Lato:300,400,900' rel='stylesheet' type='text/css'>
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  
  </head>

  <body>

  <div style="margin-left:5.9%;margin-right:5.9%">
  		<%@include file="/Header.jsp" %>
		<!--main container(middle)-->
		<div style="background-color:#FDBE41">
			
			<h1 class="centered" style="color:#555;padding-top:2%;padding-bottom:3%">We would love to hear from you!</h1>
			<div class="row">
				
					<div class="col-md-6 col-lg-offset-1">
						<div class="col-md-4 centered">
							<img  src="assets/img/Icon_Call.png" width="45" alt="">
							<h4 style="color:#555"><b>Call Us</b></h4>
							<h5 style="color:#f8f8f8;font-size:18px">+91 99998 28839</h5>
						</div>
						<div class="col-md-4 centered">
							<img  src="assets/img/Icon_Mail.png" width="45" alt="">
							<h4 style="color:#555"><b>Mail Us</b></h4>
							<h5 style="color:#f8f8f8;font-size:18px">contactus@advisorcircuit.com</h5>
						</div>
					</div>
					
					<div class="col-md-5">
						<div class="col-md-2" style="width:14%">
							<img  src="assets/img/Icon_FB.png" width="45" alt="">
						</div>
						<div class="col-md-2" style="width:14%">
							<img  src="assets/img/Icon_Twitter.png" width="45" alt="">
						</div>
						<div class="col-md-2" style="width:14%">
							<img  src="assets/img/Icon_LinkedIn.png" width="45" alt="">
						</div>
						<div class="col-md-2" style="width:14%">
							<img  src="assets/img/Icon_Google.png" width="45" alt="">
						</div>
						<div class="col-md-7 centered">
						<h4 style="color:#555"><b>Advisor Circuit @ social media</b></h4>
						</div>
					</div>
				
			</div>
			<div class="row centered">
				<h4 style="color:#555;padding-top:3%;padding-bottom:1%"><b>Drop in a message and we will get back to you in no time!</b></h4>
			</div>
			
			<div>
				  <form role="form" method="post" action="ContactUsController">
                        <div class="row">
							<div class="col-lg-6">
								<div class="form-group col-lg-12">
									<label>Name</label>
									<input type="text" name="name" class="form-control">
								</div>
								<div class="form-group col-lg-12">
									<label>Email Address</label>
									<input type="email" name="email" class="form-control">
								</div>
								<div class="form-group col-lg-12">
									<label>Phone Number</label>
									<input type="tel" name="phone" class="form-control">
								</div>
							</div>
                           
                            <div class="form-group col-lg-6">
                                <label>Message</label>
                                <textarea class="form-control" rows="7" style="width:95% !important;" name="message"></textarea>
                            </div>
                            <div class="form-group col-lg-11">
                                <input type="hidden" name="save" value="contact">
                                <button type="submit" class="btn" style="float:right;margin-right:-6.8%;border-radius:0px;width:7%;height:35px;background-size:cover;background-image:url('assets/img/Icon_Send.png')">
								</button>
                            </div>
                        </div>
                    </form>
			</div>
		</div>
	<!--end-->
	
	
		<div style="height:40px"></div>
			
		<%@include file="/Footer.jsp" %>
		
		</div>
		<!--footer ends--->
			
	</div>
	<!--main container-->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
  </body>
</html>
