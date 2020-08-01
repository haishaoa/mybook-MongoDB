<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="images/skin.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<!--<style type="text/css">-->
<!--body {-->
<!--margin-left: 0px;-->
<!--margin-top: 0px;-->
<!--margin-right: 0px;-->
<!--margin-bottom: 0px;-->
<!--background-color: #EEF2FB;-->
<!--}-->
<!--</style>-->

<style type="text/css">
	.book {
		border-radius: 5px;
		padding: 6px 0px;
		width: 320px;
		margin: 30px;
	}
</style>

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
		<td valign="top" bgcolor="#F7F8F9" height="800">
			<table width="98%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0">
				<!--头部间距-->
				<tr>
					<td colspan="2" valign="top">&nbsp;</td>
					<td>&nbsp;</td>
					<td valign="top">&nbsp;</td>
				</tr>

				<!--输入部分-->
				<tr>
					<td width="7%" height="100%">&nbsp;</td>
					<td width="80%" height="800px" valign="top">
						<form action="bookServlet?action=insertbook" method="post">

							<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0"
							       class="line_table">
								<tr>

									<td height="102" valign="top" style="font-size:24px;">
										<div style="margin: 50px 0px 100px 300px">
											图书名称:<input class="book" type="text" name="bookname" id="bookname"><br>
											图书种类:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<select name="booktype" style="padding: 6px 0px;border-radius: 5px;">
												<option value="教材">教材</option>
												<option value="历史">历史</option>
												<option value="文学">文学</option>
											</select><br>
											图书价格:<input class="book" type="text" name="booksalary" id="booksalary"><br>
											VIP书籍:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<input style="zoom: 2" type="radio" name="vip" value="是">是
											<input style="zoom: 2" type="radio" name="vip" value="否">否
											<br>
											图书库存:<input class="book" type="text" name="bookstock" id="bookstock"><br>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<input style="padding: 4px 0px;width: 50px;border-radius: 5px;" type="submit" value="提交">
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<input style="padding: 4px 0px;width: 50px;border-radius: 5px;" type="reset" value="重置">
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
