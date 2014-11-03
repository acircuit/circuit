<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="assets/img/favicon.png">

    <title>Advisor</title>
	<style type="text/css"> 
		.bdesign{font-size:20px !important;}
		
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
			<form class="" role="form" action="SearchController" method="post">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search" name="search"  >
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

	<div id="headerwrap">
		<div class="container">	
			<div class="row">
				<table width="100%" border="0">
				<tr>
				<td class="" style="border-color:#fff;padding:1% 2% 1% 25%">
				<h2><b style="background-color:#ccc;text-align:center;padding:8px 8px 4px 8px" class="bdesign">Give wings to your career</b></h2></td><td></td>
				</tr>
				
				<tr>
				<td style="border-left:10px;border-bottom:10px;border-color:#fff;padding:1% 2% 1% 20%">
				<h2><b class="bdesign" style="background-color:#ccc;text-align:center;font-size:20px;padding:8px 8px 4px 8px">Book a session</b></h2></td><td></td>
				</tr>
				
				<tr>
				<td style="border-left:10px;border-bottom:10px;border-color:#fff;padding:1% 2% 1% 12%">
				<h2><b class="bdesign" style="background-color:#ccc;text-align:center;font-size:20px;padding:8px 8px 4px 8px">Search for advisor</b></h2></td>
				<td style="padding:1% 0 1% 10%"><h2><b class="bdesign" style="background-color:#ccc;text-align:center;font-size:20px;padding:8px 8px 4px 8px">Become an Advisor</b></h2></td>
				</tr>
				</table>
				
			</div><!-- /row -->
		</div><!-- /container -->
	</div><!-- /headerwrap -->

<div class="container" style="padding-top:2%">
	<div class="centered">
		<div class="flex-video widescreen"><iframe width="80%" height="400"
										src="http://www.youtube.com/embed/kEkNITP3WYI">
										</iframe></div>
	</div>	
</div>
	
	<div class="container">
		<div class="row mt centered">
			<div class="col-lg-6 col-lg-offset-3">
				<h1>Our Services</h1>
			</div>
		</div><!-- /row -->
		
		<div class="row mt centered">
			<div class="col-lg-4">
				<img src="assets/img/APJ.jpg" width="180" alt="">
				<h4>Career Conversation</h4>
				<p>Talk to experts about any kind of career related queries you have</p>
			</div><!--/col-lg-4 -->

			<div class="col-lg-4">
				<img src="assets/img/DP.jpg" width="180" alt="">
				<h4>Mock Interview</h4>
				<p>Experience a mock interview before actually going for the real one</p>

			</div><!--/col-lg-4 -->

			<div class="col-lg-4">
				<img src="assets/img/DP.jpg" width="180" alt="">
				<h4>CV Critique</h4>
				<p>Get your cv critiqued by </br>experienced professionals</p>

			</div><!--/col-lg-4 -->
			
			<div class="col-lg-4">
				<img src="assets/img/ga.png" width="180" alt="">
				<h4>E Mentoring</h4>
				<p>Get mentored by the best in the industry</p>

			</div><!--/col-lg-4 -->
			
			<div class="col-lg-4">
				<img src="assets/img/ac.jpg" width="180" alt="">
				<h4>Startup Mentoring</h4>
				<p>Are you a startup looking for guidance ? Here's your oppurtunity</p>

			</div><!--/col-lg-4 -->
			<div class="col-lg-4">
				<img src="assets/img/grp.jpg" width="180" alt="">
				<h4>Personal Workshops</h4>
				<p>Get one on one workshops on various topics</p>

			</div><!--/col-lg-4 -->
		</div><!-- /row -->
	</div><!-- /container -->
	
	
	<div class="container">
		<hr>
		<div class="row centered">
	<h1 class="font_size">Find your advisor on the basis of occupation, area of expertise etc</h1>
			<div class="col-lg-6 col-lg-offset-3">
				<div style="width:100%;">
			<form class="" role="form">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search here">
							 <span class="input-group-btn">
							 <button class="btn btn-default" type="button" style="height:42px"> Go </button> 
							 </span>
					 </div>
					</form>
					</div>					
			</div>
			<div class="col-lg-3"></div>
		</div><!-- /row -->
		<hr>
	</div><!-- /container -->

	<div class="container">
		<div class="row mt centered">
			<div class="col-lg-6 col-lg-offset-3">
				<h1>Featured Advisors</h1>
			</div>
		</div><!-- /row -->
		
		<div class="row mt centered">
			<div class="col-lg-4">
				<img class="img-circle" src="assets/img/lavi.PNG" width="140" alt="">
				<h4>Lavi</h4>
				<p>I am available for career conversations and mock interviews. </p>
				<p><i class="glyphicon glyphicon-send"></i> <i class="glyphicon glyphicon-phone"></i> <i class="glyphicon glyphicon-globe"></i></p>
			</div><!--/col-lg-4 -->

			<div class="col-lg-4">
				<img class="img-circle" src="assets/img/aditya.png" width="140" alt="">
				<h4>Aditya Raina</h4>
				<p>I am available for career conversations, cv critique and e mentoring</p>
				<p><i class="glyphicon glyphicon-send"></i> <i class="glyphicon glyphicon-phone"></i> <i class="glyphicon glyphicon-globe"></i></p>
			</div><!--/col-lg-4 -->

			<div class="col-lg-4">
				<img class="img-circle" src="assets/img/uday.png" width="140" alt="">
				<h4>Uday Khatry</h4>
				<p>I am available for personal workshops and e mentoring</p>
				<p><i class="glyphicon glyphicon-send"></i> <i class="glyphicon glyphicon-phone"></i> <i class="glyphicon glyphicon-globe"></i></p>
			</div><!--/col-lg-4 -->
		</div><!-- /row -->
	</div><!-- /container -->
	
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
  </body>
</html>
