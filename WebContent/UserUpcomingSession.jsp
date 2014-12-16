<!DOCTYPE html>
<%@page import="org.AC.dto.UserRequestDTO"%>
<%@page import="org.AC.dto.AdvisorProfileDTO"%>
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

    <title>Upcoming Sessions</title>

    <!-- Bootstrap Core CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
 

    <!-- MetisMenu CSS -->
    <link href="assets/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="assets/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="assets/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <%
		List<AdvisorProfileDTO> advisordetails = (List<AdvisorProfileDTO>)request.getAttribute("advisordetails");
		List<UserRequestDTO> userRequestDetails = (List<UserRequestDTO>)request.getAttribute("requests");
		int sessionId = (Integer)request.getAttribute("sId");
		pageContext.setAttribute("userRequestDetails", userRequestDetails);
		pageContext.setAttribute("advisordetails", advisordetails);
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
                    <h1 class="page-header">Upcoming Sessions</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
			
		<c:choose>
		  <c:when test="${advisordetails.size() > 0 && userRequestDetails.size() > 0}">
		      <c:forEach items="${advisordetails}" var="advisor">
				<c:forEach items="${userRequestDetails}" var="request">
					<c:if test="${advisor.getAdvisorId() == request.getAdvisorId()}">			
					<!-- Blog Post Row -->
			        <div class="row" style="background-color:#f8f8f8">
			  			<input type="hidden" name="rId" value="request.getRequestId()">
			            <div class="col-md-8">
			                <h3><c:out value="${advisor.getName()}"/></h3>
			                <p>Type : <b><c:out value="${request.getService()}"/></b>
			                </p>
			                <p><c:out value="${request.getQuery()}"/></p>
			                <c:url value="/UserMyAccountUpcomingSessionViewDetailController" var="myURL">
							   			<c:param name="rId" value="${request.getRequestId()}"/>
							</c:url>
			                <a class="btn btn-primary" href="${myURL}">View Details <i class="fa fa-angle-right"></i></a>
			                <c:if test="${request.getDays() > 0 && request.getHours() > 0 && request.getMinutes() > 0 }">
			              		<a class="btn btn-primary" onclick="div_show()" href="">Review the advisor <i class="fa fa-angle-right"></i></a>
			              	</c:if>			                
			            </div>
			            <div class="col-md-4">
			                <h3>Time Left For Session</h3>
			                <p class="btn btn-primary" style="margin-bottom: 50px"><c:out value="${request.getDays()}"/> Day <c:out value="${request.getHours()}"/> Hour  <c:out value="${request.getMinutes()}"/> Minutes</p>
			                <ul class="list-unstyled list-inline list-social-icons">
			                    <li>
			                        <a href="#"><i class="fa fa-facebook-square fa-2x"></i></a>
			                    </li>
			                    <li>
			                        <a href="#"><i class="fa fa-linkedin-square fa-2x"></i></a>
			                    </li>
			                    <li>
			                        <a href="#"><i class="fa fa-twitter-square fa-2x"></i></a>
			                    </li>
			                    <li>
			                        <a href="#"><i class="fa fa-google-plus-square fa-2x"></i></a>
			                    </li>
			                </ul>
           				 </div>
           				 <c:if test="${request.getDays() > 0 && request.getHours() > 0 && request.getMinutes() > 0 }">
					 	     <div class="col-md-8">
	                            <label for="icode" class="col-md-3 control-label">Recommend :</label>
	                            <a onclick="recommend()"><img alt="" src="assets/img/Icon_Advisor.png" width="30px" height="30px"></a>
	                        </div>
                        </c:if>
              			<div style="font: bold;" class="col-md-8" id = "recommendation">
                        </div>
			        </div>
			        <hr>
	        		<!-- /.row -->
	        		<div id="review" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
               		   <div class="panel panel-info">
							<div class="panel-body" >
                                <form action="">
	                                 <div class="panel-heading">
			                            <div class="panel-title" style="font-size:26px">
			                            	 <b>Review Your Advisor</b>
			                            	<img alt="" id="close" onclick="div_hide()" src="assets/img/close.png" style="float: right; ">
		                            	</div>
                    				</div>
                      					<hr>
	                      			 <c:if test="${request.getDays() > 0 && request.getHours() > 0 && request.getMinutes() > 0 }">
		                                <div class="form-group">
		                                    <label for="icode" class="col-md-3 control-label">Review Message</label>
		                                     <div class="col-md-9">
		                                     		<textarea rows="3" id="reviewmessage" name="reviewmessage" class="form-control"></textarea>
											 </div>
		                                </div>             	
		                                <div style="font: bold;" class="col-md-8" id = "reviews">
	                        			</div>
		                              </c:if> 				
	                                <div class="form-group">
	                                    <!-- Button -->                                        
	                                    <div class="col-md-offset-3 col-md-9">
	                                        <button id="btn" type="Submit" onclick="review()" class="btn btn-info">Submit</button>
											<!--<button id="btn" type="submit"  class="btn btn-info">Cancel</button>	-->
	                                    </div>
	                                </div>
	                             </form>
	                         </div>
             			</div> 
      					 </div>
     				</c:if>
				</c:forEach>
			</c:forEach>
 
		</c:when>
		<c:otherwise>
			<c:out value="YOU HAVE NO UPCOMING SESSIONS"></c:out>
		</c:otherwise>
		</c:choose>
					
            
        </div>
        <!-- /#page-wrapper -->
        
    </div>
    <!-- /#wrapper -->

    <!-- jQuery Version 1.11.0 -->
    <script src="assets/js/jquery-1.11.0.js"></script>
   
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>

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
		function div_show() {
			document.getElementById('review').style.display = "block";
		}
		function div_hide(){
			document.getElementById('review').style.display = "none";
		}
		function recommend(){
			 $.ajax({
	                url : 'Recommendation', // Your Servlet mapping or JSP(not suggested)
	                data : {"sId" :<%=sessionId%>},
	                type : 'POST',
	                dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
	                success : function(response) {
	                    $('#recommendation').html(response); // create an empty div in your page with some id
	                },
	                error : function(request, textStatus, errorThrown) {
	                    alert(errorThrown);
	                }
	            }); 
		}
		function review(){
			$.ajax({
                url : 'Recommendation', // Your Servlet mapping or JSP(not suggested)
                data : {"sId" :<%=sessionId%>,"review":"true","reviewmessage": $("#reviewmessage").val()},
                type : 'POST',
                dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
                success : function(response) {
                	alert(response);
                    $('#reviews').html(response); // create an empty div in your page with some id
                },
                error : function(request, textStatus, errorThrown) {
                    alert(errorThrown);
                }
            }); 
			
			
		}
	</script>
</body>

</html>
