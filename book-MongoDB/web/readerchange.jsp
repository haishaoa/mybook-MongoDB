<%--
  Created by IntelliJ IDEA.
  User: 爱你的嗨少
  Date: 2020/5/20
  Time: 2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="pojo.Book" %>
<%@ page import="web1.EnteryServlet" %>
<%@ page import="web1.ReaderrselectBybooknameServlet" %>
<%@ page import="pojo.Reader" %>
<%@ page import="web.ReaderServlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <title>修改读者信息</title>
    <style type="text/css">
        .readerchange{
            margin: 40px;
            font-size: 20px;
        }
        .readerchange input{
            border-radius: 5px;
            font-size: 20px;
        }
    </style>
</head>
<body>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <!--右边头部-->
    <tr>
        <td width="17" valign="top" background="images/mail_leftbg.gif">
            <img src="images/left-top-right.gif" width="17" height="29"/>
        </td>
        <td valign="top" background="images/content-bg.gif">
            <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
                <tr>
                    <td height="31">
                        <div class="titlebt">修改读者信息</div>
                    </td>
                </tr>
            </table>
        </td>
        <td width="16" valign="top" background="images/mail_rightbg.gif">
            <img src="images/nav-right-bg.gif" width="16" height="29"/>
        </td>
    </tr>

    <tr height="800">
        <td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
        <td valign="top" bgcolor="#F7F8F9">
            <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                <!--头部间距-->
                <tr>
                    <td colspan="2" valign="top">&nbsp;</td>
                    <td>&nbsp;</td>
                    <td valign="top">&nbsp;</td>
                </tr>

                <!--输入部分-->
                <tr>
                    <td width="7%" height="100%">&nbsp;</td>
                    <td width="80%" valign="top">
                        <%--<form action="enteryServlet" method="post">--%>

                        <table width="100%" height="144" border="0" cellpadding="0" cellspacing="0"
                               class="line_table">

                            <%--设置修改信息获取页面--%>
                            <form method="post" action="readerchange.jsp">
                                <fieldset>
                                    <div style="font-size: 20px;margin: 0px 0px 0px 240px">
                                        &nbsp;&nbsp;请输入读者名:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input style="font-size: 20px;padding: 4px 0px" placeholder="读者姓名"
                                               name="readername">&nbsp;
                                        <input style="font-size: 20px" type="submit" value="确定">
                                    </div>
                                </fieldset>
                            </form>
                            <%--设置要修改信息的显示--%>
                            <%
                                String readername = request.getParameter("readername");
                                if (readername == null) {

                                } else {
                                    ReaderServlet readerServlet = new ReaderServlet();
                                    Reader reader = readerServlet.selectByReadername(readername);
                            %>
                            <div style="margin: 50px 0px 0px 0px">
                                <form method="post" action="readerServlet?action=updatereader">
                                    <fieldset>
                                        <div style="margin: 30px 0px 0px 260px">
                                            <div class="readerchange">
                                                读者&nbsp;姓名:&nbsp;<input readonly="readonly" placeholder="读者姓名" name="readername"
                                                            type="text" value="<%=reader.getReadername()%>">
                                            </div>
                                            <div class="readerchange">
                                                是否为vip:&nbsp;<input placeholder="是否为vip" name="vip" type="text"
                                                              value="<%=reader.getVip()%>">
                                            </div>
                                            <div class="readerchange">
                                                联系&nbsp;方式:&nbsp;<input placeholder="联系方式" name="phone" type="text"
                                                            value="<%=reader.getPhone()%>">
                                            </div>
                                            <div class="readerchange">
                                                &nbsp;&nbsp;&nbsp;信&nbsp;&nbsp;誉&nbsp;&nbsp;&nbsp;:&nbsp;<input placeholder="信誉" name="credit" type="text"
                                                          value="<%=reader.getCredit()%>">
                                            </div>

                                            <div class="readerchange">
                                                <input style="margin: 0px 0px 0px 60px" type="submit" name="修改">&nbsp;&nbsp;&nbsp;&nbsp;
                                                <input style="margin: 0px 0px 0px 60px" type="reset" name="重置">
                                            </div>
                                        </div>
                                    </fieldset>
                                </form>
                            </div>

                            <%}%>

                        </table>
                        <%--</form>--%>
                    </td>
                </tr>
            </table>
        </td>
    </tr>

</table>

</body>
</html>

