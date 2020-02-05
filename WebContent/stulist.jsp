<%@ page language="java" 
	import="com.pojo.*,com.biz.*,java.util.*" 
	contentType="text/html; charset=utf-8" 
	pageEncoding="utf-8"%>
<%@include file="inc.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
<%
	List<Student> lsst = (List<Student>) session.getAttribute("lsst");
	if (lsst == null) {
		response.sendRedirect("stuadd.jsp");
	}
%>
</head>
<body>
	<table border="1" width="400" height="400" align="center">
		<tr align="center" bgcolor="#FFFFCC">
			<td colspan="7">用户展示</td>
		</tr>
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>住址</td>
			<td>生日</td>
			<td>班级</td>
			<td>操作</td>
		</tr>
		<%
			for (Student st : lsst) {
		%>
		<tr>
			<td><%=st.getStuid()%></td>
			<td><%=st.getSname()%></td>
			<td><%=st.getSex()%></td>
			<td><%=st.getAddress()%></td>
			<td><%=st.getBirthday()%></td>
			<td><%=st.getCname()%></td>
			<td><a href="doService.jsp?op=3&sid=<%=st.getStuid()%>">删除</a> <a
				href="doService.jsp?op=4&sid=<%=st.getStuid()%>">修改</a></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>