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
    
    <title>文章管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=GBK"/>
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="css/font-awesome-4.7.0/css/font-awesome.min.css"/>
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
  </head>
  
  <body>
  	<c:if test="${empty sessionScope.username}">
  			<c:redirect url="login.html"></c:redirect>
  	</c:if>
  	<c:set var="username" value="${sessionScope.username}"/>
	<c:set var="essayquery" value="${requestScope.essayquery.list}"/>
	<c:set var="totalPages" value="${requestScope.essayquery.totalPage}"/>
	<c:set var="totalblog" value="${requestScope.essayquery.totalRecord}"/>
	<c:set var="page" value="${requestScope.essayquery.pageNum}"/>
	<div class="col-md-12">
		<div class="col-md-12">
			<ol class="breadcrumb">
			<li>用户:${username}</li>
			<li><i class="fa fa-book"></i><a href="editorblog.jsp" target="_blank">写文章</a></li>
			<li><a href="register.html" target="_blank">添加用户</a></li>
			<li><a href="AllUser.spring">用户管理</a></li>
			<li><a href="AllBlog.spring">博客管理</a></li>
			<li><a href="cancel.spring">注销</a></li>
			</ol>
		</div>
	</div>
  	<div class="col-md-offset-1 col-md-10 ">
	    <table class="table table-striped  table-hover table-condensed">
	    	<thead>
	    	<tr>
	    		<th>文章名</th>
	    		<th>详情</th>
	    		<th>类别</th>
	    		<th>操作</th>
	    	</tr>
	    	</thead>
	    	<tbody>
	    	<c:forEach var="essay" items="${essayquery}">
	    	<tr>
	    		<td>${essay.title}</td>
	    		<td><a href="blogcontent.spring?id=${essay.blogId}" target="_blank">详情</a></td>
	    		<td>${essay.categoryname}</td>
	    		<td><a href="delete_blog.spring?id=${essay.blogId}" class="detele"><i class="fa fa-trash-o"></i></a></td>
	    	</tr>
	    	</c:forEach>
	    	</tbody>
	    </table>
    </div >
    <div class="col-md-offset-1 col-md-10" >
            <ul class="pagination">
                <li><a href="<c:url value="/AllBlog.spring?page=1&categoryid=${category}"/>">首页</a></li>
                <li><a href="<c:url value="/AllBlog.spring?page=${page-1>1?page-1:1}&categoryid=${category}"/>">&laquo;</a></li>
                <c:forEach begin="1" end="${totalPages}" varStatus="loop">
                    <c:set var="active" value="${loop.index==page?'active':''}"/>
                    <li class="${active}">
                    	<a href="<c:url value="/AllBlog.spring?page=${loop.index}&categoryid=${category}"/>">${loop.index}</a>
                    </li>
                </c:forEach>
                <li>
                    <a href="<c:url value="/AllBlog.spring?page=${page+1<totalPages?page+1:totalPages}&categoryid=${category}"/>">&raquo;</a>
                </li>
                <li><a href="<c:url value="/AllBlog.spring?page=${totalPages}&categoryid=${category}"/>">尾页</a></li>
            </ul>
  	</div>
  	<script>
		$(function(){
				/* getcate();	 */
				
				$(".detele").click(function(){
					return confirm("确认删除该文章吗？");
				});
		});
		
/* 		function getcate(){  //取得后台类别数据 
			$.getJSON("categorytype.do",function(data){
				var type=$("#category");
				var array=data;
				for(var i=0;i<array.length;i++)
				{
						type.append("<option value='"+array[i].id+"'>"+array[i].name+"</option>");
				}
			});
		} */
		
		function delete_blog(){  /* 弹出确认框 */
			if(confirm("是否删除"))
			 	return true;
			else
				return false;
		}
	</script>
  </body>
</html>
