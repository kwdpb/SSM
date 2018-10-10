<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Kwdpb&My record</title>
    <meta http-equiv="content-type"content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
	<link rel="stylesheet" href="css/baguetteBox.min.css">
	<link rel="stylesheet" href="css/gallery-clean.css">
  </head>
  <body>
  <jsp:include page="nav.html" />
  <div class="container gallery-container">
		    <h1>Record</h1>
		    <p class="page-description text-center">personal programming record</p>
		    <div class="tz-gallery">

		        <div class="row">

		            <div class="col-sm-6 col-md-4">
		                <div class="thumbnail">
		                    <a class="lightbox" href="images/park.jpg">
		                        <img src="images/park.jpg" alt="Park">
		                    </a>
		                    <div class="caption">
		                        <h3>Thumbnail label</h3>
		                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
		                    </div>
		                </div>
		            </div>
		            <div class="col-sm-6 col-md-4">
		                <div class="thumbnail">
		                    <a class="lightbox" href="images/bridge.jpg">
		                        <img src="images/bridge.jpg" alt="Bridge">
		                    </a>
		                    <div class="caption">
		                        <h3>Thumbnail label</h3>
		                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
		                    </div>
		                </div>
		            </div>
		            <div class="col-sm-6 col-md-4">
		                <div class="thumbnail">
		                    <a class="lightbox" href="images/tunnel.jpg">
		                        <img src="images/tunnel.jpg" alt="Tuneel">
		                    </a>
		                    <div class="caption">
		                        <h3>Thumbnail label</h3>
		                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
		                    </div>
		                </div>
		            </div>
		            <div class="col-sm-6 col-md-4">
		                <div class="thumbnail">
		                    <a class="lightbox" href="images/coast.jpg">
		                        <img src="images/coast.jpg" alt="Coast">
		                    </a>
		                    <div class="caption">
		                        <h3>Thumbnail label</h3>
		                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
		                    </div>
		                </div>
		            </div>
		            <div class="col-sm-6 col-md-4">
		                <div class="thumbnail">
		                    <a class="lightbox" href="images/rails.jpg">
		                        <img src="images/rails.jpg" alt="Rails">
		                    </a>
		                    <div class="caption">
		                        <h3>Thumbnail label</h3>
		                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
		                    </div>
		                </div>
		            </div>
		            <div class="col-sm-6 col-md-4">
		                <div class="thumbnail">
		                    <a class="lightbox" href="images/traffic.jpg">
		                        <img src="images/traffic.jpg" alt="Traffic">
		                    </a>
		                    <div class="caption">
		                        <h3>Thumbnail label</h3>
		                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
		                    </div>
		                </div>
		            </div>
		        </div>
		    </div>
  </div>
  	<script type="text/javascript" src="js/baguetteBox.min.js"></script>
	<script type="text/javascript">
		baguetteBox.run('.tz-gallery');
	</script>
  </body>
</html>
