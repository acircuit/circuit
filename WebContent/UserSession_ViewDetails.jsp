<!DOCTYPE html>
<%@page import="org.AC.dto.UserRequestDTO"%>
<%@page import="org.AC.dto.SessionDTO"%>
<%@page import="org.AC.dto.UserDetailsDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>View Details Session</title>

    <!-- Bootstrap Core CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
	<link href="../assets/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
	
    <!-- MetisMenu CSS -->
    <link href="assets/css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="assets/css/sb-admin-2.css" rel="stylesheet">
	<!--<link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">-->
	<!-- Custom styles for this template -->
    
    <!-- Fonts from Google Fonts -->
	<link href='http://fonts.googleapis.com/css?family=Lato:300,400,900' rel='stylesheet' type='text/css'>
	
    <!-- Custom Fonts -->
    <link href="assets/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	<style type="text/css"> 
		.bdesign{font-size:20px !important;}
		.dropreg{height:30px;width:40%;}
		input[type="text"]{height:40px !important}
		.add-on{height:40px !important;cursor:pointer !important}
		.control-label{width:130px !important}
	</style>	
		<%
		String advisorname = (String)request.getAttribute("advisorname");
		String username = (String)request.getAttribute("userName");
		String image = (String)request.getAttribute("image");
		String uId = (String)request.getAttribute("uId");
		String time = (String)request.getAttribute("time");
		String date = (String)request.getAttribute("date");
		Boolean fromCancelledSession = false;
		Boolean fromPreviousSession = false;
		String sessionDate = (String)request.getAttribute("sessionDate");
		List<UserRequestDTO> requests = (List<UserRequestDTO>)request.getAttribute("requests");
		List<SessionDTO> sessions = (List<SessionDTO>)request.getAttribute("sessions");
		List<UserDetailsDTO> userdetails = (List<UserDetailsDTO>)request.getAttribute("userdetails");	
		fromCancelledSession = (Boolean)request.getAttribute("isFromCancelledSession");
		fromPreviousSession = (Boolean)request.getAttribute("isFromPreviousSession");
		pageContext.setAttribute("requests", requests);
		pageContext.setAttribute("sessions", sessions);
		pageContext.setAttribute("userdetails", userdetails);
		pageContext.setAttribute("advisorname", advisorname);
		pageContext.setAttribute("username", username);
		pageContext.setAttribute("image", image);
		pageContext.setAttribute("time", time);
		pageContext.setAttribute("date", date);
		pageContext.setAttribute("fromCancelledSession", fromCancelledSession);
		pageContext.setAttribute("fromPreviousSession", fromPreviousSession);

		%>
</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="dashboard.html"><b style="font-size:30px">Advisor </b><b style="font-size:30px;color:#000;font-family: Arial">Circuit</b></a>
            </div>
            <!-- /.navbar-header -->

            <div id="topnav">
			<%@ include file="topnav.jsp" %>            
			</div>

			<div id="j_sidebar">
			<%@ include file="j-sidebar_user.jsp" %>
			</div>
        </nav>
       
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header"><%=username %></h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
		<c:forEach items="${requests}" var="request">
			<div class="row">    
				<div class="col-lg-8">
					<div id="signupbox" class="mainbox">
							<div class="panel panel-info">
								<div class="panel-heading" style="background-color:#f8f8f8">
									<div class="panel-title" style="font-size:26px">Details </div>   
								</div>  
					<div class="col-md-5">
						<img style="width:60%;padding:3% 1% 1% 5%;float:right" src="<%=image %>" alt="">
					</div>
					
					<div class="col-md-7" style="text-align:left">
						<h3>With <%=advisorname%></h3>
						<p>Type : <b><c:out value="${request.getService()}"/></b></p>
					</div>
					
						<div style="height:170px"></div>
						
								<div class="panel-body" >
									<form id="signupform" class="form-horizontal" role="form" action="AdvisorMyAccountSessionViewDetailsFormController" >
										
										<div id="signupalert" style="display:none" class="alert alert-danger">
											<p>Error:</p>
											<span></span>
										</div>
										<h4>SCHEDULED FOR</h4>
										<hr>	
										<div class="form-group">
											
												<div class="col-md-10">
													<table class="table table-striped table-hover">
													<tr><th>Time</td><td>:</td><td><%=time %></td></tr>
													<tr><th>Date</td><td>:</td><td><%=date %></td></tr>
													<tr><th>Duration</td><td>:</td><td><c:out value="${request.getDuration()}"></c:out>Hour </td></tr>
													<tr><th>Countdown</td><td>:</td><td><c:out value="${request.getDays()}"/> Day <c:out value="${request.getHours()}"/> Hour  <c:out value="${request.getMinutes()}"/> Minutes To Go</td></tr>
												</table>
												</div>
										</div>
										<hr>
										
										<div class="form-group">
													<label for="icode" class="col-md-1 control-label">Mode </label>
													<label for="icode" class="col-md-3 control-label" style="text-align:left"><c:out value="${request.getMode()}"/></label>
												
										</div>
										
										<div class="form-group">
											<label for="icode" class="col-md-3 control-label">Session Query</label>
											<div class="col-md-9">
												<textarea class="form-control" rows="3"  readonly="readonly"><c:out value="${request.getQuery()}"/></textarea>
											</div>
										</div>
										<c:forEach items="${sessions}" var="session">
											<div class="form-group">
												<label for="icode" class="col-md-3 control-label">Session Plan</label>
												<div class="col-md-9">
													<textarea class="form-control" rows="3" readonly="readonly"><c:out value="${session.getSessionPlan()}"/></textarea>
												</div>
											</div>	
											<input type="hidden" id="sId" value="${session.getSessionId()}" name="sId" >			
										</c:forEach>
										<div style="height:10px"></div>
										<c:if test="${(!fromPreviousSession && !fromCancelledSession)}">
											<h4><a data-toggle="modal" data-target="#messageadvisor" onclick="getmessages()">Message Admin</a>
											</h4>
											<h4>
											<a data-toggle="modal" data-target="#uploadfile" onclick="getFiles()">Upload Files</a>
											</h4>
										</c:if>
										<hr>
									
										<div id="collapseOne" class="panel-collapse collapse">
											 
										</div>
										
											</div>
											
										</div>
										
									</form>
								 </div>
							</div> 
				 </div> 
				 </c:forEach>
			</div>
			<div class="modal fade" id="messageadvisor" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">Message User</h4>
						</div>
						<div class="modal-body">
							<div id="page-wrapper1">
				            <div class="row">
				                <div class="col-lg-12">
				                    <h1 class="page-header">Message</h1>
				                </div>
				                <!-- /.col-lg-12 -->
				            </div>
				            <!-- /.row -->
				            <div class="row">
				                    <div class="chat-panel panel panel-default">
				                        <div class="panel-heading">
				                            <i class="fa fa-comments fa-fw"></i>
				                            Message
										</div>
				                        <!-- /.panel-heading -->
				                        
				                        <div  class="panel-body">
				                      	  <ul id="message" class='chat'>

				                           </ul> 
				                        </div>
				                        <form >
					                        <!-- /.panel-body -->
					                        <div class="panel-footer">
					                            <div class="input-group">
					                                <input  id ="usermessage" type="text" class="form-control input-sm" name="usermessage" placeholder="Type your message here..." />
					                                <span class="input-group-btn">
					                                <input type="button" onclick="setmessage()" class="btn btn-warning btn-sm" id="btn-chat" value="Send">	
					                                </span>
					                            </div>
					                        </div>
				                        </form>
				                        <!-- /.panel-footer -->
				                    </div>
				                    <!-- /.panel .chat-panel -->
				           		 </div>
				            <!-- /.row -->
				        		</div>
						
						
						</div>						
					</div>
				</div>
			</div>
						<div class="modal fade" id="uploadfile" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">Files</h4>
						</div>
						<div class="modal-body">
							<form id="uploadform" class="form-horizontal" role="form" enctype="multipart/form-data"  method="post">
	    			
							<div id="part2">
								<h4>Uploaded Files :</h4>
								<div id="uploadedfiles">
									
								</div>
                                <hr>
                                <div class="form-group">
                                    <label for="icode" class="col-md-3 control-label">Upload Files</label>
                                    <div id = "fileupload" class="col-md-9">
										<input type="file" id="uploadFile" name="file" required="required">
										<p class="help-block"></p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="icode" class="col-md-3 control-label">Purpose</label>
                                    <div id = "filepurpose" class="col-md-9">
										<input type="text" id="purpose" onchange="checkFile()" name="purpose" required="required">
										<p class="help-block"></p>
                                    </div>
                                </div>
                                <div id="response">
                                </div>
								<hr>
								 <div class="form-group">
                                    <!-- Button -->                                        
                                    <div class="col-md-offset-3 col-md-9">
                                    	<input id="btn-signup" type="button" onclick="setfile()" class="btn btn-info" value="Submit">
                                    </div>
                                </div>
							 </div><!--part2-->	
                     </form>
						</div>						
					</div>
				</div>
			</div>
        </div>    
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery Version 1.11.0 -->
    <script src="assets/js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="assets/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="assets/plugins/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="assets/js/sb-admin-2.js"></script>
	<script src="../assets/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript">
      $('#datetimepicker1').datetimepicker({
        format: 'dd/MM/yyyy hh:mm:ss',
        language:'en'
      });
	  $('#datetimepicker2').datetimepicker({
        format: 'dd/MM/yyyy hh:mm:ss',
        language:'en'
      });
	  $('#datetimepicker3').datetimepicker({
        format: 'dd/MM/yyyy hh:mm:ss',
        language:'en'
      });
	   $('#datetimepicker4').datetimepicker({
        format: 'dd/MM/yyyy hh:mm:ss',
        language:'en'
      });
	  $('#datetimepicker5').datetimepicker({
        format: 'dd/MM/yyyy hh:mm:ss',
        language:'en'
      });
	  $('#datetimepicker6').datetimepicker({
        format: 'dd/MM/yyyy hh:mm:ss',
        language:'en'
      });
	  function getmessages(){
		  alert($("#sId").val());
		  $.ajax({
              url : 'SessionMessagesController', // Your Servlet mapping or JSP(not suggested)
              data : {"sId" : $("#sId").val(),"user":true},
              type : 'POST',
              dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
              success : function(response) {
            	  alert(response);
            	  $('#message').html(response);
              },
              error : function(request, textStatus, errorThrown) {
                  alert(errorThrown);
              }
          }); 	
  }
	  function setmessage(){
		  var val = $("#usermessage").val();
			  $.ajax({
	              url : 'SessionMessagesController', // Your Servlet mapping or JSP(not suggested)
	              data : {"sId" : $("#sId").val(),"message" : val,"advisor":false},
	              type : 'POST',
	              dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
	              success : function(response) {
	            	  flag = response;
	              },
	              error : function(request, textStatus, errorThrown) {
	            	  flag = false;
	                  alert(errorThrown);
	              }
	          }); 
			  getmessages();
	  }
	  function getFiles(){
		  $.ajax({
              url : 'SessionFileController', // Your Servlet mapping or JSP(not suggested)
              data : {"sId" : $("#sId").val(),"getFile" : true,"advisor":false},
              type : 'POST',
              dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
              success : function(response) {
            	  $('#uploadedfiles').html(response);
              },
              error : function(request, textStatus, errorThrown) {
                  alert(errorThrown);
              }
          }); 	
	  }
	  function setfile(){
		  var formData = new FormData();
		  formData.append("myFile", document.getElementById("uploadFile").files[0]);
		  formData.append("sId",$("#sId").val());
		  formData.append("purpose",$("#purpose").val());
		  formData.append("fromUser",true);
		  var xhr = new XMLHttpRequest();
		  xhr.open("POST", "SessionFileController");
		  xhr.send(formData);
		  xhr.onreadystatechange=function()
		  {
		  if (xhr.readyState==4 && xhr.status==200)
		    {
		    document.getElementById("response").innerHTML=xhr.responseText;
		    getFiles();
		    }
		  }
	  }
    </script>
    <!-- Page-Level Demo Scripts - Notifications - Use for reference -->
    <script>
    // tooltip demo
    $('.tooltip-demo').tooltip({
        selector: "[data-toggle=tooltip]",
        container: "body"
    })

    // popover demo
    $("[data-toggle=popover]")
        .popover()
    </script>

</body>

</html>
