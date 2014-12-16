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
	<% 		
			Boolean isRecommended =(Boolean)request.getAttribute("Recommendation");
			String ReviewMessage =(String)request.getAttribute("ReviewMessage");
			String sId =(String)request.getAttribute("sId");

	%>
</head>
<body>
		`<div id="Review" style="margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
              <div class="panel panel-info">
  				
                   <div class="panel-body" >
                   		<c:choose>
                   			<c:when test="${ReviewMessage == null}">
		                       <form id="Review_form" class="form-horizontal" role="form" action="AdminMyAccountReviewController" method="post">
		                           
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
                            </c:when>
                            <c:otherwise>
		                      		<div class="form-group">
		                      		   <label for="icode" class="col-md-3 control-label">Review Message</label>
		                               <div class="col-md-offset-3 col-md-9">
		                                   <p class="form-control"><%=ReviewMessage%></p>
		                               </div>
		                          </div>
		                          <div class="form-group">
		                      		   <label for="icode" class="col-md-3 control-label">Is Recommended</label>
		                               <div class="col-md-offset-3 col-md-9">
		                                   <input class="form-control" value="<%=isRecommended%>">
		                               </div>
		                          </div>
		                          <div class="form-group">
		                               <div class="col-md-offset-3 col-md-9">
		                                   <a class="btn btn-info" onclick="approvereview()">Approve</a>
		                               </div>
		                          </div>
		                           <div class="form-group">
		                               <div class="col-md-offset-3 col-md-9" id="approve">
		                               </div>
		                          </div>
                           </c:otherwise>
                          </c:choose>
                    </div>
                 </div> 
         </div> 
</body>
 <script src="assets/js/jquery-1.11.0.js"></script>
<script type="text/javascript">
function approvereview(){
	$.ajax({
	    url : 'AdminMyAccountReviewController', // Your Servlet mapping or JSP(not suggested)
	    data : {"approve" : "true","sId" :<%=sId%>},
	    type : 'POST',
	    dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
	    success : function(response) {
	        $('#approve').html(response); // create an empty div in your page with some id
	    },
	    error : function(request, textStatus, errorThrown) {
	        alert(errorThrown);
	    }
	}); 
}
</script>
</html>