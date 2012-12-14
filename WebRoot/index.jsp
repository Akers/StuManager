<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>学生管理系统</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body background="image/bj.jpg">

		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<center>
			<h1>
				<font face="宋体" color="green">学生管理系统</font>
			</h1>
		</center>

		<center>
			<s:fielderror></s:fielderror>
		</center>
		<s:form action="/login" method="post">

			<table align="center" bordercolor="red">

				<s:textfield name="username" label="登 陆 名"></s:textfield>
				<s:password name="password" label="密    码"></s:password>
				<s:submit value="登陆"></s:submit>
				<td>
					<s:a href="modifyPsw.jsp">忘记密码</s:a>
				</td>

			</table>
		</s:form>

	</body>
</html>
