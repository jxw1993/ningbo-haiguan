<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%String path = request.getContextPath(); 
      String basePath = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+path+"/";%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basePath%>">
<head>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="themes/demo.css">

<script type="text/javascript" src="jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="jquery/jquery.easyui.min.js"></script>
<script type="text/javascript" src="MD5/jquery.md5.js"></script>
<script type="text/javascript">
	function submitForm() {
		var pwd = $("#password").val();
		var md5_pwd = $.md5(pwd);
		console.info(md5_pwd);
// 		if ($("#loginForm").form('validate')) {
// 			$.ajax({
<%-- 				url : "<%=basePath%>validateUser", --%>
// 				type : "POST",
// 				data : md5_pwd,
// 				success : function(data) {
// 		        	 var res = jQuery.parseJSON(data);	        	
// 		        	 if (res.result) {
// 		        		 location.href='./page/homePage.jsp';
// 		        	 } else {
// 		        		 $.messager.alert('提示','用户名或密码错误','error'); 
// 		        	 }
					
// 				},
// 				error : function() {
// 					 $.messager.alert('提示','登录失败,请联系管路员','error'); 
// 				}
// 			});			
// 		}

		 $('#md5_pwd').val(md5_pwd);
		 $('#loginForm').form({
			 url : '<%=basePath%>validateUser',
	         onSubmit: function (){
	         		return $("#loginForm").form('validate');
	         },
	         success : function(data) {
	        	 var res = jQuery.parseJSON(data);	        	
	        	 if (res.result) {
	        		 location.href='./page/homePage.jsp';
	        	 } else {
	        		 $.messager.alert('提示','用户名或密码错误','error');
	        		 
	        	 }
	         }
		 });
		 //$('#loginForm').submit(); 
	}		



</script>
<title>宁波汇民科技信息资源移动管理系统</title>
<!-- Custom Theme files -->
<link href="themes/style.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>
<!--header start here-->
	<div class="login">
		 <div class="login-main">
		 		<div class="login-top">
		 			<img src="images/head-img.png" alt=""/>
		 			<h1>宁波汇民科技信息资源移动管理系统</h1>
		 			<form id="loginForm" method="post">
		 			<input class="easyui-validatebox" required="true" type="text" name="name" id="name" placeholder="用户名"></input>
		 			<input class="easyui-validatebox" required="true" type="password" name="password" id="password" placeholder="密码"></input>
		 			<input type="text" name="md5_pwd" id="md5_pwd" style="display: none;"></input>
		 			<div class="login-bottom">
			 			<div class="clear"> </div>
		 			</div>
		 			<input type="submit" value="提交" onclick="submitForm()"/>		 			
		 			</form>
		 		</div>
		 	</div>
  </div>
<!--header end here-->
<div style="text-align:center;">
</div>
</body>
</html>
