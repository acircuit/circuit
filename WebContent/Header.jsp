<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <% 
			Boolean isLoggedIn=false;
			String username="";
				if(session.getAttribute("userId") !=null || session.getAttribute("advisorId") !=null ){
					isLoggedIn=true;
					username=(String)session.getAttribute("username");
				}else if(session.getAttribute("admin") != null && session.getAttribute("admin").equals("true")){
					isLoggedIn=true;
					username = "Admin";
				}
				pageContext.setAttribute("isLoggedIn", isLoggedIn);
		%>
    <!-- Fixed navbar -->
    <div class="navbar navbar-default">
    	<c:if test="<%=!isLoggedIn %>">
			<a href="Login.jsp"><h4 style="font-size:18px;color:#575758;float:right;margin-right:1.5%">Login/Sign Up</h4></a>
			</br>
			<h5 style="font-size:18px;color:#F35940;float:right;margin-right:-7%">We are here to help</h5>		
		</c:if>
		
		<div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#" style="padding-top:18%;"><img src="assets/img/logo-black.png" style="width:120px;height:60px"></a>
        </div>
         
        <div style="height:40px"></div>

        <div class="navbar-collapse collapse" style="border-bottom:2px solid #636262;">
          <ul class="nav navbar-nav">
		    <li><a href="Home.jsp"><h4 style="color:#575758;font-size:18px">Home</h4></a></li>
            <li><a href="AboutUs.jsp"><h4 style="color:#575758;font-size:18px">About Us</h4></a></li>
            <li><a href="#"><h4 style="color:#575758;font-size:18px">Services</h4></a></li>
            <li><a href="#"><h4 style="color:#575758;font-size:18px">Advisors</h4></a></li>
            <li><a href="BecomeAdvisor.jsp"><h4 style="color:#575758;font-size:18px">Become an Advisor</h4></a></li>
			<li><a href="ContactUs.jsp"><h4 style="color:#575758;font-size:18px">Contact Us</h4></a></li>
			<c:if test="<%=isLoggedIn %>">
			<li><a><h4 style="color:#575758;font-size:18px"><%=username%>'s Account</h4></a></li>
			<li><a href="LogoutController"><h4 style="color:#575758;font-size:18px">Logout</h4></a></li>
			</c:if>
			<li>
			<form class="" role="form" action="SearchController" method="post">
				<div class="input-group" style="padding-left: 46.5%;padding-top:2%">
				<input type="text" class="form-control" name="search" placeholder="Search site..." style="height:35px">
					 <span class="input-group-btn">
					 <button class="btn btn-default" type="submit" style="height:35px"><i class="glyphicon glyphicon-search" style="color:#555;top:-3px"></i>
					 </button> 
					 </span>
				 </div>
			</form>
			</li>
          </ul>
        </div><!--/.nav-collapse -->
        </div>