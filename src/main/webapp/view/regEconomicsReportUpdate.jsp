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

<title>区域经济报告</title>

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
							<a style="cursor: default;">区域经济报告</a> 
						</div>
						<div class="panel01">
						
							<form action="<%=basePath%>saveInformationContract.do" method="post" onsubmit="return doVaild()" style="margin-top:50px;">
							<input type="hidden" name="seId"
											value="${reReport.rerId}">
							<div class="col-xs-12 ">
								<div class="form-group" style="margin-top:5px;text-align: right;">
									
									<div class="col-xs-6" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
											报告名称
										</label> 
										 <div class="col-xs-8">
										 	<input type="text" name="seName" class="form-control" value="${reReport.reportName}">
										 </div>
										<!-- <div class="col-xs-3" id="error_msg" style="color:red;"></div> -->
									</div>
									
									<div class="col-xs-6" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										区域经济id
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="seCreditCode" class="form-control" value="${seEnterprise.seCreditCode}" />
										</div>
									</div>
									
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										年份
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="seWebsite" class="form-control" value="${seEnterprise.seWebsite}" />
										</div>
									</div>
									
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										报告分类
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="seRegisteredAddress" class="form-control" value="${seEnterprise.seRegisteredAddress}" />
										</div>
									</div>								

								
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										类型
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="type" class="form-control" value="${reReport.type}" />
										</div>
									</div>
									
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										采集网址
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="websites" class="form-control" value="${reReport.websites}" />
										</div>
									</div>
									
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										内容
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="content" class="form-control" value="${reReport.content}" />
										</div>
									</div>
									
									<div class="col-xs-6 mtm" style="padding-left:0px;">
										<label class="col-xs-4 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										附件
										</label>
										<div class="col-xs-8"> 
											<input type="text" name="attachment" class="form-control" value="${reReport.attachment}" />
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
		initArea(${reReport.province},${reReport.city},${reReport.district});
	});
	
	
	
	
</script>
</html>
