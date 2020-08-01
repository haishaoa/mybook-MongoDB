<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 爱你的嗨少
  Date: 2020/5/20
  Time: 2:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="pojo.Book" %>
<%@ page import="web1.EnteryServlet" %>
<%@ page import="web1.ReaderFindServlet" %>
<%@ page import="pojo.Reader" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                        <div class="titlebt">读者信息</div>
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
                                        读者姓名
                                    </td>
                                    <td>
                                        是否为vip
                                    </td>
                                    <td>
                                        联系方式
                                    </td>
                                    <td>
                                        信誉
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        &nbsp;
                                    </td>
                                </tr>

                                <%--通过方法调用--%>
                                <%--ReaderFindServlet readerFindServlet = new ReaderFindServlet();--%>
                                <%--List<Reader> books = readerFindServlet.find();--%>
                                <%--for (Reader ReaderServlet : books) {--%>

                                <%--通过请求获得books--%>
                                <%--<%--%>
                                <%--List<Reader> list = (List) request.getAttribute("list");--%>
                                <%--for (Reader ReaderServlet : list) {--%>
                                <%--%>--%>

                                <c:forEach items="${requestScope.list}" var="reader">

                                <tr>
                                    <td>
                                            ${reader.getReadername()}<hr/>
                                    <%--<%=ReaderServlet.getReadername() + 1%><hr/>--%>
                                    </td>
                                    <td>
                                            ${reader.getVip()}<hr/>
                                        <%--<%=ReaderServlet.getVip()%><hr/>--%>
                                    </td>
                                    <td>
                                            ${reader.getPhone()}<hr/>
                                        <%--<%=ReaderServlet.getPhone()%><hr/>--%>
                                    </td>
                                    <td>
                                            ${reader.getCredit()}<hr/>
                                        <%--<%=ReaderServlet.getCredit()%><hr/>--%>
                                    </td>
                                    <td>
                                        <a href="javascript:if(confirm('确认要删除吗？'))location='readerServlet?action=delreader&readername=${reader.getReadername()}'">[删除]</a><hr/>
                                    </td>
                                </tr>
                                </c:forEach>
                                <%--<%}%>--%>
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

