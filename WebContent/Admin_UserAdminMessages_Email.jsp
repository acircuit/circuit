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
    <title>Admin</title>
	<style type="text/css"> 
		.bdesign{font-size:20px !important;}
		.dropreg{height:30px;width:40%;}
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
		`<div id="Review" style="margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
              <div class="panel panel-info">
  				
                   <div class="panel-body" >
                   		 <form id="Message_form" class="form-horizontal" role="form" action="AdminMyAccountUserAdvisorMessagesController" method="post">
		                           
		                            <div class="panel-heading">
		                         			<div class="panel-title" style="font-size:26px">Enter Session Id to View Review
		                        			</div>
		               				</div>
		                					<hr>
		                           <div class="form-group">
		                               <label for="icode" class="col-md-3 control-label">SessionId</label>
		                                <div class="col-md-9">
							 				<input type="text" name="sessionid" class="form-control" placeholder="Enter session ID">
						 				</div>
		                           </div>			                           				
		                           <div class="form-group">
		                               <!-- Button -->                                        
		                               <div class="col-md-offset-3 col-md-9">
		                                   <button id="btn" type="Submit" class="btn btn-info">Submit</button>
											<!--<button id="btn" type="submit" class="btn btn-info">Cancel</button>	-->
		                               </div>
		                           </div>
		                       </form>
                    </div>
                 </div> 
         </div> 
</body>
 <script src="assets/js/jquery-1.11.0.js"></script>
</html>