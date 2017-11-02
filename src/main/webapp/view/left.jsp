<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.xj.pojo.PlaUser" %>
<%@ page import="com.alibaba.fastjson.JSONArray" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	PlaUser plaUser = (PlaUser) session.getAttribute("userinfo");
    if(plaUser == null){
        plaUser = new PlaUser();
    }
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

<style type="text/css">
.list-group-item {
	background-color: #ededf0;
}
</style>

</head>

<body>
	<div style="padding:0px;" class="col-xs-2 prn">
					<div class="panel01 panel-default userInfo" style="box-shadow:0;background-color: #1180e2;">
						<ul class="nav nav-tabs" style="height:40px;">
							<!--  用户类型名称判断 -->
							<li><a style="font-weight: bold;">个人用户</a></li>
						</ul>
						<div class="panel-body nopd" style="min-height: 600px;background-color:#EDEDF0;" id="leftDiv">

							<!-- 个人普通用户 -->
							<ul class="list-unstyled list-group  mbn text-center fontM"
								 id="headBtngroup">
								

							</ul>

						</div>
					</div>
				</div>
	
</body>
<script type="text/javascript">
$().ready(function(){
	var divHeight = $("#fieldDiv").height();
	$("#leftDiv").height(divHeight);
	
    var user_name = "<%=plaUser.getPlaUserName() == null ? "" : plaUser.getPlaUserName() %>";
    
    //权限节点加载
    var plafunList = <%=JSONArray.toJSON(plaUser.getPlafunList())%>;
    var funName = "";
    for(var i =0; i<plafunList.length; i++){
    	funName = plafunList[i].funName;
    	if(funName == "userManage"){
    		$("#headBtngroup").append("<li class='list-group-item '><a href='<%=basePath %>userList'>账号管理</a></li>");
    	}else if(funName == "groupManage"){
    		$("#headBtngroup").append("<li class='list-group-item '><a href='<%=basePath %>groupList'>用户组管理</a></li>");
	    }else if(funName == "signleEnterprise"){
    		$("#headBtngroup").append("<li class='list-group-item '><a href='<%=basePath %>signleEnterpriseList.do'>单个企业管理</a></li>");
	    }else if(funName == "regEconomics"){
    		$("#headBtngroup").append("<li class='list-group-item '><a href='<%=basePath %>regEconomicsMainList.do'>区域经济管理</a></li>");
	    }else if(funName == "industryData"){
    		$("#headBtngroup").append("<li class='list-group-item '><a href='<%=basePath %>industryDataList.do'>行业数据</a></li>");
	    }
    }
})
</script>
</html>
