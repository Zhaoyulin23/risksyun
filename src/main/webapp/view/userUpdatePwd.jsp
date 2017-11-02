<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'user_context.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<!-- 配置文件 -->
<script type="text/javascript"
	src="<%=basePath%>ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript"
	src="<%=basePath%>ueditor/ueditor.all.js"></script>
</head>

<body>
	<jsp:include page="/view/header.jsp"></jsp:include>
	<div class="main">
		<div class="container"
			style="box-shadow: 0px 1px 5px rgba(0,0,0,.3);margin-top:15px;background-repeat:repeat-y;background-color: #ededf0;">
			<div class="row">
				<jsp:include page="/view/left.jsp"></jsp:include>

				<div class="col-xs-10 prn" style="padding-left:0">
					<!-- 我的位置 -->
					<div class="panel panel-default top-div">
						<div class="panel-heading">
							<a style="cursor: default;">快捷服务 </a>
						</div>
						<div class="panel01">
							<div class="col-xs-12">
								<div style="margin-top:50px;">
									<form action="<%=basePath%>updatePwd" method="post"
										onsubmit="return doVaild()">
									<div class="col-xs-10 col-xs-offset-2">
								<div class="form-group" style="margin-top:5px;text-align: right;">
									<div class="col-xs-9" style="padding-left:0px;">
										<label class="col-xs-3 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">密码
										</label> 
											 <div class="col-xs-6"> <input type="password" name="plaUserPwd" id="plaUserPwd"
													class="form-control" /></div>
											<div class="col-xs-3" id="error_msg" style="color:red;"></div>
									</div>
									
									<div class="col-xs-9 mtm" style="padding-left:0px;">
										<label class="col-xs-3 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">确认密码
										</label> <div class="col-xs-6"> <input type="password"
													name="plaUserPwdAgain" id="plaUserPwdAgain" class="form-control" /></div>
									<div class="col-xs-3" id="CodeError_msg" style="color:red;"></div>
									</div>
									
									<div class="col-xs-9 mts" style="text-align: left;">
									<input type="submit" readonly="readonly" value="&nbsp;&nbsp;&nbsp;&nbsp;保存 &nbsp;&nbsp;&nbsp;&nbsp;" class="btn btn-md btn-info col-xs-offset-3">
									</div>
							</div>
						</div>
									
									</form>
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
	function doVaild() {
		var plaUserPwd = $("#plaUserPwd").val();
		var plaUserPwdAgain = $("#plaUserPwdAgain").val();
		alert(plaUserPwd);
		alert(plaUserPwdAgain);
		if (plaUserPwd != plaUserPwdAgain) {
			alert("两次输入密码不相同！");
			return false;
		}

	}
</script>
</html>
