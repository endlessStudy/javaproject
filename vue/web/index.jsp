<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    path = path.endsWith("/")?path+"index":path+"/html/login.html";
    response.sendRedirect(path);
%>