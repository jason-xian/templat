<%@ page language="java" import="com.pojo.*,
	com.biz.*,
	java.util.*"
	contentType="text/html; 
	charset=utf-8" pageEncoding="utf-8"%>
<%@include file="inc.jsp"%>
<jsp:useBean id="st" class="com.pojo.Student" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="st" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>控制层</title>
	<%
			IStudentBiz sbiz = new StudentBiz();
			String s = request.getParameter("op");
			int op = Integer.parseInt(s);
		switch (op) {
		case 1://增加
			System.out.println("doservice.jsp:" + st.toString());
			boolean flag = sbiz.save(st);
			if (flag) {
				response.sendRedirect("doService.jsp?op=5");
			} else {
				response.sendRedirect("error.jsp");
			}
			break;
		case 2://修改
			System.out.println("doservice.jsp:" + st.toString());
			flag = sbiz.update(st);
			if (flag) {
				response.sendRedirect("doService.jsp?op=5");
			} else {
				response.sendRedirect("error.jsp");
			}
			break;
		case 3://删除
			String sid = request.getParameter("sid");
			System.out.println("删除：" + sid);
			flag = sbiz.delById(sid);
			if (flag) {
				response.sendRedirect("doService.jsp?op=5");
			} else {
				response.sendRedirect("error.jsp");
			}
			break;
		case 4://查询单个
			sid = request.getParameter("sid");
			System.out.println("查询单个：" + sid);
			Student oldst = sbiz.findById(sid);
			session.setAttribute("oldst", oldst);
			response.sendRedirect("stuupdate.jsp");
			break;
		case 5://查询所有
			List<Student> lsst = sbiz.findAll();
			session.setAttribute("lsst", lsst);
			response.sendRedirect("stulist.jsp");
			break;
		case 6://班级查询
			
			break;
		}
	%>
</head>
<body>
</body>
</html>