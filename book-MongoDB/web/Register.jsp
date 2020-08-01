<%--
  Created by IntelliJ IDEA.
  User: 爱你的嗨少
  Date: 2020/5/13
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>图书管理系统</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css"
          href="./bootstrap/css/bootstrap.min.css">

    <script type="text/javascript">
        var xmlHttp;
        var username;
        var id;
        var password;
        var usernameContent;
        var passwordContent;
        var idContent;
        function loadCheck() {
            if (document.getElementById("Name").value.length == 0){
                show.innerHTML = "请输入用户名";
            } else {
                usernameContent = document.getElementById("Name");
                passwordContent = document.getElementById("Password");
                idContent = document.getElementById("Id");

                username = usernameContent.value;
                password = passwordContent.value;
                id = idContent.value;
                xmlHttp = createXmlHttpRequest();
                xmlHttp.onreadystatechange = getResult;
                xmlHttp.open("POST","userServlet?action=regist",true);
                xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
                var data = "username=" + username + "&password=" + password + "&id=" + id;
                xmlHttp.send(data);
            }
        }

        function createXmlHttpRequest() {
            if (window.XMLHttpRequest){
                return new XMLHttpRequest();
            } else {
                return new ActiveXObject("Microsoft.XMLHTTP");
            }
        }

        function getResult() {
            document.getElementsByClassName("checkbox1");
            if (xmlHttp.readyState === 4){
                if (xmlHttp.status === 200){
                    var result = xmlHttp.responseText;
                    if (result == "注册成功"){
                        window.location='login.jsp';
                    } else {
                        // window.location='/swzl/login.jsp';
                        show.innerHTML = "此用户名已被占用";
                    }
                }
            }
        }
    </script>

</head>

<%--<body style="background-image:url('./image/zc.png');">--%>
<body style="background-image:url('./images/zc.jpg');background-size:cover">
<div class="row" style="margin: 50px 0px 0px 300px">
    <div class="col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default"
             style="margin-top:200px;">
            <div class="panel-heading">用户注册</div>
            <div class="panel-body">
                <form role="form" method="post">
                    <fieldset>
                        <div class="form-group">
                            <input class="form-control" placeholder="用户名" name="Name" id="Name"
                                   type="text" autofocus="">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="学号"
                                   name="Id" id="Id" type="text" value="">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="密码" id="Password"
                                   name="Password" type="password" value="">
                        </div>
                        <div class="checkbox1">
                            <br>
                        </div>
                        <div id="show"></div>
                        <div class="form-group">
                            <input class="form-control btn btn-warning" type="button" onclick="loadCheck()"
                                   value="注册" style="width:50%;margin-left:25%;">
                        </div>
                    </fieldset>
                </form>
            </div>
            <div>
                <a href="login.jsp"><font color="black">去登陆</font></a>
            </div>
        </div>

    </div>
</div>


</body>
</html>

