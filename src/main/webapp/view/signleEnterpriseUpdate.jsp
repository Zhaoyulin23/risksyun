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

				<div class="col-xs-10 prn" style="padding-left:0" id="fieldDiv">
					<!-- 我的位置 -->
					<div class="panel panel-default top-div">
						<div class="panel-heading">
							<a style="cursor: default;">单个企业管理</a> 
							<%-- <div class="col-xs-12" style="height: 50px;margin-top: -17px;margin-left: 80px;<c:if test="${seEnterprise.seId  == null or seEnterprise.seId  == ''}">display: none;</c:if>" >
								<div class="col-xs-2"><a type="button" class="btn btn-sm btn-info" href="getInformationContactList.do?se_id=${seEnterprise.seId}">联系方式</a></div>
								<div class="col-xs-2"><a type="button" class="btn btn-sm btn-info" href="getInformationShareholderList.do?seId=${seEnterprise.seId}">股东信息及变更</a></div>
								<div class="col-xs-2"><a type="button" class="btn btn-sm btn-info" href="getInformationSeniorManagerList.do?se_id=${seEnterprise.seId}">高管信息</a></div>
								<div class="col-xs-2"><a type="button" class="btn btn-sm btn-info" href="getInformationFinancing.do?se_id=${seEnterprise.seId}">融资情况</a></div>
								<div class="col-xs-2"><a type="button" class="btn btn-sm btn-info" href="getInformationNegativeList.do?se_id=${seEnterprise.seId}">负面信息</a></div>
								<div class="col-xs-2"><a type="button" class="btn btn-sm btn-info" href="getSeReportList.do?se_id=${seEnterprise.seId}">报告</a></div>
							</div> --%>
						</div>
						<div style="height: 30px;<c:if test="${seEnterprise.seId  == null or seEnterprise.seId  == ''}">display: none;</c:if>">
							<div class="navbar navbar-default" style="height: 25px;">
							    <ul class="nav navbar-nav" style="margin-top: -5px;float:left;">
							      <li><a href="getInformationContactList.do?se_id=${seEnterprise.seId}" style="color: #269abc;font-weight: 500;">联系方式</a></li>
							      <li><a href="getInformationShareholderList.do?seId=${seEnterprise.seId}" style="width: auto!important;color: #269abc;font-weight: 500;">股东信息及变更</a></li>
							      <li><a href="getInformationSeniorManagerList.do?se_id=${seEnterprise.seId}" style="color: #269abc;font-weight: 500;">高管信息</a></li>
							      <li><a href="getInformationFinancing.do?se_id=${seEnterprise.seId}" style="color: #269abc;font-weight: 500;">融资情况</a></li>
							      <li><a href="getInformationNegativeList.do?se_id=${seEnterprise.seId}" style="color: #269abc;font-weight: 500;">负面信息</a></li>
							      <li><a href="getSeReportList.do?se_id=${seEnterprise.seId}" style="color: #269abc;font-weight: 500;">报告</a></li>
							    </ul>
							</div>
						</div>
						<div class="panel01">
							<form action="<%=basePath%>saveSignleEnterprise.do" method="post" onsubmit="return doVaild()" style="margin-top:50px;">
							<input type="hidden" name="seId"
											value="${seEnterprise.seId}">
							<div class="col-xs-12 ">
								<div class="form-group" style="margin-top:5px;text-align: right;">
									
									<div class="col-xs-6" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
											企业名称
										</label> 
										 <div class="col-xs-8">
										 	<input type="text" name="seName" class="form-control" value="${seEnterprise.seName}">
										 </div>
										<!-- <div class="col-xs-3" id="error_msg" style="color:red;"></div> -->
									</div>
									
									<div class="col-xs-6" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										录入人员
										</label>
										<div class="col-xs-8"> 
											<input type="text" readonly="readonly"  class="form-control" value="${seEnterprise.plaUser.plaUserName}" />
										</div>
									</div>
									
									<div class="col-xs-6" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										社会信用代码
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="seCreditCode" class="form-control" value="${seEnterprise.seCreditCode}" />
										</div>
									</div>
									
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										官网地址
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="seWebsite" class="form-control" value="${seEnterprise.seWebsite}" />
										</div>
									</div>
									
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										注册地址
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="seRegisteredAddress" class="form-control" value="${seEnterprise.seRegisteredAddress}" />
										</div>
									</div>
									
									<div class="col-xs-12 mtm" style="padding-left:0px;">
										<label class="col-xs-3 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										所属区域
										</label> 
										<div class="col-xs-3"> 
											<select class="selectpicker show-tick form-control"
													name="seProvince" id = "seProvince">
													<%-- <c:forEach var="group" items="${group_list}">
														<option value="${group.groupId}"
															<c:if test="${seEnterprise.seProvince == group.groupId}">selected="selected"</c:if>>
															${group.groupName}</option>
													</c:forEach> --%>
												</select>
										</div>
										<div class="col-xs-3"> 
											<select class="selectpicker show-tick form-control"
													name="seCity" id = "seCity">
													
												</select>
										</div>
										<div class="col-xs-3"> 
											<select class="selectpicker show-tick form-control"
													name="seDistrict" id = "seDistrict">
													
												</select>
										</div>
									</div>
									
									<div class="col-xs-12 mtm" style="padding-left:0px;">
										<label class="col-xs-3 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										所属行业
										</label> 
										<div class="col-xs-3"> 
											<select class="selectpicker show-tick form-control"
													name="seIndustryCategory" id="seIndustryCategory">
													
												</select>
										</div>
										<div class="col-xs-3"> 
											<select class="selectpicker show-tick form-control"
													name="seIndustryClass" id="seIndustryClass">
													
												</select>
										</div>
										<div class="col-xs-3"> 
											<select class="selectpicker show-tick form-control"
													name="seIndustrySclass" id="seIndustrySclass">
													
												</select>
										</div>
									</div>
									
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										注册资本
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="seRegisteredCapital" class="form-control" value="${seEnterprise.seRegisteredCapital}" />
										</div>
									</div>
									
									<div class="col-xs-12 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										公司简介
										</label>
										<div class="col-xs-8"> 
											<textarea style="border: 1px solid;"  name="seIntroduction" class="form-control" >${seEnterprise.seIntroduction}</textarea>
										</div>
									</div>
									
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										企业类型
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="seType" class="form-control" value="${seEnterprise.seType}" />
										</div>
									</div>
									
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										法定代表人
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="legalRepresentative" class="form-control" value="${seEnterprise.legalRepresentative}" />
										</div>
									</div>
									
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										成立日期
										</label>
										<div class="col-xs-8"> 
											<div class="input-append date" id="datetimepicker" >
											       <input type="text" name="establishmentDate" class="form-control" value="<fmt:formatDate value="${seEnterprise.establishmentDate}" pattern="yyyy-MM-dd"/>" />
											       <span class="add-on"><i class="icon-th"></i></span>
											</div>
												
											</div>
										</div>
									
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										经营期限
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="operationPeriod" class="form-control" value="${seEnterprise.operationPeriod}" />
										</div>
									</div>
									
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										登记状态
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="registrationStatus" class="form-control" value="${seEnterprise.registrationStatus}" />
										</div>
									</div>
									
									<div class="col-xs-12 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										经营范围
										</label>
										<div class="col-xs-8"> 
											<textarea style="border: 1px solid;" name="scopeOfBusiness" class="form-control" >${seEnterprise.scopeOfBusiness}</textarea>
										</div>
									</div>
									
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										主导产品或主营业务
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="mainBusiness" class="form-control" value="${seEnterprise.mainBusiness}" />
										</div>
									</div>
									
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										所属集团（如有）
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="membershipGroup" class="form-control" value="${seEnterprise.membershipGroup}" />
										</div>
									</div>
									
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										员工人数 
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="staffNumber" class="form-control" value="${seEnterprise.staffNumber}" />
										</div>
									</div>
									
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										采集网址
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="websitesCollection" class="form-control" value="${seEnterprise.websitesCollection}" />
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
		initArea(${seEnterprise.seProvince == null ? 0 : seEnterprise.seProvince},${seEnterprise.seCity == null ? 0 : seEnterprise.seCity},${seEnterprise.seDistrict == null ? 0 : seEnterprise.seDistrict});
		initIndustry(${seEnterprise.seIndustryCategory == null ? 1 : seEnterprise.seIndustryCategory},${seEnterprise.seIndustryClass == null ? 1 : seEnterprise.seIndustryClass},${seEnterprise.seIndustrySclass == null ? 0 : seEnterprise.seIndustrySclass});
	});
	
</script>
</html>
