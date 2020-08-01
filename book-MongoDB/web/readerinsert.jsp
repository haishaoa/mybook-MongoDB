<%--
  Created by IntelliJ IDEA.
  User: 爱你的嗨少
  Date: 2020/5/20
  Time: 1:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .reader{
            margin: 40px;
            font-size: 28px;
        }
        .readerinsert{
            margin: 40px;
            padding: 7px 0px;
            font-size: 24px;
            border-radius: 5px;
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
                        <div class="titlebt">请输入读者信息</div>
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
                <tr height="800">
                    <td width="7%">&nbsp;</td>
                    <td width="80%" valign="top">
                        <form action="readerServlet?action=insertreader" method="post">

                            <table width="100%" height="144" border="0" cellpadding="0" cellspacing="0"
                                   class="line_table">
                                <tr>
                                    <td height="102" valign="top">
                                        <div class="reader" style="margin: 0px 0px 0px 300px">
                                            <div>
                                                读者姓名:<input class="readerinsert" type="text" name="readername"
                                                            id="readername"><br>
                                            </div>
                                            <div>
                                                &nbsp;&nbsp;&nbsp;V&nbsp;&nbsp;I&nbsp;&nbsp;P&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;
                                                <input style="zoom: 2" type="radio" name="vip" value="是">是
                                                <input style="zoom: 2" type="radio" name="vip" value="否">否<br>
                                            </div>
                                            <div>
                                                联系方式:<input class="readerinsert" type="text" name="phone"
                                                            id="phone"><br>
                                            </div>
                                            <div>
                                                &nbsp;&nbsp;信&nbsp;&nbsp;誉&nbsp;&nbsp;:
                                                <select name="credit" class="readerinsert" style="width: 200px">
                                                    <option value="优">优</option>
                                                    <option value="良">良</option>
                                                    <option value="差">差</option>
                                                </select><br>
                                            </div>
                                            <div style="margin: 0px 0px 0px 30px">
                                                <input style="width: 60px" class="readerinsert" type="submit" value="提交">
                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <input style="width: 60px" class="readerinsert" type="reset" value="重置">
                                            </div>
                                        </div>
                                    </td>
                                </tr>
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
