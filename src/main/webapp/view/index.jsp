<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!-- 配置文件 -->
	<script type="text/javascript" src="<%=basePath %>ueditor/ueditor.config.js"></script>
	<!-- 编辑器源码文件 -->
	<script type="text/javascript" src="<%=basePath %>ueditor/ueditor.all.js"></script>

  </head>
  
  <body>
  	<jsp:include page="/view/header.jsp"></jsp:include>
    <div class="main">
		<div class="container"
			style="box-shadow: 0px 1px 5px rgba(0,0,0,.3);margin-top:15px;background-repeat:repeat-y;">
			<div class="row">
				<jsp:include page="/view/left.jsp"></jsp:include>

				<div class="col-xs-10 prn" style="padding-left:0">
					<!-- 我的位置 -->
					<div class="panel panel-default top-div">
						<div class="panel-heading">
							<a style="cursor: default;">快捷服务 </a>
						</div>
						<div class="panel01">
							<!-- <TEXTAREA id="myEditor" name="mycontent" style="width:70%;height:400px;margin-left: 10px;">sssss</TEXTAREA> 
							<SCRIPT type=text/javascript>  
							    var editor = new UE.ui.Editor();  
							    editor.render("myEditor");  
							    //1.2.4以后可以使用一下代码实例化编辑器 
							    //UE.getEditor('myEditor') 
							</SCRIPT> -->
							<!-- <div>
							 <button onclick="insertImg()">插入图片</button>
							</div> -->
						</div>
					</div>

				</div>

			</div>
		</div>
	</div>
  </body>
  <script type="text/javascript">
	function insertImg(){
		alert(editor.getContent());
		editor.setContent(editor.getContent() + "<img src='http://localhost:8080/risksyun/img/logo1.png'></img>");
// 		alert($("#myEditor").html());
// 		$("#myEditor").html($("#myEditor").html()+"<img src='http://localhost:8080/risksyun/img/logo1.png'></img>");
		//$("#myEditor").append('<img src="http://localhost:8080/risksyun/img/logo1.png"></img>');
	}
  </script>
</html>
