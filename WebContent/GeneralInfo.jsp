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
</head>
<body>
	
	    		<div id="signupbox1" style=" margin-top:50px" class="mainbox col-md-8 col-sm-8 col-sm-offset-2">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <div class="panel-title" style="font-size:26px">Advisor Registration</div>
                        </div>  
                     <div class="panel-body" >	                         
	    	   			<form id="signupform" class="form-horizontal" role="form" action="AdvisorRegistrationGeneralInfoControler" method="post">
	    			
	                         <div id="part1">
								
								<table style="width:100%;text-align:center;background-color:#f8f8f8;" cellpadding="10">
								<tr>
								<td style="background-color:#E1E1E1"><h5 class="font_size">General Information</h5></td>
								<td><img class="img-responsive" src="assets/img/right.png" alt=""></span></td>
								<td><h5 class="font_size">Education Information</h5></td>
								<td><img class="img-responsive" src="assets/img/right.png" alt=""></td>
								<td><h5 class="font_size">Other Information</h5></td>
								<td><img class="img-responsive" src="assets/img/right.png" alt=""></span></td>
								<td><h5 class="font_size">Professional Background</h5></td>
								<td><img class="img-responsive" src="assets/img/right.png" alt=""></span></td>
								<td><h5 class="font_size">Service Information</h5></td>
								</tr>
								</table>	
								<div style="height:20px"></div>
                                <div class="form-group" id="dfname">
                                    <label for="fname" class="col-md-3 control-label">Name</label>
                                    <div class="col-md-5">
                                        <input id="fname" type="text" class="form-control" name="name" placeholder="Name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="icode" class="col-md-3 control-label">Gender</label>
                                    <div class="col-md-9">
                                        <select class="dropreg" name="gender">
										  <option value="male">male</option>
										  <option value="female">female</option>
										</select>
                                    </div>
                                </div>
								 <div class="form-group" id="dage">
                                    <label for="icode" class="col-md-3 control-label">Age</label>
                                    <div class="col-md-9">
                                        <input id="age" type="text" class="form-control" name="age" placeholder="">
                                    </div>
                                </div>
								
								 <div class="form-group" id="dphone">
                                    <label for="icode" class="col-md-3 control-label">Phone Number</label>
                                    <div class="col-md-9">
                                        <input id="phone" type="text" class="form-control" name="phone" placeholder="" required="required">
                                    </div>
                                </div>
                         			<div class="form-group" id="dcity">
                                    <label for="icode" class="col-md-3 control-label">City</label>
                                    <div class="col-md-9">
                                        <input id="city" type="text" class="form-control" name="city" placeholder="" required="required">
                                    </div>
                                	</div>
                                		<div class="form-group" id="dstate">
                                    <label for="icode" class="col-md-3 control-label">State</label>
                                    <div class="col-md-9">
                                        <input id="state" type="text" class="form-control" name="state" placeholder="" required="required">
                                    </div>
                                	</div>
                                	
                             	 <div class="form-group" id="dnation">
                                    <label for="icode" class="col-md-3 control-label">Nationality</label>
                                    <div class="col-md-9">
                                        <input id="nation" type="text" class="form-control" name="nationality" placeholder="">
                                    </div>
                                </div>
                                
                            	<div class="form-group" id="dindustry">
                                    <label for="icode" class="col-md-3 control-label">Industry</label>
                                    <div class="col-md-9">
                                        <input id="industry" type="text" class="form-control" name="industry" placeholder="">
                                    </div>
                                </div>
                                <h4>Current Occupation</h4>
                                <hr>
								
								<div class="form-group" id="dorg">
									<label for="icode" class="col-md-3 control-label">Name of Organisation</label>
                                    <div class="col-md-9">
                                        <input id="org" type="text" class="form-control" name="organisation" placeholder="">
                                    </div>
                                </div>
								
								<div class="form-group" id="djob">
									<label for="icode" class="col-md-3 control-label">Job Title</label>
                                    <div class="col-md-9">
                                        <input id="job" type="text" class="form-control" name="job" placeholder="">
                                    </div>
                                </div>
                                <div class="form-group" id="drelindus">
									<label for="icode" class="col-md-3 control-label">Experience in Relevant Industry(Years)</label>
                                    <div class="col-md-9">
                                        <input id="relindus" type="text" class="form-control" name="experience" placeholder="">
                               		 </div>
                                </div>
                                <div class="form-group">
                                    <!-- Button -->                                        
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="btn-signup" type="submit" class="btn btn-info">Submit and Continue</button>
                                    </div>
                                </div>
                            </div>
                             <div style="float: right;padding-bottom: 0px">
                             	<img alt="123" style="height: 250px;width: 300px;" src="assets/img/logo_black.png">
                             </div>                    	
                      </form>
                   </div>
                 </div>
                </div>
</body>
<script src="assets/js/jquery-1.11.0.js"></script>
<script type='assets/js/jquery.min.js'></script>
<script>
	$(document).ready(function() {
			<!--Name can't be blank-->
			$("#btn-signup").click(function(event){
				var input_n = $("#fname").val();
				if (input_n==''){
					$("#dfname").addClass("has-error");
					event.preventDefault(); 
				}	
				else{
					$("#dfname").removeClass("has-error");
				}
			});
			<!--age can't be blank-->
			$("#btn-signup").click(function(event){
				var input_a = $("#age").val();
				var filter = /^[0-9-+]+$/;
				var is_age = filter.test(input_a)
				if (!is_age){
					$("#dage").addClass("has-error");
						event.preventDefault();
				}else{
					$("#dage").removeClass("has-error");
				}	
			});
			<!--phone can't be blank-->
			$("#btn-signup").click(function(event){
				var input_p = $("#phone").val();
				var filter = /^\d{10}$/; 
				var is_phone = filter.test(input_p)
				if (!is_phone){
					$("#dphone").addClass("has-error");
						event.preventDefault();
				}else{
					$("#dphone").removeClass("has-error");
				}	
				
			});
			<!--city can't be blank-->
			$("#btn-signup").click(function(event){
				var input_city = $("#city").val();
				if (input_city==''){
					$("#dcity").addClass("has-error");
					event.preventDefault(); 
				}	
			});
			
			<!--city can't be blank-->
			$("#btn-signup").click(function(event){
				var input_city = $("#state").val();
				if (input_city==''){
					$("#dstate").addClass("has-error");
					event.preventDefault(); 
				}	
			});
			
			<!--nation can't be blank-->
			$("#btn-signup").click(function(event){
				var input_city = $("#nation").val();
				if (input_city==''){
					$("#dnation").addClass("has-error");
					event.preventDefault(); 
				}else{
					$("#dnation").removeClass("has-error");
				}		
			});
			<!--industry can't be blank-->
			$("#btn-signup").click(function(event){
				var input_city = $("#industry").val();
				if (input_city==''){
					$("#dindustry").addClass("has-error");
					event.preventDefault(); 
				}else{
					$("#dindustry").removeClass("has-error");
				}		
			});
			<!--organisation can't be blank-->
			$("#btn-signup").click(function(event){
				var input_city = $("#org").val();
				if (input_city==''){
					$("#dorg").addClass("has-error");
					event.preventDefault(); 
				}	
			});
			<!--job can't be blank-->
			$("#btn-signup").click(function(event){
				var input_city = $("#job").val();
				if (input_city==''){
					$("#djob").addClass("has-error");
					event.preventDefault(); 
				}else{
					$("#djob").removeClass("has-error");
				}	
			});
			<!--relindus can't be blank-->
			$("#btn-signup").click(function(event){
				var input_city = $("#relindus").val();
				var filter = /^[0-9-+]+$/;
				var is_city = filter.test(input_city)
				if (input_city==''){
					$("#drelindus").addClass("has-error");
					event.preventDefault(); 
				}else{
					$("#drelindus").removeClass("has-error");
				}		
			});
		});	
	</script>
</html>