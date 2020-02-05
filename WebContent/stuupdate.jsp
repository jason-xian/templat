<%@ page language="java" import="com.pojo.*,com.biz.*,java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<!-- 引入编码格式 -->
<%@include file="inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改</title>
<%
	IStudentBiz sbiz = new StudentBiz();
	//获取班级列表
	List<Clazz> lsca = sbiz.doinit();
	//获取修改对象数据
	Student oldst = (Student) session.getAttribute("oldst");
%>
</head>
<body>
	<form action="doService.jsp" method="post">
		<table border="1" width="400" height="400" align="center">
			<tr align="center" bgcolor="#FFFFCC">
				<td colspan="2">用户修改</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="sname" id="sname"
					value="<%=oldst.getSname()%>"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="text" name="sex" id="sex" readonly="readonly"
					value="<%=oldst.getSex()%>"></td>
			</tr>
			<tr>
				<td>住址</td>
				<td><input type="text" name="address" id="address"
					value="<%=oldst.getAddress()%>"></td>
			</tr>
			<tr>
				<td>生日</td>
				<td><input type="date" name="birthday" id="birthday"
					value="<%=oldst.getBirthday()%>"></td>
			</tr>
			<tr>
				<td>班级</td>
				<td><select name="classid" id="classid">
						<%
							for (Clazz ca : lsca) {
						%>
						<option value="<%=ca.getCid()%>"
							<%if (ca.getCid().equals(oldst.getClassid())) {%>
							selected="selected" <%}%>><%=ca.getCname()%></option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr align="center" bgcolor="#FFFFCC">
				<td colspan="2"><input type="hidden" id="op" name="op"
					value="2"> <input type="hidden" id="stuid" name="stuid"
					value="<%=oldst.getStuid()%>"> <input type="submit"
					value="修改"> <input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>