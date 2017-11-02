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

<title>区域经济主体表</title>

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
							<a style="cursor: default;">区域经济主体表</a> 				
						</div>
						<div class="panel01">
						
							<form action="<%=basePath%>saveRegEconomicsMain.do" method="post" onsubmit="return doVaild()" style="margin-top:50px;">
							<input type="hidden" name="remId"
											value="${reMain.remId}">
							<div class="col-xs-12 ">
								<div class="form-group" style="margin-top:5px;text-align: right;">
									
									
									
									<div class="col-xs-12 mtm" style="padding-left:0px;">
										<label class="col-xs-3 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										所属区域
										</label> 
										<div class="col-xs-3"> 
											<select class="selectpicker show-tick form-control"
													name="province" id = "seProvince">
													<%-- <c:forEach var="group" items="${group_list}">
														<option value="${group.groupId}"
															<c:if test="${seEnterprise.seProvince == group.groupId}">selected="selected"</c:if>>
															${group.groupName}</option>
													</c:forEach> --%>
												</select>
										</div>
										<div class="col-xs-3"> 
											<select class="selectpicker show-tick form-control"
													name="city" id = "seCity">
													
												</select>
										</div>
										<div class="col-xs-3"> 
											<select class="selectpicker show-tick form-control"
													name="district" id = "seDistrict">
													
												</select>
										</div>
									</div>
									
				
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										官网地址（政府门户）
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="govPortWebsite" class="form-control" value="${reMain.govPortWebsite}" />
										</div>
									</div>
									
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										官网地址（地方统计局）
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="statDeptWebsite" class="form-control" value="${reMain.statDeptWebsite}" />
										</div>
									</div>
									
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										官网地址（地方财政局）
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="bureauFinanceWebsite" class="form-control" value="${reMain.bureauFinanceWebsite}" />
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
		//initArea(${reMain.province},${reMain.city},${reMain.district});
		initArea(${reMain.province == null ? 0 : reMain.province},${reMain.city == null ? 0 : reMain.city},${reMain.district == null ? 0 : reMain.district});
	});	
</script>
</html>district