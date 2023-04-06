<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>BookAdd</title>
</head>
<body>
<h1 align="center">新增书籍信息</h1>
<br/>
<form action="add" method="post">
    <table align="center" border="0" width="60%">
        <tr>
            <td width="25%" align="right">书名：</td>
            <td align="left" width="100%">
                <input type="text" name="book_name" value="" style="width: 75%">
            </td>
        </tr>
        <tr>
            <td align="right">作者：</td>
            <td align="left" width="100%">
                <input type="text" name="author" value="" style="width: 75%">
        </tr>
        <tr>
            <td align="right">出版社：</td>
            <td align="left" width="100%">
                <input type="text" name="publisher" value="" style="width: 75%">
            </td>
        </tr>
        <tr>
            <td align="right">ISBN：</td>
            <td align="left" width="100%">
                <input type="text" name="isbn" value="" style="width: 75%">
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
