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
							<a style="cursor: default;">单个企业管理-融资情况 </a>
							<%-- <a class="btn btn-sm btn-info" style="float: right;color: #fff;"
													href="getSeReport.do?reportId=0&seId=${seId}">新增 </a> --%>
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
							<input type="hidden" id="ifId" value="${informationFinancing.ifId}"/>
							<div style="margin-top: 100px;"></div>
							<div class="col-xs-12 col-xs-offset-2">
								<div class="form-group" style="margin-top:5px;text-align: right;">
									<div class="col-xs-9" style="padding-left:0px;">
										<label class="col-xs-3 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										是否上市
										</label>
										<div class="col-xs-6" style="margin-left: -125px;"> 
											<input  type="checkbox" data-color="warning" data-on-label="是" data-off-label="否" id="ipo" checked />
											<a type="button" id="ipo_btn" data-switch-get="state"  class="btn btn-info" href="getInformationIpoList.do?seId=${seId}">上市信息</a>
										</div>
									</div>
									
									
								</div>
							</div>
							
							<div class="col-xs-12 col-xs-offset-2	">
								<div class="form-group" style="margin-top:5px;text-align: right;">
									<div class="col-xs-9" style="padding-left:0px;">
										<label class="col-xs-3 control-label" style="width: 120px;line-height:34px;vertical-align: middle;">
										是否发债
										</label>
										<div class="col-xs-6" style="margin-left: -125px;"> 
											<input  type="checkbox" data-color="warning" data-on-label="是" data-off-label="否" id="issueBond" checked />
											<a type="button" id="bond_btn" data-switch-get="state" class="btn btn-info" href="getInformationBondList.do?seId=${seId}">发债信息</a>
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
$(function () {
	var ipo_state = false;
	if(${informationFinancing.ipo == 1}){
		ipo_state = true ;
		$("#ipo_btn").attr("disabled", false);
	}else{
		$("#ipo_btn").attr("disabled", true);
	}
    $("#ipo").bootstrapSwitch({
    	state: ipo_state,
    	size: 'small',
    	onText: 'Yes',
    	offText: 'No',
    	onSwitchChange: function (event, state) {
    		OnSubmit("ipo",state);
    		if(!state){
    			$("#ipo_btn").attr("disabled", true);
    		}else{
    			$("#ipo_btn").attr("disabled", false);
    		}
   	    }
    });
    
    var bond_state = false;
	if(${informationFinancing.issueBond == 1}){
		bond_state = true ;
		$("#bond_btn").attr("disabled", false);
	}else{
		$("#bond_btn").attr("disabled", true);
	}
    $("#issueBond").bootstrapSwitch({
    	state: bond_state,
    	size: 'small',
    	onText: 'Yes',
    	offText: 'No',
    	onSwitchChange: function (event, state) {
    		OnSubmit("issueBond",state);
    		if(state){
    			$("#bond_btn").attr("disabled", false);
    		}else{
    			$("#bond_btn").attr("disabled", true);
    		}
   	    }
    });
    /* $("[data-switch-get]").on("click", function () {
        var type;
        type = $(this).data("switch-get");
        alert($("#switch-state").bootstrapSwitch("state"));
        return alert($("#switch-" + type).bootstrapSwitch(type));
    }); */

    
})

function OnSubmit(filed,state){
	/* var ifId = "";
	if(${informationFinancing.ifId == "" || informationFinancing.ifId == null}){
		ifId = null;
	}else{
		ifId = ${informationFinancing.ifId};
	} */
	var ifId = $("#ifId").val();
	var seId = ${seId};
	var value = 0;
	if(state){
		value = 1;
	}
	var p = {ifId:ifId, seId:seId, field:filed, value:value};
	
	$.ajax({
		url:"<%=basePath%>saveInformationFinancing.do",
		data:p,
		type:"POST",
		success: function (returndata) {  
			if(returndata.length > 0){
				if(returndata.split("-")[0] == "add"){
					$("#ifId").val(returndata.split("-")[1]);
				}
			}
         },  
         error: function (returndata) {  
             alert(returndata);  
         } 
	});
}
</script>
</html>
