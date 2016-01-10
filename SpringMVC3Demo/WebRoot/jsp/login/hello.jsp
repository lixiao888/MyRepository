<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*"  pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
      <head>

	<base href="<%=basePath%>">

	     <title>Hello</title>

      </head>

      <body>
                            你好:<%=request.getAttribute("loginUser") %>，现在时间是<%= new Date() %>
      </body>

</html>
