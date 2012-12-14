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

		<%
		session.removeAttribute("username");
		session.removeAttribute("security");
	    response.sendRedirect("index.jsp");
		%>

	</body>
</html>
