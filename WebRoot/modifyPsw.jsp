<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.springframework.web.context.request.RequestScope"%>
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
		
		<center>
			<h3>
				<font face="宋体" color="green">修改用户信息</font>
			</h3>
			欢迎：<%=session.getAttribute("username") %> 
			<s:a href="main.jsp">返回主页</s:a>
			<s:a href="logout.jsp">注销</s:a>
			<hr color="green" size=4>

			<font face="宋体" color="green">请输入相关信息</font>


			<br>
			<br>

			<s:fielderror></s:fielderror>

			<s:form action="modifyAdmin" method="post">
				<s:textfield name="username" label="用户名"></s:textfield>
				<s:textfield name="question" label="密码提示问题"></s:textfield>
				<s:textfield name="answer" label="密码提示问题答案"></s:textfield>
				<s:password name="password1" label="新密码"></s:password>
				<s:password name="password2" label="重复新密码"></s:password>
				<s:submit value="提交"></s:submit>
			</s:form>
		</center>
	</body>
</html>
