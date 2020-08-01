<%@ page import="service.BorrowService" %>
<%@ page import="service.impl.BorrowServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="pojo.Reader" %>
<%@ page import="service.ReaderService" %>
<%@ page import="service.impl.ReaderServiceImpl" %>
<%@ page import="web1.ReaderFindServlet" %>
<%@ page import="web1.EnteryServlet" %>
<%@ page import="pojo.Book" %>
<%@ page import="web.ReaderServlet" %><%--
  Created by IntelliJ IDEA.
  User: 爱你的嗨少
  Date: 2020/5/20
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>借阅图书</title>
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
                        <div class="titlebt">请输入图书信息</div>
                    </td>
                </tr>
            </table>
        </td>

        <td width="16" valign="top" background="images/mail_rightbg.gif">
            <img src="images/nav-right-bg.gif" width="16" height="29"/></td>
    </tr>


    <tr>
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
                    <td width="7%" height="800px">&nbsp;</td>
                    <td width="80%" valign="top">
                        <form action="borrowServlet?action=insertborrow" method="post">

                            <table width="100%" height="144" border="0" cellpadding="0" cellspacing="0"
                                   class="line_table">
                                <div style="margin: 30px 0px 0px 0px;">
                                    <tr>
                                        <td>
                                            <div style="font-size: 50px;margin: 30px 0px 100px 230px;">
                                                读&nbsp;者&nbsp;名&nbsp;:
                                                <select style="padding: 12px 0px;width: 280px;font-size: 25px" name="readername">
                                                    <%
                                                        ReaderServlet readerServlet = new ReaderServlet();
                                                        List<Reader> list = readerServlet.find();
                                                        for (Reader reader : list) {
                                                    %>
                                                    <option value="<%=reader.getReadername()%>"><%=reader.getReadername()%>
                                                    </option>
                                                    <%}%>
                                                </select><br>
                                            </div>
                                            <div style="font-size: 50px;margin: 130px 0px 130px 230px;">
                                                图书名称:
                                                <select name="bookname" style="padding: 12px 0px;width: 280px;font-size: 25px;">

                                                    <%
                                                        EnteryServlet enteryServlet = new EnteryServlet();
                                                        List<Book> booklist = enteryServlet.find();
                                                        for (Book book : booklist) {
                                                    %>
                                                    <option value="<%=book.getBookname()%>"><%=book.getBookname()%>
                                                    </option>
                                                    <%}%>
                                                </select><br>
                                            </div>
                                            <input style="padding: 7px 0px;margin: 30px;border-radius: 5px;width: 80px;margin: 0px 0px 0px 300px" type="submit" value="确认">
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <input style="padding: 7px 0px;margin: 30px;border-radius: 5px;width: 80px;" type="reset" value="重置">
                                        </td>
                                    </tr>
                                </div>
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
