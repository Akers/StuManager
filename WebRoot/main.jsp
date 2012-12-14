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
			if (sc != null) {
				String username = (String) session.getAttribute("username");
				String addSuccess = (String) session.getAttribute("addSuccess");
				if ((Integer) sc == 1) {
		%>


		<center>
			<h1>
				<font face="宋体" color="green">欢迎学生管理系统</font>
			</h1>
		</center>

		<br>
		<br>
		欢迎 ：<%=username%>
		<s:a href="logout.jsp">注销</s:a>
		<br>
		<hr color="green" size="1">
		管理员信息：
		<br>
		<br>

		<s:a href="addAdmin.jsp">添加管理员</s:a>

		<s:a href="modifyPsw.jsp">修改密码</s:a>

		<s:a href="showAdmins.action">显示所有管理员</s:a>

		<s:a href="delAdmin.jsp">删除管理员</s:a>



		<br>
		<hr color="green" size="1">
		<br>
		<br>
		<br>
		<br>
		学生信息管理
		<br>
		<br>
		<hr color="green" size="1">

		<s:a href="showStudents.action">查看所有学生信息</s:a>

		<s:a href="addStudent.jsp">添加学生信息</s:a>

		<s:a href="delStudent.jsp">删除学生</s:a>

		<br>
		<br>
		<br>
		<br>
		<br>
		学生成绩管理
		<br>
		<br>
		<hr color="green" size="1">
		<s:a href="showCourses.action">查看所有课程</s:a>
		<s:a href="addCourse.jsp">添加课程</s:a>
		<s:a href="addScore.action">添加学生成绩</s:a>
		<s:a href="showScores.action">查看学生成绩</s:a>




		<%
			} else {
					response.sendRedirect("illegal.jsp");
				}

			} else {
				response.sendRedirect("illegal.jsp");
			}
		%>

	</body>
</html>
