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
							<form action="<%=basePath%>saveUser" method="post" style="margin-top:50px;">
							<input type="hidden" name="plaUserId"
											value="${user.plaUserId}">
							<div class="col-xs-10 col-xs-offset-2">
								<div class="form-group" style="margin-top:5px;text-align: right;">
									<div class="col-xs-9" style="padding-left:0px;">
										<label class="col-xs-3 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">用户名
										</label> 
											 <div class="col-xs-6"><input type="text" name="plaUserName" class="form-control" 
											 	<c:if test="${user.plaUserId != null && user.plaUserId != 0 }">readonly="readonly"</c:if>
											 value="${user.plaUserName}"></div>
											<div class="col-xs-3" id="error_msg" style="color:red;"></div>
									</div>
									
									<div class="col-xs-9 mtm" style="padding-left:0px;">
										<label class="col-xs-3 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">密码
										</label> <div class="col-xs-6"> <input type="password" name="plaUserPwd"
													class="form-control" value="${user.plaUserPwd}" /></div>
									<div class="col-xs-3" id="CodeError_msg" style="color:red;"></div>
									</div>
									
									<div class="col-xs-9 mtm" style="padding-left:0px;">
										<label class="col-xs-3 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">用户组
										</label> 
										<div class="col-xs-6"> 
											<select class="selectpicker show-tick form-control"
													name="plaUserGroup">
													<c:forEach var="group" items="${group_list}">
														<option value="${group.groupId}"
															<c:if test="${user.plaUserGroup == group.groupId}">selected="selected"</c:if>>
															${group.groupName}</option>
													</c:forEach>
												</select>
										</div>
									<div class="col-xs-3" id="CodeError_msg" style="color:red;"></div>
									</div>
									
									<div class="col-xs-9 mts" style="text-align: left;">
									<input type="submit" readonly="readonly"  value="&nbsp;&nbsp;&nbsp;&nbsp;保存 &nbsp;&nbsp;&nbsp;&nbsp;" class="btn btn-md btn-info col-xs-offset-3">
									</div>
							</div>
						</div>
						</form>
							<%-- <div class="col-xs-12">
								<div style="margin-left:20%;">
									<form action="<%=basePath%>saveUser" method="post">

										<input type="hidden" name="plaUserId"
											value="${user.plaUserId}">
										<span>标题：</span><input type="text" name="title" style="width:200px;" value="${news.newsName}">
										<div class="col-xs-4">
											<div class="input-group col-md-10"
												style="margin-top:0px positon:relative">
												<label>用户名：</label> <input type="text" name="plaUserName"
													class="form-control"
													<c:if test="${user.plaUserId != null && user.plaUserId != 0 }">readonly="readonly"</c:if>
													value="${user.plaUserName}" />
											</div>

											<c:if test="${user.plaUserId == null || user.plaUserId == 0 }">
											<div class="input-group col-md-10"
												style="margin-top:0px positon:relative">
												<label>密码：</label> <input type="password" name="plaUserPwd"
													class="form-control" value="${user.plaUserPwd}" />
											</div>
											</c:if>
											<div class="input-group col-md-10" style="margin-top:20px;">
												<label>用户组</label> <select
													class="selectpicker show-tick form-control"
													name="plaUserGroup">
													<c:forEach var="group" items="${group_list}">
														<option value="${group.groupId}"
															<c:if test="${user.plaUserGroup == group.groupId}">selected="selected"</c:if>>
															${group.groupName}</option>
													</c:forEach>
												</select>
											</div>

										</div>
										<div class="col-xs-12">

											<div style="margin-top: 10px;">
												<input class="btn btn-info btn-info" name="submit"
													value="提交" type="submit">
											</div>
										</div>
									</form>
								</div>
							</div> --%>
						</div>
					</div>

				</div>

			</div>
		</div>
	</div>
	<div class="tab-content">
		<div class="row"></div>
	</div>
</body>
</html>
