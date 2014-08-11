<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<title>Login</title>
</head>
<script type="text/javascript">
	$(document).ready(function(){
		$("#userId").change(function(){
			$("#userIdMsg")[0].innerHTML="";
		});
		
		$("userId").blur(function(){
			$.ajax({
				url:"login/validate",
				type:"post",
				datatype:"json",
				data:"userId="+$("userId").val(),
				success:function(data){
					if(!data){
						$("#userIdMsg")[0].innerHTML="用户名不存在";
					}
				}
			});
		});
	});
</script>
<body>
	<form action="doLogin" method="post">
		<table style="margin-left:30%;margin-right=auto;">
			<tr>
				<td>用户名:</td>
				<td><input id="userId" type="text" name="userId" /></td>
				<td><span id="userIdMsg"></span></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input id="password" type="password" name="password" /></td>
				<td><span id="pwdMsg"></span></td>
			</tr>
			<tr>
				<td colspan="2">
					<input id="loginBtn" type="submit" value="登录">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>