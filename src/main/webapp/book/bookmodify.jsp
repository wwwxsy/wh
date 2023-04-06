<%@ page import="com.kagami.j2ee.book.entity.BookInfo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>BookModify</title>
</head>
<%
    BookInfo bookInfo = (BookInfo) session.getAttribute("bookInfo");
    if (bookInfo == null) { %>
<script type="text/javascript">
    alert("未查询到指定书籍的信息！");
</script>
<% } %>
<body>
<h1 align="center">修改书籍信息</h1>
<br/>
<form action="modify" method="post">
    <input type="hidden" name="book_id" value="<%=bookInfo.getBookId()%>">
    <table align="center" border="0" width="60%">
        <tr>
            <td width="25%" align="right">书名：</td>
            <td align="left" width="100%">
                <input type="text" name="book_name" value="<%=bookInfo.getBookName()%>" style="width: 75%">
            </td>
        </tr>
        <tr>
            <td align="right">作者：</td>
            <td align="left" width="100%">
                <input type="text" name="author" value="<%=bookInfo.getAuthor()%>" style="width: 75%">
        </tr>
        <tr>
            <td align="right">出版社：</td>
            <td align="left" width="100%">
                <input type="text" name="publisher" value="<%=bookInfo.getPublisher()%>" style="width: 75%">
            </td>
        </tr>
        <tr>
            <td align="right">ISBN：</td>
            <td align="left" width="100%">
                <input type="text" name="isbn" value="<%=bookInfo.getIsbn()%>" style="width: 75%">
            </td>
        </tr>
    </table>
    <br>
    <div align="center">
        <button type="submit">提交</button>
        &nbsp;
        <button type="button" onclick="javascript:history.back();">返回</button>
    </div>
</form>
</body>
</html>
