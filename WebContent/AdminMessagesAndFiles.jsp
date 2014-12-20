<!DOCTYPE html>
<%@page import="org.AC.dto.FilesDTO"%>
<%@page import="org.AC.dto.AdvisorMessageDTO"%>
<%@page import="org.AC.dto.UserMessageDTO"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Messages & Files</title>

    <!-- Bootstrap Core CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
	
    <!-- MetisMenu CSS -->
    <link href="assets/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">

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
	<%	   		List<UserMessageDTO> usermessages= (List<UserMessageDTO>)request.getAttribute("usermessages");
				List<AdvisorMessageDTO> advisormessages= (List<AdvisorMessageDTO>)request.getAttribute("advisormessages");
				List<FilesDTO> files= (List<FilesDTO>)request.getAttribute("files");
	   			pageContext.setAttribute("usermessages", usermessages);
	   			pageContext.setAttribute("advisormessages", advisormessages);
				pageContext.setAttribute("files", files);

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
			<%@ include file="j-sidebar_admin.jsp" %>
			</div>
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Messages & Files</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
			
			<div class="row">    
				<div class="col-lg-10">
							<div class="panel">
								<div class="panel-body" >
						
										<div class="col-md-12">
													<table style="text-align:center" class="table">
														<tr><th style="text-align:center">Type</th><th style="text-align:center">By</th><th style="text-align:center">Time</th><th style="text-align:center">Message/File</th><th style="text-align:center">Comment</th><th style="text-align:center">Status</th></tr>
														<c:forEach var="message" items="${usermessages}">
															<tr><td>MESSAGE</td><td>USER</td><td style="text-align: left"><c:out value="${message.getUserMessageTimeString()}"></c:out></td><td><c:out value="${message.getUserMessage()}"></c:out></td><td></td>
															<c:choose>
																<c:when test="${message.getStatus().equals('APPROVED')}">
																	<td>APPROVED</td>
																</c:when>
																<c:when test="${message.getStatus().equals('REJECTED')}">
																	<td>REJECTED</td>
																</c:when>
																<c:otherwise>
																	<td>
																	<button id="usermessagebtn" type="Submit" class="btn btn-info" onclick="SetUserMessageApproval()" value="${message.getMessageId()}">APPROVE</button>
																	OR
																	<button id="usermessagebtn" type="Submit" class="btn btn-info" onclick="SetUserMessageCancellation()" value="${message.getMessageId()}">REJECT</button>	
																	<div id="usermessage">
																		</div>																
																	</td>														
																</c:otherwise>
															</c:choose>
															</tr>
														</c:forEach>
														<c:forEach var="message" items="${advisormessages}">
															<tr><td>MESSAGE</td><td>ADVISOR</td><td><c:out value="${message.getAdvisorMessageTimeString()}"></c:out></td><td><c:out value="${message.getAdvisorMessage()}"></c:out></td><td></td>
															<c:choose>
																<c:when test="${message.getStatus().equals('APPROVED')}">
																	<td>APPROVED</td>
																</c:when>
																<c:when test="${message.getStatus().equals('REJECTED')}">
																	<td>REJECTED</td>
																</c:when>
																<c:otherwise>
																	<td>
																	<button id="advisormessagebtn" type="Submit" class="btn btn-info" onclick="SetAdvisorMessageApproval()" value="${message.getMessageId()}">APPROVE</button>
																	OR
																	<button id="advisormessagebtn" type="Submit" class="btn btn-info" onclick="SetAdvisorMessageCancellation()" value="${message.getMessageId()}">REJECT</button>	
																	<div id="advisormessage">
																		</div>																
																	</td>															
																</c:otherwise>
															</c:choose>
															</tr>
														</c:forEach>				
														<c:forEach var="file" items="${files}">
															<tr><td>FILE</td><td><c:out value="${file.getUploadedBy()}"></c:out></td><td><c:out value="${file.getTimeString()}"></c:out></td><td><a href="${file.getHref()}">${file.getFileName()}</a></td><td><c:out value="${file.getComment()}"></c:out></td>
															<c:choose>
																<c:when test="${file.getStatus().equals('APPROVED')}">
																	<td>APPROVED</td>
																</c:when>
																<c:when test="${file.getStatus().equals('REJECTED')}">
																	<td>REJECTED</td>
																</c:when>
																<c:otherwise>
																	<td><button id="filebtn" type="Submit" class="btn btn-info" onclick="SetFileApproval()" value="${file.getId()}">APPROVE</button>
																		OR
																		<button id="filebtn" type="Submit" class="btn btn-info" onclick="SetFileCancellation()" value="${file.getId()}">REJECT</button>
																		<div id="filemessage">
																		</div>
																	</td>														
																</c:otherwise>
															</c:choose>
															
															</tr>
														</c:forEach>
														
													</table>
												<div class="modal fade" id="datepay" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
												<div class="modal-dialog modal-lg">
													<div class="modal-content">
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
															<h4 class="modal-title" id="myModalLabel">More Details</h4>
														</div>
														<div class="modal-body">
															<table style="text-align:center" class="table table-hover">
															<tr><th style="text-align:center">Date</th>
															<th style="text-align:center">Service</th><th style="text-align:center">Username</th>
															<th style="text-align:center">Duration</th>
															<th style="text-align:center">Status</th>
															<th style="text-align:center">Amount</th>
															<th style="text-align:center">Discount</th>
															</tr>
															<tr><td>24th November</td>
															<td>Career Talk</td>
															<td>Hemant Katyal</td>
															<td>1 Hour</td>
															<td>Confirmed</td>
															<td>Rs.2400</td>
															<td>Rs.400</td>
															</tr>
															</table>
														</div>
													</div><!-- /.modal-content -->
												</div><!-- /.modal-dialog -->
											</div><!-- /.modal -->
											
											<div style="height:40px"></div>
											
												<div class="col-md-6">
													<table class="table">
												
												</table>
												</div>
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
    <script type="text/javascript">
	function SetFileApproval(){
		var val = $('#filebtn').val();
		$.ajax({
            url : 'AdminSessionMessagesAndFileController', // Your Servlet mapping or JSP(not suggested)
            data : {"fileId" : val,"status" : "APPROVED"},
            type : 'POST',
            dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
            success : function(response) {
          	  $('#filemessage').html(response);
            },
            error : function(request, textStatus, errorThrown) {
                alert(errorThrown);
            }
        }); 	
	}
	function SetFileCancellation(){
		var val = $('#filebtn').val();
		$.ajax({
            url : 'AdminSessionMessagesAndFileController', // Your Servlet mapping or JSP(not suggested)
            data : {"fileId" : val,"status" : "REJECTED"},
            type : 'POST',
            dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
            success : function(response) {
          	  $('#filemessage').html(response);
            },
            error : function(request, textStatus, errorThrown) {
                alert(errorThrown);
            }
        }); 	
	}
	function SetUserMessageApproval(){
		var val = $('#usermessagebtn').val();
		$.ajax({
            url : 'AdminSessionMessagesAndFileController', // Your Servlet mapping or JSP(not suggested)
            data : {"userMessageId" : val,"status" : "APPROVED"},
            type : 'POST',
            dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
            success : function(response) {
          	  $('#usermessage').html(response);
            },
            error : function(request, textStatus, errorThrown) {
                alert(errorThrown);
            }
        }); 	
	}
	function SetUserMessageCancellation(){
		var val = $('#usermessagebtn').val();
		$.ajax({
            url : 'AdminSessionMessagesAndFileController', // Your Servlet mapping or JSP(not suggested)
            data : {"userMessageId" : val,"status" : "REJECTED"},
            type : 'POST',
            dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
            success : function(response) {
          	  $('#usermessage').html(response);
            },
            error : function(request, textStatus, errorThrown) {
                alert(errorThrown);
            }
        }); 	
	}
	function SetAdvisorMessageApproval(){
		var val = $('#advisormessagebtn').val();
		$.ajax({
            url : 'AdminSessionMessagesAndFileController', // Your Servlet mapping or JSP(not suggested)
            data : {"advisorMessageId" : val,"status" : "APPROVED"},
            type : 'POST',
            dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
            success : function(response) {
          	  $('#advisormessage').html(response);
            },
            error : function(request, textStatus, errorThrown) {
                alert(errorThrown);
            }
        }); 	
	}
	function SetAdvisorMessageCancellation(){
		var val = $('#advisormessagebtn').val();
		$.ajax({
            url : 'AdminSessionMessagesAndFileController', // Your Servlet mapping or JSP(not suggested)
            data : {"advisorMessageId" : val,"status" : "REJECTED"},
            type : 'POST',
            dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
            success : function(response) {
          	  $('#advisormessage').html(response);
            },
            error : function(request, textStatus, errorThrown) {
                alert(errorThrown);
            }
        }); 	
	}
	</script>
</body>

</html>
