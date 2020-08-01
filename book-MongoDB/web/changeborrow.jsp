<%@ page import="web1.BorrowselectBybooknameServlet" %>
<%@ page import="pojo.Borrow" %>
<%@ page import="web.BorrowServlet" %><%--
  Created by IntelliJ IDEA.
  User: 爱你的嗨少
  Date: 2020/5/20
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style type="text/css">
        .changeborrow{
            font-size: 24px;
            margin: 30px 0px 50px 350px;
        }
        .changeborrow input{
            border-radius: 5px;
            font-size: 22px;
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
                        <div class="titlebt">修改借阅信息</div>
                    </td>
                </tr>
            </table>
        </td>
        <td width="16" valign="top" background="images/mail_rightbg.gif">
            <img src="images/nav-right-bg.gif" width="16" height="29"/>
        </td>
    </tr>

    <tr  height="800">
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
                            <%--<form method="post" action="changeborrow.jsp">--%>
                                <%--<fieldset>--%>
                                    <%--<div style="font-size: 24px;margin: 0px 0px 0px 250px">--%>
                                        <%--&nbsp;&nbsp;请输入借阅读者名:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
                                        <%--<input style="font-size: 24px;border-radius: 5px" placeholder="读者名" name="readername">&nbsp;--%>
                                        <%--<input style="font-size: 20px;" type="submit" value="确定">--%>
                                    <%--</div>--%>
                                <%--</fieldset>--%>
                            <%--</form>--%>
                            <%--设置要修改信息的显示--%>
                            <%
                                String readername = request.getParameter("readername");
                                if (readername == null){

                                }else {
                                    BorrowServlet borrowServlet = new BorrowServlet();
                                    Borrow borrow = borrowServlet.selectByReadername(readername);
                            %>
                            <div>
                                <form method="post" action="borrowServlet?action=updateborrow">
                                    <fieldset>
                                        <div class="changeborrow">
                                            操作编号:&nbsp;<input readonly="readonly" placeholder="操作编号" name="number" type="text" value="<%=borrow.getNumber()%>">
                                        </div>
                                        <div class="changeborrow">
                                            读&nbsp;者&nbsp;名&nbsp;:&nbsp;<input readonly="readonly" placeholder="读者名" name="readername" type="text" value="<%=borrow.getReadername()%>">
                                        </div>
                                        <div class="changeborrow">
                                            借阅书籍:&nbsp;<input placeholder="借阅书籍" name="bookname" type="text" value="<%=borrow.getBookname()%>">
                                        </div>
                                        <div class="changeborrow">
                                            借阅时间:&nbsp;<input readonly="readonly" placeholder="借阅时间" name="borrowtime" type="text" value="<%=borrow.getBorrowtime()%>">
                                        </div>

                                        <div class="changeborrow">
                                            <input style="margin: 0px 80px 0px 80px" type="submit" value="修改">
                                            <input type="reset" value="重置">
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
