 function initPageContext(pageNow, totalPageCount, action){
    	var pageContent = "";
    	//首页
    	pageContent += "<a class='nav-page' href='"+action+"&pageNow="+1+"'>首页</a>";
    	if(totalPageCount == 0){
    		return;
    	}
    	if(pageNow <=1 && totalPageCount <=1){
    		if(pageNow == 1 ){
    			pageContent += "<a class='nav-page active' href='"+action+"&pageNow="+(pageNow)+"'>1</a>";
    		}
    	}else if(pageNow >= 1 && pageNow <= 5 && totalPageCount <=5){
    		for(var i = 1; i<= totalPageCount; i++){
    			if(pageNow == i){
    				pageContent += "<a class='nav-page active' href='"+action+"&pageNow="+i+"'>"+i+"</a>";
    			}else{
    				pageContent += "<a class='nav-page' href='"+action+"&pageNow="+i+"'>"+i+"</a>";
    			}
    		}
    		
    	}else{
    		if(pageNow <= 3){
    			for(var i = 1; i<= 5; i++){
        			if(pageNow == i){
        				pageContent += "<a class='nav-page active' href='"+action+"&pageNow="+i+"'>"+i+"</a>";
        			}else{
        				pageContent += "<a class='nav-page' href='"+action+"&pageNow="+i+"'>"+i+"</a>";
        			}
        		}
    		}else if(pageNow-2 <= totalPageCount){
    			for(var i = totalPageCount-4; i<=totalPageCount; i++){
        			if(pageNow == i){
        				pageContent += "<a class='nav-page active' href='"+action+"&pageNow="+i+"'>"+i+"</a>";
        			}else{
        				pageContent += "<a class='nav-page' href='"+action+"&pageNow="+i+"'>"+i+"</a>";
        			}
        		}
    		}else{
    			for(var i = pageNow-2; i<= pageNow+2 && i<=totalPageCount; i++){
        			if(pageNow == i){
        				pageContent += "<a class='nav-page active' href='"+action+"&pageNow="+i+"'>"+i+"</a>";
        			}else{
        				pageContent += "<a class='nav-page' href='"+action+"&pageNow="+i+"'>"+i+"</a>";
        			}
        		}
    		}
    	}
    	//尾页
    	pageContent += "<a class='nav-page' href='"+action+"&pageNow="+totalPageCount+"'>尾页</a>";
    	$("#page-content").html(pageContent);
    }
    
    function initPageStep(pageNow, totalPageCount, action){
    	var pageStepContent = "";
    	if(totalPageCount == 0){
    		return;
    	}
    	if(pageNow == 1){
    		pageStepContent ="<a class='page-step-last'>上一页</a>";
    	}else{
    		pageStepContent ="<a class='page-step-last' href='"+action+"&pageNow="+(pageNow-1)+"'>上一页</a>";
    	}
    	
    	if(pageNow == totalPageCount){
    		pageStepContent +="<a class='page-step-next'>下一页</a>";
    	}else{
    		pageStepContent +="<a class='page-step-next' href='"+action+"&pageNow="+(pageNow+1)+"'>下一页</a>";
    	}
    	$("#page-stpe").html(pageStepContent);
    }
    
    /** 
     * 获取当前URL参数值 
     * @param name  参数名称 
     * @return  参数值 
     */  
    function getUrlParam(name) {  
           var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");  
           var r = window.location.search.substr(1).match(reg);  
           if (r!=null)   
               return unescape(r[2]);   
           return null;  
             
    } 
    
    /**
     * 时间格式化
     * @param nS
     * @param fmt
     * @returns
     */
    function getLocalTime(nS,fmt) {  
        var date = new Date(nS);
        var year = date.getFullYear();
        var month = date.getMonth()+1;
        var day = date.getDate();
        if(fmt == "yyyy"){
        	 return year;
        }else if(fmt == "MM-dd"){
	        return month+"-"+day;
        }else if(fmt == "yyyy-MM-dd"){
	        return year + "-"+ month+"-"+day;
        }
    } 
    
    
    //所属区域初始化
    function initArea(seProvince,seCity,seDistrict){
		var temp_option = "";
		$.ajax({url: "getSeProvince.do",success:function(data){
			for(var i = 0 ; i < data.length ; i++){
				if(seProvince == data[i].id){
					temp_option = "<option value="+ data[i].id +" selected = 'selected'>"+ data[i].province +"</option>"
				}else{
					temp_option = "<option value="+ data[i].id +">"+ data[i].province +"</option>"
				}
				$("#seProvince").append(temp_option);
			}
			
			//加载市
			$.ajax({url: "getSeCity.do?id="+seProvince,success:function(data){
				temp_option ="";
				if(seCity == 0){
					$("#seCity").append("<option>请选择</option>");
				}
				for(var i = 0 ; i < data.length ; i++){
					var city_temp = true;
					if(data[i].city != null && data[i].city != ""){
						if(seCity == data[i].id){
							temp_option = "<option value="+ data[i].id +" selected = 'selected'>"+ data[i].city +"</option>"
						}else{
							temp_option = "<option value="+ data[i].id +">"+ data[i].city +"</option>"
						}
						city_temp = false;
					}
					$("#seCity").append(temp_option);
				}
				//直辖市,和省的id一样
				if(city_temp){
					temp_option += "<option value='" + $("#seProvince").find("option:selected").val()
					+ "'>" + $("#seProvince").find("option:selected").text()	
					+ "</option>";
				}
				$("#seCity").append(temp_option);
				
				//加载地区
				$.ajax({url: "getSeDistrict.do?id="+seCity,success:function(data){
					temp_option ="";
					$("#seDistrict").append("<option>请选择</option>");
					for(var i = 0 ; i < data.length ; i++){
						var city_temp = true;
						if(seDistrict == data[i].id){
							temp_option = "<option value="+ data[i].id +" selected = 'selected'>"+ data[i].district +"</option>"
						}else{
							temp_option = "<option value="+ data[i].id +">"+ data[i].district +"</option>"
						}
						$("#seDistrict").append(temp_option);
					}
				}});
				
				
			}});
		}});
		
	$("#seProvince").change(
		function(){
			$.ajax( {
				type : "get",
				url : "getSeCity.do",
				data : "id=" + $("#seProvince").val(),
				cache : false,
				dataType : "json",
				success : function(json) {
					var temp_null = true;
					var str = "<option>请选择</option>";
					$("#seCity").html("");
					for ( var i = 0; i < json.length; i++) {
						if(json[i].city != null && json[i].city != ""){
							str += "<option value='" + json[i].id
									+ "'>" + json[i].city
									+ "</option>";
							temp_null = false;
						}
					}
					if(temp_null){
						str += "<option value='" + $("#seProvince").find("option:selected").val()
						+ "'>" + $("#seProvince").find("option:selected").text()	
						+ "</option>";
					}
					$("#seCity").append(str);
					
					//选中省份后，地区要重置
					$("#seDistrict").html("<option>请选择</option>");
				},
				error : function() {
					alert("请与管理员联系");
				}
			});
	});
	
	$("#seCity").change(
			function(){
				$.ajax( {
					type : "get",
					url : "getSeDistrict.do",
					data : "id=" + $("#seCity").val(),
					cache : false,
					dataType : "json",
					success : function(json) {
						var str = "<option>请选择</option>";
						$("#seDistrict").html("");
						for ( var i = 0; i < json.length; i++) {
							str += "<option value='" + json[i].id
									+ "'>" + json[i].district
									+ "</option>";
						}
						$("#seDistrict").append(str);
						
					},
					error : function() {
						alert("请与管理员联系");
					}
				});
		});
	}

    
    //所属行业初始化
    function initIndustry(seIndustryCategory,seIndustryClass,seIndustrySclass){
    	var temp_option = "";
    	$.ajax({url: "getSeIndustryCategory.do",success:function(data){
			for(var i = 0 ; i < data.length ; i++){
				if(seIndustryCategory == data[i].id){
					temp_option = "<option value="+ data[i].id +" selected = 'selected'>"+ data[i].cname +"</option>"
				}else{
					temp_option = "<option value="+ data[i].id +">"+ data[i].cname +"</option>"
				}
				$("#seIndustryCategory").append(temp_option);
			}
			
			//加载大类
			$.ajax({url: "getSeIndustryClass.do?industryCategory="+seIndustryCategory,success:function(data){
				temp_option ="";
				$("#seIndustryClass").append("<option>请选择</option>");
				for(var i = 0 ; i < data.length ; i++){
					if(seIndustryClass == data[i].id){
						temp_option = "<option value="+ data[i].id +" selected = 'selected'>"+ data[i].cname +"</option>"
					}else{
						temp_option = "<option value="+ data[i].id +">"+ data[i].cname +"</option>"
					}
					$("#seIndustryClass").append(temp_option);
				}
				
				//加载小类
				$.ajax({url: "getSeIndustrySclass.do?industryClass="+seIndustryClass,success:function(data){
					temp_option ="";
					$("#seIndustrySclass").append("<option>请选择</option>");
					for(var i = 0 ; i < data.length ; i++){
						if(seIndustrySclass == data[i].id){
							temp_option = "<option value="+ data[i].id +" selected = 'selected'>"+ data[i].cname +"</option>"
						}else{
							temp_option = "<option value="+ data[i].id +">"+ data[i].cname +"</option>"
						}
						$("#seIndustrySclass").append(temp_option);
					}
				}});
				
				
			}});
		}});
    	
    	
    	$("#seIndustryCategory").change(
    			function(){
    				$.ajax( {
    					type : "get",
    					url : "getSeIndustryClass.do",
    					data : "industryCategory=" + $("#seIndustryCategory").val(),
    					cache : false,
    					dataType : "json",
    					success : function(json) {
    						var str = "<option>请选择</option>";
    						$("#seIndustryClass").html("");
    						for ( var i = 0; i < json.length; i++) {
							str += "<option value='" + json[i].id
									+ "'>" + json[i].cname
									+ "</option>";
    						}
    						$("#seIndustryClass").append(str);
    						
    						//选中省份后，地区要重置
    						$("#seIndustrySclass").html("<option>请选择</option>");
    					},
    					error : function() {
    						alert("请与管理员联系");
    					}
    				});
    		});
    		
    		$("#seIndustryClass").change(
    				function(){
    					$.ajax( {
    						type : "get",
    						url : "getSeIndustrySclass.do",
    						data : "industryClass=" + $("#seIndustryClass").val(),
    						cache : false,
    						dataType : "json",
    						success : function(json) {
    							var str = "<option>请选择</option>";
    							$("#seIndustrySclass").html("");
    							for ( var i = 0; i < json.length; i++) {
    								str += "<option value='" + json[i].id
    										+ "'>" + json[i].cname
    										+ "</option>";
    							}
    							$("#seIndustrySclass").append(str);
    							
    						},
    						error : function() {
    							alert("请与管理员联系");
    						}
    					});
    			});
    }
