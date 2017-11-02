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
							<%-- <div class="col-xs-12" style="height: 50px;margin-top: -17px;margin-left: 80px;<c:if test="${signleEnterptise.seId  == null or signleEnterptise.seId  == ''}">display: none;</c:if>" >
								<div class="col-xs-2"><a type="button" class="btn btn-sm btn-info" href="getInformationContactList.do?se_id=${signleEnterptise.seId}">联系方式</a></div>
								<div class="col-xs-2"><a type="button" class="btn btn-sm btn-info" href="getInformationShareholderList.do?seId=${signleEnterptise.seId}">股东信息及变更</a></div>
								<div class="col-xs-2"><a type="button" class="btn btn-sm btn-info" href="getInformationSeniorManagerList.do?se_id=${signleEnterptise.seId}">高管信息</a></div>
								<div class="col-xs-2"><a type="button" class="btn btn-sm btn-info" href="getInformationFinancing.do?se_id=${signleEnterptise.seId}">融资情况</a></div>
								<div class="col-xs-2"><a type="button" class="btn btn-sm btn-info" href="getInformationNegativeList.do?se_id=${signleEnterptise.seId}">负面信息</a></div>
								<div class="col-xs-2"><a type="button" class="btn btn-sm btn-info" href="getSeReportList.do?se_id=${signleEnterptise.seId}">报告</a></div>
							</div> --%>
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
						
							<form action="<%=basePath%>saveInformationContract.do" method="post" onsubmit="return doVaild()" style="margin-top:50px;">
							<input type="hidden" name="icId"
											value="${informationContact.icId}">
							<input type="hidden" name="seId"
											value="${signleEnterptise.seId}">
							<div class="col-xs-12 ">
								<div class="form-group" style="margin-top:5px;text-align: right;">
									
									<div class="col-xs-6" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
											办公地址
										</label> 
										 <div class="col-xs-8">
										 	<input type="text" name="officeAddress" class="form-control" value="${informationContact.officeAddress}">
										 </div>
										<!-- <div class="col-xs-3" id="error_msg" style="color:red;"></div> -->
									</div>
									
									<div class="col-xs-6" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										联系电话
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="phone" class="form-control" value="${informationContact.phone}" />
										</div>
									</div>
									
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										邮政编码
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="postCode" class="form-control" value="${informationContact.postCode}" />
										</div>
									</div>
									
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										公司网址
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="website" class="form-control" value="${informationContact.website}" />
										</div>
									</div>
									
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										电子邮箱
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="email" class="form-control" value="${informationContact.email}" />
										</div>
									</div>
									
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										联系人
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="contacts" class="form-control" value="${informationContact.contacts}" />
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
