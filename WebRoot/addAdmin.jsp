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
			Object sc = session.getAttribute("security");
			if(sc!=null) {
			String username = (String) session.getAttribute("username");
			String addSuccess = (String) session.getAttribute("addSuccess");
			if ((Integer)sc == 1) {
		%>

 <br> <br> <br> <br> <br> <br> 
		<center>
			<h1>
				<font face="宋体" color="green">欢迎使用学生管理系统</font>
			</h1>
		</center>
		
 <br> <br> 
 欢迎 ：<%=username %>  <s:a href="main.jsp">返回主页</s:a>  <s:a href="logout.jsp">注销</s:a><br>
 		<center>
			<h3>
				<font face="宋体" color="green">添加管理员</font>
			</h3>
	
 <hr color="green" size="1">
 <s:fielderror></s:fielderror>
 <s:form action="AddAdmin" method="post">
 	<s:textfield name="username" label="用户名"></s:textfield>
 	<s:password name="password1" label="密码"></s:password>
 	<s:password name="password2" label="重复密码"></s:password>
 	<s:textfield name="question" label="密码提示问题"></s:textfield>
 	<s:textfield name="answer" label="密码提示问题答案"></s:textfield>
 	<s:submit value="添加"></s:submit>
 </s:form>

<br color=green size=1>

<%
} else {
response.sendRedirect("illegal.jsp");
}
			} else {
				response.sendRedirect("illegal.jsp");
				}			
%>
	</center>
	</body>
</html>
