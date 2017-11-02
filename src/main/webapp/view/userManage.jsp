<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>账号管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<jsp:include page="/view/header.jsp"></jsp:include>
<div class="main">
		<div class="container"
			style="box-shadow: 0px 1px 5px rgba(0,0,0,.3);margin-top:15px;background-repeat:repeat-y">
			<div class="row">
				<jsp:include page="/view/left.jsp"></jsp:include>

				<div class="col-xs-10 prn" style="padding-left:0">
					<!-- 我的位置 -->
					<div class="panel panel-default top-div">
						<div class="panel-heading">
							<a style="cursor: default;">快捷服务 </a>
							<a class="btn btn-sm btn-info" style="float: right;color: #fff;"
													href="userUpdate?plaUserId=0">新增 </a>
						</div>
						<div class="panel01">
							<div class="col-xs-12">
			<div class="col-xs-1"></div>
			<div class="tab-pane fade in active panel01-body col-xs-10">
				<div  id="trade_list">
					<div style="text-align:center; margin-top:30px;">
						<div>
							<div class="t_resource">
								<table class="table table-striped table-bordered  table-hover table-condensed">
									<thead class="t_thead">
										<tr class="info">
											<td>用户名</td>
											<td>用户组</td>
											<td>创建时间</td>
											<td>修改时间</td>
											<td>最后登录时间</td>
											<td>操作</td>
										</tr>
									</thead>
									<tbody>
									 <c:forEach var="plaUser" items="${userList}">
										<tr>
											<td>${plaUser.plaUserName}</td>
											<td>${plaUser.plaGroup.groupName}</td>
											<td><fmt:formatDate value="${plaUser.createTime}" pattern="yyyy-MM-dd"/></td>
											<td><fmt:formatDate value="${plaUser.updateTime}" pattern="yyyy-MM-dd"/></td>
											<td><fmt:formatDate value="${plaUser.lastLoginTime}" pattern="yyyy-MM-dd"/></td>
											<td>
												<a class="btn btn-sm btn-info" href="userUpdate?plaUserId=${plaUser.plaUserId}" >修改</a>
												<a class="btn btn-sm btn-info" href="deleteUser?plaUserId=${plaUser.plaUserId}">删除</a>
											</td>
										</tr>
										 </c:forEach>
										
									</tbody>
								</table>
								
								<!-- 分页功能 start -->
							<div>
						
							<div id="page-content" align="left" style="width:300px;height: 50px;">
							
							</div>
							<div id="page-stpe" align="right" style="margin-right: 35px;margin-top: -45px;clear:both;">
								
							</div>
						</div>  
		    	<!-- 分页功能 End --> 
							</div>
						</div>
					</div>
				</div>
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
jQuery().ready(function (){

});
</script>
</html>
