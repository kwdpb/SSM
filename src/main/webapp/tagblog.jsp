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
    
    <title>My Record</title>
    <meta http-equiv="content-type"content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/tagblog.css"/>
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
  </head>
  <body>
  	<c:set var="category" value="${requestScope.categoryid}"/>
  	<c:set var="essayquery" value="${requestScope.tagblog.list}"/>
	<c:set var="totalPages" value="${requestScope.tagblog.totalPage}"/>
	<c:set var="page" value="${requestScope.tagblog.pageNum}"/>
	<c:set var="hotblog" value="${requestScope.hotblog}"/>
	<c:set var="newblog" value="${requestScope.newblog}"/>
    <jsp:include page="nav.html" /> <!-- 导入导航栏文件 -->
    <div id="content">
    <div class="article">
    	<c:if test="${empty essayquery}">
	    	<div class="article_div">
				<h3>暂无该标签的博客....</h3>
			</div>
		</c:if>
        <c:forEach var="essay" items="${essayquery}">
        <div class="article_div">
        	<p class="article_font">
        	<a href="<c:url value="/blogcontent.spring?id=${essay.blogId}"/>" class="article_title" >
        	${essay.title}
        	</a> 
        	</p>
        	<hr style="margin-bottom:5px; margin-top:11px">
        	<p class="article_font">
        	<i class="fa fa-list-ul fa-lg"></i>${essay.categoryname}
        	</p>
        	<p class="article_font">
        	<i class="fa fa-calendar-o fa-lg"></i>${essay.pubtime}
        	</p>
        	<p class="article_font">
        	<i class="fa fa-bar-chart fa-lg"></i>${essay.clickrate}
        	</p>
        </div>
        </c:forEach>
        <c:if test="${totalPages>1}">
    	<div class="text-center col-md-12 " >
            <ul class="pagination">
                <li><a href="<c:url value="tagblog.spring?page=1&categoryid=${category}"/>">首页</a></li>
                <li><a href="<c:url value="tagblog.spring?page=${page-1>1?page-1:1}&categoryid=${category}"/>">&laquo;</a></li>
                <c:forEach begin="1" end="${totalPages}" varStatus="loop">
                    <c:set var="active" value="${loop.index==page?'active':''}"/>
                    <li class="${active}"><a
                            href="<c:url value="tagblog.spring?page=${loop.index}&categoryid=${category}"/>">${loop.index}</a>
                    </li>
                </c:forEach>
                <li>
                    <a href="<c:url value="tagblog.spring?page=${page+1<totalPages?page+1:totalPages}&categoryid=${category}"/>">&raquo;</a>
                </li>
                <li><a href="<c:url value="tagblog.spring?page=${totalPages}&categoryid=${category}"/>">尾页</a></li>
            </ul>
  	   </div>
  	   </c:if>
    </div>
    
    <div class="aside">
      <div class="aside-top">
		<div id="news">
        <ul class="list-group" style="max-width:100%;margin-bottom: 0px">
          <li class="list-group-item list-header">
            <i class="fa fa-caret-right"></i>
            <span >最新博客</span>
          </li>
          <c:forEach var="newblog" items="${newblog}" >
          <li class="list-group-item">
            <a href="<c:url value="/blogcontent.spring?id=${newblog.blogId}"/>"><span class="badge pull-right">${newblog.clickrate}</span>
            ${newblog.title}
            </a>
          </li>    
          </c:forEach>       
        </ul>
        </div>
        <div id="hot">
        <ul class="list-group" style="max-width:100%;margin-bottom: 0px">
          <li class="list-group-item list-header">
            <i class="fa fa-caret-right"></i>
            <span >热门博客</span>
          </li>
          <c:forEach var="hotblog" items="${hotblog}" >
          <li class="list-group-item">
            <a href="<c:url value="/blogcontent.spring?id=${hotblog.blogId}"/>"><span class="badge pull-right">${hotblog.clickrate}</span>
            ${hotblog.title}
            </a>
          </li>    
          </c:forEach>  
        </ul>
        </div>
      </div>
    </div>
  	</div> 
  	
  <div class="clear"></div> <!-- 清除浮动 -->
  </body>
</html>
