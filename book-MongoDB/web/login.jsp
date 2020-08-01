<%--
  Created by IntelliJ IDEA.
  User: 爱你的嗨少
  Date: 2020/5/12
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
    <%--<link rel="stylesheet" type="text/css"--%>
          <%--href="./bootstrap/css/bootstrap.min.css">--%>
    <link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap.min.css">

    <script type="text/javascript">
        var xmlHttp;
        var username;
        var password;
        var usernameContent1;
        var usernameContent2;
        function loadCheck() {
            if (document.getElementById("username").value.length == 0){
                show.innerHTML = "请输入用户名";
            } else {
                usernameContent1 = document.getElementById("username");
                usernameContent2 = document.getElementById("password");

                username = usernameContent1.value;
                password = usernameContent2.value;
                xmlHttp = createXmlHttpRequest();
                xmlHttp.onreadystatechange = getResult;
                xmlHttp.open("POST","userServlet?action=login",true);
                xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
                var data = "username=" + username + "&password=" + password;
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
            document.getElementsByClassName("checkbox");
            if (xmlHttp.readyState === 4){
                if (xmlHttp.status === 200){
                    var result = xmlHttp.responseText;
                    if (result == "用户存在"){
                        window.location='index.jsp';
                    } else {
                        show.innerHTML = "登录失败";
                    }
                }
            }
        }
    </script>

</head>

<body style="background-image: url('./images/dl.jpg');background-size:cover ">
<div class="row" style="margin: 50px 0px 0px 300px;">
    <div class="col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default"
             style="margin-top: 200px;">
            <div class="panel-heading">图书管理系统</div>
            <div class="panel-body">
                <form role="form" method="post">
                    <fieldset>
                        <div class="form-group">
                            <input class="form-control" placeholder="用户名:" name="Name"
                                   type="text" id="username">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="密码:"
                                   name="password" type="password" id="password">
                        </div>
                        <div class="checkbox">
                            <br>
                        </div>
                        <div id="show"></div>
                        <div class="form-group">
                            <input class="form-control btn btn-primary" type="button"
                                   value="提交" style="width: 50%; margin-left: 25%;" onclick="loadCheck()">
                        </div>

                    </fieldset>
                </form>
            </div>
            <div>
                <a href="Register.jsp"><font color="black">去注册</font></a>
            </div>
        </div>

    </div>
</div>


</body>
</html>
























