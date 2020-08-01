<%@ page import="web1.EnteryServlet" %>
<%@ page import="pojo.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 爱你的嗨少
  Date: 2020/5/20
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>vip书籍信息</title>
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
                        <div class="titlebt">书籍信息</div>
                    </td>
                </tr>
            </table>
        </td>

        <td width="16" valign="top" background="images/mail_rightbg.gif">
            <img src="images/nav-right-bg.gif" width="16" height="29"/></td>
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
                        <form action="enteryServlet" method="post">

                            <table width="100%" height="144" border="0" cellpadding="0" cellspacing="0"
                                   class="line_table">
                                <tr>
                                    <td>
                                        图书编号
                                    </td>
                                    <td>
                                        图书名称
                                    </td>
                                    <td>
                                        图书种类
                                    </td>
                                    <td>
                                        图书价格
                                    </td>
                                    <td>
                                        库存
                                    </td>
                                    <td>
                                        是否为vip
                                    </td>
                                    <td>
                                        录入时间
                                    </td>
                                    <td>
                                        操作
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        &nbsp;
                                    </td>
                                </tr>

                                <%--通过请求获得books--%>
                                <%--<%--%>
                                <%--List<Book> books = (List<Book>) request.getAttribute("list");--%>
                                <%--for (Book book : books) {--%>
                                <%--%>--%>

                                <%
                                    EnteryServlet enteryServlet = new EnteryServlet();
                                    List<Book> books = enteryServlet.find();
                                    for (Book book : books) {
                                        if ("是".equals(book.getVip())){
                                %>
                                <tr>
                                    <td>
                                        <%=book.getCreateOrderNum()%><hr/>
                                    </td>
                                    <td>
                                        <%=book.getBookname()%><hr/>
                                    </td>
                                    <td>
                                        <%=book.getBooktype()%><hr/>
                                    </td>
                                    <td>
                                        <%=book.getBooksalary()%><hr/>
                                    </td>
                                    <td>
                                        <%=book.getBookstock()%><hr/>
                                    </td>
                                    <td>
                                        <%=book.getVip()%><hr/>
                                    </td>
                                    <td>
                                        <%=book.getTime()%><hr/>
                                    </td>
                                    <td>
                                        <a href="javascript:if(confirm('确认要删除吗？'))location='delServlet?createOrderNum=<%=book.getCreateOrderNum()%>'">[删除]</a>
                                        &nbsp;&nbsp;&nbsp;
                                        <a href="changebook.jsp?bookname=<%=book.getBookname()%>">[修改]</a><hr/>
                                    </td>
                                </tr>
                                <%}%>
                                <%}%>
                            </table>
                        </form>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
