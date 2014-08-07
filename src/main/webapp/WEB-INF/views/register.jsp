<%@page pageEncoding="utf-8"  %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<form action="user/addUser" method="post">
		<table align="center">
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="userId" /></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="text" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="注册">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
