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
				<font face="宋体" color="green"> 显示所有学生信息 </font>
			</h3>
		</center>
		欢迎：<%=session.getAttribute("username")%>
		<s:a href="main.jsp">返回主页</s:a>
		<s:a href="logout.jsp">注销</s:a>
		<hr size=2 color="green">

		<table border=1 align="center" width="800">
			<tr>
				<td>
					头像
				</td>
				<td>
					学号
				</td>
				<td>
					家庭地址
				</td>
				<td>
					班级
				</td>
				<td>
					毕业学校
				</td>
				<td>
					手机号
				</td>
				<td>
					姓名
				</td>
				<td>
					现居地
				</td>
				<td>
					性别
				</td>

			</tr>
			<s:iterator value="#session.students" status="stuts">
				<tr>
					<td>
						<img src="<s:property value='StuPhoto' />" />
					</td>
					<td>
						<s:property value="stuId" />
					</td>
					<td>
						<s:property value="stuAddr" />
					</td>
					<td>
						<s:property value="stuClass" />
					</td>
					<td>
						<s:property value="stuGrdSchool" />
					</td>
					<td>
						<s:property value="stuMobilePhone" />
					</td>
					<td>
						<s:property value="stuName" />
					</td>
					<td>
						<s:property value="stuNowAddr" />
					</td>
					<td>
						<s:property value="stuSex" />
					</td>
				</tr>
			</s:iterator>
		</table>


	</body>
</html>
