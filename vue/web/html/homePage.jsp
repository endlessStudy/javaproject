<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: huayu
  Date: 2017/8/24
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta name="viewport" content="width=device-width, initial-scale=1.0" ,maxinum-scale="1.0" ,user-scale="no">
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/bootstrap-theme.css">
<link rel="stylesheet" href="../css/pageCss/homePage.css">
<script src="../js/app/jquery-1.11.3.min.js"></script>
<script src="../js/app/bootstrap.js"></script>
<script src="../css/reset.css"></script>

<style>

</style>
<html>
<head>
    <title>首页面</title>
</head>
<body>
<div class="test">
    <div class="head-div"> <img class="head-icon-img" src="../images/group.png"/><span id="loginUser"></span></div>
    <iframe src="head.jsp" ></iframe>
    <div class="container">
        <div>
            <ul class="nav nav-tabs nav-pills nav-justified" id="navigate">
                <li class="nav-li active"><a href="javascript:void(0);">java</a></li>
                <li class="nav-li"><a href="javascript:void(0);">PHP</a></li>
                <li class="nav-li"><a href="javascript:void(0);">Python</a></li>
            </ul>
        </div>
        <table class="table table-striped table-hover">
            <tbody>
            <tr>
                <th><big>标题</big></th>
                <th>作者</th>
                <th>发表时间</th>
                <th>更新时间</th>
                <th>操作</th>
            </tr>
            <c:forEach var="use" items="${user}" begin="0" step="1" varStatus="status">
                <tr >
                    <td>${use.username }</td>
                    <td>${use.enabled }</td>
                    <td>${use.createTime }</td>
                    <td>${use.expired }</td>
                    <td><a href="javascript:void(0);">查看</a><a href="javascript:;">编辑</a><a href="">删除</a><a
                            href="">修改</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <%--<script type="application/javascript" src="../js/homePage.js"></script>--%>
        <script type="application/javascript" src="../js/common.js"></script>
        <script type="application/javascript" src="../js/homePage_1.js"></script>
    </div>
</div>
</body>
</html>
