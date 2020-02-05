<%@ page language="java" import="com.pojo.*,com.biz.*,java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="inc.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
<!-- 不要用自带浏览器打开 -->
<%
	/* request.setCharacterEncoding("Utf-8");
	response.setCharacterEncoding("utf-8"); */
	IStudentBiz sbiz = new StudentBiz();
	//获取班级列表
	List<Clazz> lsca = sbiz.doinit();
%>
</head>
<body>
	<form action="doService.jsp" method="post">
		<table border="1" width="400" height="400" align="center">
			<tr align="center" bgcolor="#FFFFCC">
				<td colspan="2">用户注册</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="sname" id="sname"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="radio" name="sex" id="radio1"
					checked="checked" value="男">男 <input type="radio"
					name="sex" id="radio2" value="女">女</td>
			</tr>
			<tr>
				<td>住址</td>
				<td><input type="text" name="address" id="address"></td>
			</tr>
			<tr>
				<td>生日</td>
				<td><input type="date" name="birthday" id="birthday"
					value="1990-01-01"></td>
			</tr>
			<tr>
				<td>班级</td>
				<td><select name="classid" id="classid">
						<%
							for (Clazz ca : lsca) {
						%>
						<option value="<%=ca.getCid()%>"><%=ca.getCname()%></option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr align="center" bgcolor="#FFFFCC">
				<td colspan="2"><input type="hidden" id="op" name="op"
					value="1"> <input type="submit" value="提交"> <input
					type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>