<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<style type="text/css">
.panel-heading .btn-sm {
	width: auto!important;
	color: #fff!important;
}
</style>
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
							<a style="cursor: default;">单个企业管理</a> 
						</div>
						<div style="height: 30px;<c:if test="${seId  == null or seId  == ''}">display: none;</c:if>">
							<div class="navbar navbar-default" style="height: 25px;">
							    <ul class="nav navbar-nav" style="margin-top: -5px;float:left;">
							      <li><a href="getInformationContactList.do?se_id=${seId}" style="color: #269abc;font-weight: 500;">联系方式</a></li>
							      <li><a href="getInformationShareholderList.do?seId=${seId}" style="width: auto!important;color: #269abc;font-weight: 500;">股东信息及变更</a></li>
							      <li><a href="getInformationSeniorManagerList.do?se_id=${seId}" style="color: #269abc;font-weight: 500;">高管信息</a></li>
							      <li><a href="getInformationFinancing.do?se_id=${seId}" style="color: #269abc;font-weight: 500;">融资情况</a></li>
							      <li><a href="getInformationNegativeList.do?se_id=${seId}" style="color: #269abc;font-weight: 500;">负面信息</a></li>
							      <li><a href="getSeReportList.do?se_id=${seId}" style="color: #269abc;font-weight: 500;">报告</a></li>
							    </ul>
							</div>
						</div>
						<div class="panel01">
						
							<form action="<%=basePath%>saveInformationShareholderDetail.do" method="post" onsubmit="return doVaild()" style="margin-top:50px;">
							<input type="hidden" name="isdId"
											value="${informationShareholderDetail.isdId}">
							<input type="hidden" name="isId"
											value="${isId}">
							<div class="col-xs-12 ">
								<div class="form-group" style="margin-top:5px;text-align: right;">
									
									
									<div class="col-xs-6" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
											股东名称
										</label> 
										 <div class="col-xs-8">
										 	<input type="text" name="shareholders" class="form-control" value="${informationShareholderDetail.shareholders}">
										 </div>
									</div>
									
									<div class="col-xs-6" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										出资金额（万元，人民币）
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="contributionAmount" class="form-control" value="${informationShareholderDetail.contributionAmount}" />
										</div>
									</div>
									
									<div class="col-xs-6" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										占比
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="ratio" class="form-control" value="${informationShareholderDetail.ratio}" />
										</div>
									</div>
									
									<div class="col-xs-6" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										股东背景
										</label>
										<div class="col-xs-8"> 
											<select class="selectpicker show-tick form-control"
													name="sbType" id = "sbType">
													<c:forEach var="sbType" items="${sbType_list}">
														<option value="${sbType.sbId}"
															<c:if test="${informationShareholderDetail.sbType == sbType.sbId}">selected="selected"</c:if>>
															${sbType.shareholdersBackgroundName}</option>
													</c:forEach>
												</select>
										</div>
									</div>
									
									<div class="col-xs-9 mts" style="text-align: left;">
									<input type="submit" readonly="readonly"  value="&nbsp;&nbsp;&nbsp;&nbsp;保存 &nbsp;&nbsp;&nbsp;&nbsp;" class="btn btn-md btn-info col-xs-offset-3">
									</div>
									
									<div class="col-xs-9 mtm" style="text-align: left;">
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

</body>

<script type="text/javascript">
	jQuery().ready(function() {
		//initArea(${seEnterprise.seProvince},${seEnterprise.seCity},${seEnterprise.seDistrict});
		//initIndustry(${seEnterprise.seIndustryCategory},${seEnterprise.seIndustryClass},${seEnterprise.seIndustrySclass});
	});
	
	
	
	
</script>
</html>
