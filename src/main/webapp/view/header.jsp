<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.xj.pojo.PlaUser" %>
<%@ page import="com.alibaba.fastjson.JSONArray" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
	PlaUser plaUser = (PlaUser) session.getAttribute("userinfo");
    if(plaUser == null){
        plaUser = new PlaUser();
    }
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Bootstrap 实例 - 默认的导航栏</title>
	<link rel="stylesheet" href="<%=basePath %>css/bootstrap.min.css">
	<%-- <link rel="stylesheet" type="text/css" href="<%=basePath %>css/main.css"> --%>
	<link rel="stylesheet" href="<%=basePath %>css/userMain.css">
	<link rel="stylesheet" href="<%=basePath %>css/style.css">
	<link rel="stylesheet" href="<%=basePath %>css/public.css">
	<link rel="stylesheet" href="<%=basePath %>css/bootstrap-datetimepicker.css">
	<link rel="stylesheet" href="<%=basePath %>css/bootstrap-switch.css">
	
	<script type="text/javascript" src="<%=basePath %>js/jquery-3.1.0.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/jquery.json.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/bootstrap-datetimepicker.fr.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/bootstrap-datetimepicker.js"></script> 
	<script type="text/javascript" src="<%=basePath %>js/bootstrap-switch.js"></script>  
	<script type="text/javascript" src="<%=basePath %>js/page_init.js"></script> 
	
	<style type="text/css">
		.navbar-nav{
		    float:right;
		}
		
		.navbar-nav li a{
		    width: 100px !important;
		}
		.container { width: 90%; max-width: none !important; }
	</style>
</head>
<body>

<nav class="navbar navbar-default" role="navigation" style="background-color: #FFF;">
	<div class="container-fluid">
	<div class="navbar-header">
		<img style="height: 50px;width: 120px;" src="<%=basePath %>img/logo1.png">
		<!-- <a class="navbar-brand" href="#">后台管理</a> -->
	</div>
	<div>
		<ul class="nav navbar-nav" style="margin-right: 50px;padding: 3px 10px;" id="headBtn">
			<li ><a id="login_user"></a></li>
			<li id="updpwd_btn" style="display: none;"><a href="<%=basePath %>view/userUpdatePwd.jsp">修改密码</a></li>
			<li id="logout" style="display: none;"><a href="<%=basePath %>logout">退出登陆</a></li>
		</ul>
	</div>
	</div>
</nav>

</body>
<script>
    $().ready(function(){
        var user_name = "<%=plaUser.getPlaUserName() == null ? "" : plaUser.getPlaUserName() %>";
        if(user_name != null && user_name != ""){
            $("#logout").show();
            $("#updpwd_btn").show();
            $("#login_user").append(user_name);
        }
        
    	$('#datetimepicker').datetimepicker({
    		format:'yyyy-mm-dd',
            autoclose:true,//自动关闭
            minView:2, //最精准的时间选择为日期0-分 1-时 2-日 3-月 
            weekStart:0
        });  
    	
    	$('#datetimepicker1').datetimepicker({
    		format:'yyyy-mm-dd',
            autoclose:true,//自动关闭
            minView:2, //最精准的时间选择为日期0-分 1-时 2-日 3-月 
            weekStart:0
        });  
    })
   
    
</script>
</html>