<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>文章编辑</title>
    <meta http-equiv="content-type"content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script>
		$(function(){
			getType();
			
		});
	
	
		function getType(){  //取得后台分类数据 
			$.getJSON("type.spring",function(data){
				var type=$("#category");
				var array=data;
				for(var i=0;i<array.length;i++)
				{
						type.append("<option value='"+array[i].id+"'>"+array[i].name+"</option>");
				}
		});
		} 
	</script>
  </head>
<body>
    <form action="insertblog.spring" method="post">
    <h3>标题:<input type="text" name="title" style="height:25px;" autocomplete="off"/></h3>
    <h3>类别:
	    <select name="categoryid" id="category" style="height:25px;">

	    </select>
    </h3>
    <div id="editor">
        
    </div>
    <textarea id="text1" style="display:none;" name="content"></textarea>
    <button id="upload" style="margin-top:1em;">发布博客</button>
    </form>
    <!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
    <script type="text/javascript" src="wangEditor-3.1.0/release/wangEditor.min.js"></script>
    <script type="text/javascript">
        var E = window.wangEditor;
        var editor = new E('#editor');
        var $text1=$("#text1");
        editor.customConfig.onchange = function (html) {
            // 监控变化，同步更新到 textarea
            $text1.val(html);
        };
        editor.customConfig.debug = true; //开启debug模式
        editor.customConfig.uploadImgServer = 'upload.spring';
        editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024;
        editor.customConfig.uploadImgMaxLength = 5;    
        editor.customConfig.uploadFileName = 'myFileName';
        editor.customConfig.uploadImgHooks={
            customConfig:function(insertImg,result,editor){
                var url= result.url;
                insertImg(url);
            }
        };

        editor.create();
    </script>
</body>
</html>
