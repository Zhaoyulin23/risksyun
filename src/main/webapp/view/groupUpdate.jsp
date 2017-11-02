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
<script type="text/javascript" src="<%=basePath%>ueditor/ueditor.all.js"></script>
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
							<div class="col-xs-12">
								<div style="margin-left:10%;">
									<form action="<%=basePath%>saveGroup" method="post"
										onsubmit="return doVaild()">

										<input type="hidden" name="groupId"
											value="${plaGroup.groupId}">
										<div class="col-xs-4">
											<div class="col-md-10"
												style="margin-top:0px positon:relative">
												<label>用户组：</label> <input type="text" id="groupName"
													name="groupName" class="form-control"
													value="${plaGroup.groupName}" />
											</div>

											<c:forEach var="plafun" items="${fun_list}">
												<div class="input-group col-md-10"
													style="margin-top:0px positon:relative;margin-left: 30px;">
													<label class="checkbox"> <input type="checkbox"
														name="gfFunIds"
														<c:forEach var="fun" items="${plaGroup.plafunList}">
						 	   	<c:if test="${plafun.funId == fun.funId}">checked="checked"</c:if>
						 	   </c:forEach>
														value="${plafun.funId}" style="margin-top: 5px;">${plafun.funLabel}
													</label>
												</div>
											</c:forEach>

										</div>
										<div class="col-xs-12">

											<div style="margin-top: 10px;">
												<input class="btn btn-sm btn-info btn-info" name="submit"
													value="保存" type="submit">
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
	<div class="tab-content">
		<div class="row"></div>
	</div>
</body>
<script type="text/javascript">
	function doVaild() {
		var groupName = $("#groupName").val();
		if (groupName == null || groupName == "") {
			alert("请填写用户组名称！");
			return false;
		}

		var gfFunIds = [];
		$('input[name="gfFunIds"]:checked').each(function() {
			gfFunIds.push($(this).val());
		});
		if (gfFunIds == null || gfFunIds.length == 0) {
			alert("请选择权限！");
			return false;
		}
		return true;
	}
</script>
</html>
