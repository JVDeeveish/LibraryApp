<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.dev.bean.StudentBean,com.dev.service.StudentService,com.dev.service.StudentServiceImpl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
 int rollNo = Integer.parseInt(request.getParameter("rollNo"));
 String name= request.getParameter("username");
 String pwd=request.getParameter("password");
 StudentBean s = new StudentBean(rollNo,name,pwd);
 StudentServiceImpl st = new StudentServiceImpl();
 System.out.println(s.getStudentName());
 st.addUser(s);	
%>
</body>
</html>