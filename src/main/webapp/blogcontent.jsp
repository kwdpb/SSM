<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="blog" value="${requestScope.blogcontent}"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>${blog.title}</title>
    <meta http-equiv="content-type" content="text/html;charset=GBK"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<link  type="text/css" href="css/blogcontent.css" rel="stylesheet"/>
	<script>
	$(function(){
		$.ajax({
			type:"get",
			url:"pageview.spring",
			data:{blogid:$("#blog").val()},
			error:function(request){
				alert("connect error");
			}
		});
	});
  </script>
  </head>
  <body>
    <input type="hidden" value="${blog.blogId}" id="blog"/>
  	<jsp:include page="nav.html" />
  	<c:set var="feedback" value="${feedback}"></c:set>

    <div id="content">
      <div id="blogcontent">
        <div id="blogcenter">
        	
            <div class="detail">
            	<div class="detail-title">
            		<h2>${blog.title}</h2>
            	</div>
            	<div class="detail-text">
					     ${blog.content}
            	</div>
            </div>
            <c:forEach var="fk" items="${feedback}">
            <div id="comment">
               <div class="comment-img">
					<img src="images/sky.jpg" />
               </div>
               <div class="comment-con">
                  <p class="lead">${fk.f_name}</p>
                  <p class="small "><i class="fa fa-clock-o"></i>${fk.f_time}</p>
                  <p class="comment-detail">${fk.f_content}</p>
               </div>
            </div>
            <hr>
            </c:forEach>
       </div>
        <div id="aside">
          
        </div>
      </div>
    </div>

    <div id="fix-btn">
      <a href="#" class="go-up" title="回到顶部"><i class="fa fa-angle-up"></i></a>
      <a href="#" class="thumb" title="点赞博客"><i class="fa fa-thumbs-o-up"></i></a>
      <a href="#" class="feedback" title="评论"><i class="fa fa-comment-o"></i></a>
      <a href="#" class="wechat" title="微信分享"><i class="fa fa-weixin"></i></a>
      <a href="#" class="sina" title="新浪分享"><i class="fa fa-weibo"></i></a>
      <a href="#" class="qq" title="QQ分享"><i class="fa fa-qq"></i></a>
    </div>
    
  </body>
</html>
