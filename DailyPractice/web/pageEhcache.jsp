<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>测试</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript">
        function insert(){
            var record = $("#formID").serializeArray();
            console.info(record);
            $.ajax({
                url : "<%=request.getContextPath()%>/systemLogController/insert.do",
                type : 'post',
                async:true,
                dataType:'json',
                data : record,
                success:function(result){
                    alert("插入成功！");
                }
            });
        }
    </script>
</head>
<body>
<h1><%=new Date()%></h1>
<h1>这是一个练习</h1>
<form id="formID" action="">
    id: <input name="id" type="text"/><br>
    <input type="button" value="插入" onclick="insert()"/>
</form>
<br>
总数：
<h4>${num}</h4>
</body>
</html>