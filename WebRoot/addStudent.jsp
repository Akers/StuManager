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
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<center>
			<h1>
				<font face="宋体" color="green">欢迎使用学生管理系统</font>
			</h1>
		</center>

		<br>
		<br>
		欢迎 ：<%=username%>
		
		<s:a href="main.jsp">返回主页</s:a>
		
		<s:a href="logout.jsp">注销</s:a>
		<br>
		<center>
			<h3>
				<font face="宋体" color="green">添加学生信息(*为必填选项)</font>
			</h3>

			<hr color="green" size="1">
			<s:fielderror></s:fielderror>
			
			<s:form action="addStudent" method="post" enctype="multipart/form-data">

				<s:textfield name="stuID" label="学号*"></s:textfield>
				<s:textfield name="userName" label="姓名*"></s:textfield>
				<s:radio name="sex" label="性别" list="{'男','女'}" value="'男'"></s:radio>
				<s:textfield name="StuGrdSchool" label="原毕业学校*"></s:textfield>
				<s:textfield name="StuAddr" label="家庭地址"></s:textfield>
				<s:textfield name="StuHomePhone" label="家庭电话"></s:textfield>
				<s:textfield name="StuMobilePhone" label="手机号*"></s:textfield>
				<s:textfield name="StuNowAddr" label="现在居住地"></s:textfield>
				<s:textfield name="StuClass" label="班级*"></s:textfield>
				<s:textfield name="StuAssistant" label="辅导员*"></s:textfield>
				<s:file name="StuPhoto" label="照片"></s:file>
				
				<s:submit value="添加"></s:submit>
				<s:reset value="重置"></s:reset>
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
