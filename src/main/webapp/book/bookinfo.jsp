<%@ page import="com.kagami.j2ee.book.entity.BookInfo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>BookInfo</title>
</head>
<%
    BookInfo bookInfo = (BookInfo) session.getAttribute("bookInfo");
    if(bookInfo == null) { %>
<script type="text/javascript">
    alert("未查询到指定书籍的信息！");
</script>
<%  } %>
<body>
<h1 align="center">书籍详细信息</h1>
<br/>
<form action="list" method="post">
</form>
<table align="center" border="1" width="60%">
    <tr>
        <td width="25%" align="center">书名</td>
        <td align="center"><%=bookInfo.getBookName()%></td>
    </tr>
    <tr>
        <td align="center">作者</td>
        <td align="center"><%=bookInfo.getAuthor()%></td>
    </tr>
    <tr>
        <td align="center">出版社</td>
        <td align="center"><%=bookInfo.getPublisher()%></td>
    </tr>
    <tr>
        <td align="center">ISBN</td>
        <td align="center"><%=bookInfo.getIsbn()%></td>
    </tr>
</table>
<br>
<div align="center">
    <button type="button" onclick="javascript:history.back();">返回</button>
</div>
</body>
</html>
