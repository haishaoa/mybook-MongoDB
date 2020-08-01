<%@ page import="pojo.Book" %>
<%@ page import="web1.EnteryServlet" %>
<%--
  Created by IntelliJ IDEA.
  User: 爱你的嗨少
  Date: 2020/5/19
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <title>修改图书信息</title>
    <style type="text/css">
        .changebook {
            border-radius: 5px;
            padding: 4px 0px;
            margin: 25px;
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
                        <div class="titlebt">修改书籍信息</div>
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
                            <form method="post" action="changebook.jsp">
                                <fieldset>
                                    <div style="margin: 0px 0px 0px 350px">
                                        &nbsp;&nbsp;请输入书籍名:&nbsp;&nbsp;&nbsp;
                                        <input style="border-radius: 5px;padding: 4px 0px" placeholder="书籍名"
                                               name="bookname">&nbsp;
                                        <input type="submit" value="确定">
                                    </div>
                                </fieldset>
                            </form>
                            <%--设置要修改信息的显示--%>
                            <%
                                String bookname = request.getParameter("bookname");
                                if (bookname == null) {

                                } else {
                                    EnteryServlet enteryServlet = new EnteryServlet();
                                    Book book = enteryServlet.selectBybookname(bookname);
                            %>
                            <div>
                                <form method="post" action="bookServlet?action=changebook">
                                    <fieldset>
                                        <div style="margin: 0px 0px 0px 400px">
                                            <div>
                                                图书编号:<input class="changebook" readonly="readonly" placeholder="图书编号"
                                                            name="createOrderNum" type="text"
                                                            value="<%=book.getCreateOrderNum()%>">
                                            </div>
                                            <div>
                                                图书名称:<input class="changebook" readonly="readonly" placeholder="图书名称"
                                                            name="bookname" type="text" value="<%=book.getBookname()%>">
                                            </div>
                                            <div>
                                                图书种类:<input class="changebook" placeholder="图书种类" name="booktype"
                                                            type="text" value="<%=book.getBooktype()%>">
                                            </div>
                                            <div>
                                                图书价格:<input class="changebook" placeholder="图书价格" name="booksalary"
                                                            type="text" value="<%=book.getBooksalary()%>">
                                            </div>
                                            <div>
                                                &nbsp;库&nbsp;&nbsp;存&nbsp;&nbsp;&nbsp;:<input class="changebook"
                                                                                              placeholder="库存"
                                                                                              name="bookstock"
                                                                                              type="text"
                                                                                              value="<%=book.getBookstock()%>">
                                            </div>
                                            <div>
                                                是否为vip:<input class="changebook" placeholder="是否为vip" name="vip"
                                                              type="text" value="<%=book.getVip()%>">
                                            </div>
                                            <div>
                                                录入时间:<input class="changebook" readonly="readonly" placeholder="录入时间"
                                                            name="time" type="text" value="<%=book.getTime()%>">
                                            </div>
                                            <div>
                                                <input type="submit" value="修改"
                                                       style="padding: 4px 0px;width: 80px;margin: 0px 0px 0px 70px">
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
