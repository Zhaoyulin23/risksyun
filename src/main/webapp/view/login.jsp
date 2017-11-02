<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
  <body>
  	<jsp:include page="/view/header.jsp"></jsp:include>
    <div class="container" style="margin-top: 100px;width:20%;">
		<div >
	      <form class="form-signin" action="<%=basePath%>doLogin" method="post" onsubmit="return doVaild()">
	      	<h4 class="form-signin-heading" style="color: red;">${loginMessage}</h4>
	        <h2 class="form-signin-heading">Please sign in</h2>
	        <label for="inputEmail" class="sr-only">User Name</label>
	        <input type="text" id="userName" name="userName" class="form-control" placeholder="User Name" required autofocus>
	        <br>
	        <label for="inputPassword" class="sr-only">Password</label>
	        <input type="password" id="userPassword" name="userPassword" class="form-control" placeholder="Password" required>
	        <!-- <div class="checkbox">
	          <label>
	            <input type="checkbox" value="remember-me"> Remember me
	          </label>
	        </div> -->
	        <br>
	        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	      </form>
	</div>

    </div>
  </body>
  <script type="text/javascript">
  
  function doVaild() {
	    var user_name = $("#userName").val();
	    var user_pwd = $("#userPassword").val();

	    if(user_name == null || user_name == '' || user_pwd == null || user_pwd == ''){
	        alert("请输入用户名和密码");
	        return false;
	    }
	    return true;
	}
  </script>
</html>
