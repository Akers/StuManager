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
		<center>
			<h3>
				<font face="宋体" color="green"> 学生成绩 </font>
			</h3>
		</center>
		欢迎：<%=session.getAttribute("username")%>
		<s:a href="main.jsp">返回主页</s:a>
		<s:a href="logout.jsp">注销</s:a>
		<hr size=2 color="green">

		<table border=1 align="center" width="400">
			<tr>
				<td align="center">
					课程名
				</td>
				<td align="center">
					学生姓名
				</td>
				<td align="center">
					成绩
				</td>				
			</tr>
			<s:iterator value="scoreList" status="stuts">
				<tr>
					<td>
						<s:property value="course.coursName" />
					</td>
					<td>
						<s:property value="student.stuName" />
					</td>
					<td>
						<s:property value="stuScore" />
					</td>
				</tr>
			</s:iterator>
		</table>


	</body>
</html>
