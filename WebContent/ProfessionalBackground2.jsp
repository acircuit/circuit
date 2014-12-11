<!DOCTYPE html>
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

    <title>Advisor Registration</title>
	<style type="text/css"> 
		.img-responsive{width:28px !important} 
		.bdesign{font-size:20px !important;}
		.dropreg{height:30px;width:40%;}
		.font_size{font-size:16px !important;}
		@media only screen and (max-width:700px){
		.font_size{font-size:12px !important;}
		}
		@media only screen and (min-width: 320px) and (max-width: 470px) {
		.bdesign{font-size:14px !important;}
		.font_size{font-size:12px !important;}
		}
		
		@media only screen and (min-width: 470px) and (max-width: 700px) {
		.bdesign{font-size:14px !important;}
		.font_size{font-size:12px !important;}
		}
		 </style>  		 
    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="assets/css/main.css" rel="stylesheet">

    <!-- Fonts from Google Fonts -->
	<link href='http://fonts.googleapis.com/css?family=Lato:300,400,900' rel='stylesheet' type='text/css'>
	<script src="assets/js/jquery-1.11.0.js"></script>
	
</head>
<body>
	
	    		 <div id="signupbox1" style=" margin-top:50px" class="mainbox col-md-8 col-sm-8 col-sm-offset-2">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <div class="panel-title" style="font-size:26px">Advisor Registration</div>
                        </div>  
                     <div class="panel-body" >	                         
	    	   			<form id="signupform" class="form-horizontal" role="form" action="AdvisorRegistrationProfessionalBackgroundControler" method="post">
	    			
				<div id="part4">	
							<table style="width:100%;text-align:center;background-color:#f8f8f8;" cellpadding="10">
								<tr>
								<td><h5 class="font_size">General Information</h5></td>
								<td><img class="img-responsive" src="assets/img/right.png" alt=""></span></td>
								<td><h5 class="font_size">Education Information</h5></td>
								<td><img class="img-responsive" src="assets/img/right.png" alt=""></td>
								<td><h5 class="font_size">Other Information</h5></td>
								<td><img class="img-responsive" src="assets/img/right.png" alt=""></span></td>
								<td style="background-color:#E1E1E1"><h5 class="font_size">Professional Background</h5></td>
								<td><img class="img-responsive" src="assets/img/right.png" alt=""></span></td>
								<td><h5 class="font_size">Service Information</h5></td>
								</tr>
								</table>
							<h4>Professional Background</h4>
								<hr>
								<div id ="ProfessionalBackground">
								
									<div class="form-group" id="dcompany0">
										<label for="icode" class="col-md-3 control-label">Company</label>
	                                    <div class="col-md-5">
	                                        <input id="company" type="text"  class="form-control" name="company[]" placeholder=""> 
										</div>	
										<div class="col-md-2">
	                                         <button type="button" class="btn btn-default" data-container="body" data-toggle="popover" data-placement="right" data-content="JWT Delhi">
									   		<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> </button> 
	                               		</div>
                                	</div>
                                	<div class="form-group" id="dduration">
										<label for="icode"  class="col-md-3 control-label">Duration</label>
	                                    <div class="col-md-5">
	                                        <input id="duration" type="text" class="form-control" name="duration[]" placeholder="">
										</div>
										<div class="col-md-2">	
	                                        <button type="button" class="btn btn-default" data-container="body" data-toggle="popover" data-placement="right" data-content="2009- current">
									   		<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> </button>   
	                               		</div>
                                	</div>
                                	<div class="form-group" id="ddesignation0">
										<label for="icode" class="col-md-3 control-label">Designation</label>
	                                    <div class="col-md-5">
	                                        <input id="designation" type="text" class="form-control" name="designation[]" placeholder="">
										</div>
										<div class="col-md-2">	
	                                        <button type="button" class="btn btn-default" data-container="body" data-toggle="popover" data-placement="right" data-content="Vice President">
									   		<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> </button>   
	                               		</div>
                                	</div>
                                	 <div class="form-group" id="ddescription0">
										<label for="icode" class="col-md-3 control-label">Description</label>
	                                    <div class="col-md-5">
	                                        <textarea id="description" class="form-control" name="description[]" rows="3"></textarea>
											</div>
										<div class="col-md-2">
	                                        <button type="button" class="btn btn-default" data-container="body" data-toggle="popover" data-placement="right" data-content="Manage and develop newspaper, magazine and internet advertising for existing and new accounts while building and cultivating client relations by continually updating my knowledge of the ever-changing media and market.Assist with the clients advertising strategy, ad message and creative development.Consistently grew business and established strong relationships with clients.">
									   		<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> </button>  
	                               		</div>
                                	</div>
                                	<div class="col-md-6">
									<a href="#ProfessionalBackground" id="add-profession" class="add-profession">Add More Professional Background</a>
                                    </div>
									<div style="height:40px"></div>
									</div>
									<hr>
	                                <div class="form-group">
	                                    <!-- Button -->                                        
	                                    <div class="col-md-offset-3 col-md-9">
	                                        <button id="btn-signup" type="submit" class="btn btn-info">Submit and Continue</button>
	                                    </div>
	                                </div>
							</div><!--part4-->	
                     </form>
                   </div>
                 </div>
                 </div>
                 
              <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
	<script>
    // popover demo
    $("[data-toggle=popover]")
        .popover()
    </script>
	<script>
      $(function () { $('.popover-show').popover('show');});
      $(function () { $('.popover-hide').popover('hide');});
      $(function () { $('.popover-destroy').popover('destroy');});
      $(function () { $('.popover-toggle').popover('toggle');});
     $(function () { $(".popover-options a").popover({html : true });});
   </script>
   <script type='assets/js/javascript' src='jquery.min.js'></script>
	 <script src="http://code.jquery.com/jquery-1.10.2.js"></script>	
		<script>
		$(document).ready(function() {
		<!--under can't be blank-->
			$("#btn-signup").click(function(event){	
				var arr = [];
				$( "input[name^='company[]']" ).each(function(){
					   arr.push(this.value);
					});
				var max_fields = 10;
				var i =0;
				while(i<10)
				{
					if (arr[i]==''){
						//alert("you have not filled "+i+" box");
						$("#dcompany"+i).addClass("has-error");
						event.preventDefault(); 
					}	
					else{
						$('#dcompany'+i).removeClass("has-error");
					}
					i++;
				}
				
			});
			
			<!--designation can't be blank-->
			$("#btn-signup").click(function(event){	
				var arr = [];
				$( "input[name^='designation[]']" ).each(function(){
					   arr.push(this.value);
					});
				var max_fields = 10;
				var i =0;
				while(i<10)
				{
					if (arr[i]==''){
						//alert("you have not filled "+i+" box");
						$("#ddesignation"+i).addClass("has-error");
						event.preventDefault(); 
					}	
					else{
						$('#ddesignation'+i).removeClass("has-error");
					}
					i++;
				}
				
			});
			
			<!--description can't be blank-->
			$("#btn-signup").click(function(event){	
				var arr = [];
				$( "input[name^='description[]'],textarea" ).each(function(){
					   arr.push(this.value);
					});
				var max_fields = 10;
				var i =0;
				while(i<10)
				{
					if (arr[i]==''){
						alert("you have not filled "+i+" box");
						$("#ddescription"+i).addClass("has-error");
						event.preventDefault(); 
					}	
					else{
						$('#ddescription'+i).removeClass("has-error");
					}
					i++;
				}
				
			});
			<!--duration can't be blank-->
			$("#btn-signup").click(function(event){
				var input_city = $("#duration").val();
				if (input_city==''){
					$("#dduration").addClass("has-error");
					event.preventDefault(); 
				}	
				else{
					$("#dduration").removeClass("has-error");
				}
			});
			
		});		
		</script>
		<script type="text/javascript">
 function div_hide() {
	 document.getElementById('professional').style.display = "none";
}
 </script>

</body>
</html>