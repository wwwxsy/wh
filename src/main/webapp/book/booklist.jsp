
<%@ page import="com.kagami.j2ee.book.entity.BookInfo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>BookList</title>
</head>

<%
    BookInfo searchCondition = (BookInfo) session.getAttribute("searchCondition");
    List<BookInfo> bookInfos = (List) session.getAttribute("bookInfos");
    if (bookInfos != null && searchCondition != null) { %>
<script type="text/javascript">
    // alert("<%= "当前书籍数量" + bookInfos.size() + "！" %>");
</script>
<% } else { %>
<script type="text/javascript">
    alert("查询书籍列表信息出错！");
</script>
<% }%>
<script type="text/javascript">
    function getBookInfo(bookId) {
        let obj = document.getElementById("book_id");
        obj.value = bookId;
        let form = document.getElementById("forward");
        form.action = "content";
        form.submit();
    }

    function modifyBookInfo(bookId) {
        let obj = document.getElementById("book_id");
        obj.value = bookId;
        let form = document.getElementById("forward");
        form.action = "premodify";
        form.submit();
    }

    function deleteBookInfo(bookId, bookName) {
        if (confirm("是否确认删除书籍《" + bookName + "》的信息？") == true) {
            let obj = document.getElementById("book_id");
            obj.value = bookId;
            let form = document.getElementById("forward");
            form.action = "delete";
            form.submit();
        }
    }
</script>
<body>
<h1 align="center">图书信息列表</h1>
<br>
<form action="list" method="post">
    <div align="center">
        <label style="size: 48px; align-content: center">
            <strong>书籍查询</strong>
        </label>
    </div>
    <br>
    <div align="center">
        书名：<input type="text" name="book_name" value="<%=searchCondition.getBookName()%>"/>
        &nbsp;&nbsp;
        作者：<input type="text" name="author" value="<%=searchCondition.getAuthor()%>"/>
        &nbsp;&nbsp;
        出版社：<input type="text" name="publisher" value="<%=searchCondition.getPublisher()%>"/>
        &nbsp;&nbsp;
        <input type="submit" value="查询">
    </div>
</form>
<form id="forward" action="" method="post">
    <input type="hidden" name="book_id" id="book_id">
</form>
<br>
<table align="center" border="1" width="90%">
    <tr>
        <th width="30%">书名</th>
        <th width="20%">作者</th>
        <th width="20%">出版社</th>
        <th width="15%">ISBN</th>
        <th>操作</th>
    </tr>
    <% for (BookInfo bookInfo : bookInfos) { %>
    <tr>
        <td align="center"><a href="#"
                              onclick="getBookInfo(<%=bookInfo.getBookId()%>)"><%=bookInfo.getBookName()%>
        </a></td>
        <td align="center"><%=bookInfo.getAuthor()%>
        </td>
        <td align="center"><%=bookInfo.getPublisher()%>
        </td>
        <td align="center"><%=bookInfo.getIsbn()%>
        </td>
        <td align="center">
            <button type="button" id="bmodify" onclick="modifyBookInfo(<%=bookInfo.getBookId()%>)">修改</button>
            &nbsp;
            <button type="button" id="bdelete" onclick="deleteBookInfo(<%=bookInfo.getBookId()%>, '<%=bookInfo.getBookName()%>')">删除</button>
        </td>
    </tr>
    <% } %>
</table>
<br>
<div align="center">
    <button type="button" onclick="javascript:location.href='bookadd.jsp';">添加书籍</button>
</div>
</body>
</html>
