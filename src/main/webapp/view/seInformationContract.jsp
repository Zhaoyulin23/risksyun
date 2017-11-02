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

<title>单个企业管理管理</title>

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
							<a style="cursor: default;">单个企业管理-联系方式 </a>
							<a class="btn btn-sm btn-info" style="float: right;color: #fff;"
													href="informationContractDetail.do?icId=0&&seId=${signleEnterptise.seId}">新增 </a>
						</div>
						
						<div style="height: 30px;<c:if test="${signleEnterptise.seId  == null or signleEnterptise.seId  == ''}">display: none;</c:if>">
							<div class="navbar navbar-default" style="height: 25px;">
							    <ul class="nav navbar-nav" style="margin-top: -5px;float:left;">
							      <li><a href="getInformationContactList.do?se_id=${signleEnterptise.seId}" style="color: #269abc;font-weight: 500;">联系方式</a></li>
							      <li><a href="getInformationShareholderList.do?seId=${signleEnterptise.seId}" style="width: auto!important;color: #269abc;font-weight: 500;">股东信息及变更</a></li>
							      <li><a href="getInformationSeniorManagerList.do?se_id=${signleEnterptise.seId}" style="color: #269abc;font-weight: 500;">高管信息</a></li>
							      <li><a href="getInformationFinancing.do?se_id=${signleEnterptise.seId}" style="color: #269abc;font-weight: 500;">融资情况</a></li>
							      <li><a href="getInformationNegativeList.do?se_id=${signleEnterptise.seId}" style="color: #269abc;font-weight: 500;">负面信息</a></li>
							      <li><a href="getSeReportList.do?se_id=${signleEnterptise.seId}" style="color: #269abc;font-weight: 500;">报告</a></li>
							    </ul>
							</div>
						</div>
						
						<div class="panel01">
							<div class="col-xs-12">
							<div class="col-xs-1"></div>
							<div class="tab-pane fade in active panel01-body col-xs-10">
								<div  id="trade_list">
									<div style="text-align:center; margin-top:10px;">
										<div>
											<div class="t_resource">
												<table class="table table-striped table-bordered  table-hover table-condensed">
													<thead class="t_thead">
														<tr class="info">
															<td>办公地址</td>
															<td>联系电话</td>
															<td>邮政编码</td>
															<td>公司网址</td>
															<td>电子邮箱</td>
															<td>联系人</td>
															<td>操作</td>
														</tr>
													</thead>
													<tbody>
													 <c:forEach var="informationContract" items="${ic_list}">
														<tr>
															<td>${informationContract.officeAddress}</td>
															<td>${informationContract.phone}</td>
															<td>${informationContract.postCode}</td>
															<td>${informationContract.website}</td>
															<td>${informationContract.email}</td>
															<td>${informationContract.contacts}</td>
															<td>
																<a class="btn btn-sm btn-info" href="informationContractDetail.do?icId=${informationContract.icId}&seId=${signleEnterptise.seId}" >修改</a>
																<a class="btn btn-sm btn-info" href="deleteInformationContract.do?icId=${informationContract.icId}&seId=${signleEnterptise.seId}">删除</a>
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
