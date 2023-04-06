package com.kagami.j2ee.book.dao;

import com.kagami.j2ee.book.entity.BookInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    private Connection conn;

    public BookDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/java_test?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false";
            String user = "root";
            String passwd = "root";
            this.conn = DriverManager.getConnection(url, user, passwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<BookInfo> list(BookInfo bookInfo) {
        List<BookInfo> bookInfos = new ArrayList<BookInfo>();
        try {
            String sql = "select * from book_info where book_name like ? and author like ? and publisher like ?";
            PreparedStatement stat = this.conn.prepareStatement(sql);
            stat.setString(1, "%" + bookInfo.getBookName() == null ? "" : bookInfo.getBookName() + "%");
            stat.setString(2, "%" + bookInfo.getAuthor() == null ? "" : bookInfo.getAuthor() + "%");
            stat.setString(3, "%" + bookInfo.getPublisher() == null ? "" : bookInfo.getPublisher() + "%");
            ResultSet result = stat.executeQuery();
            while (result.next()) {
                BookInfo book = new BookInfo();
                book.setBookId(result.getInt("book_id"));
                book.setBookName(result.getString("book_name"));
                book.setAuthor(result.getString("author"));
                book.setIsbn(result.getString("isbn"));
                book.setPublisher(result.getString("publisher"));
                bookInfos.add(book);
            }
            result.close();
            stat.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookInfos;
    }

    public BookInfo get(int bookId) {
        BookInfo bookInfo = null;
        try {
            String sql = "select * from book_info where book_id=?";
            PreparedStatement stat = this.conn.prepareStatement(sql);
            stat.setInt(1, bookId);
            ResultSet result = stat.executeQuery();
            if (result.next()) {
                bookInfo = new BookInfo();
                bookInfo.setBookId(result.getInt("book_id"));
                bookInfo.setBookName(result.getString("book_name"));
                bookInfo.setAuthor(result.getString("author"));
                bookInfo.setIsbn(result.getString("isbn"));
                bookInfo.setPublisher(result.getString("publisher"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookInfo;
    }

    public BookInfo insert(BookInfo bookInfo) {
        int result = 0;
        try {
            String sql = "insert into book_info(book_name,author,isbn,publisher) value(?,?,?,?)";
            PreparedStatement stat = this.conn.prepareStatement(sql);
            stat.setString(1, bookInfo.getBookName());
            stat.setString(2, bookInfo.getAuthor());
            stat.setString(3, bookInfo.getIsbn());
            stat.setString(4, bookInfo.getPublisher());
            result = stat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result > 0)
            return bookInfo;
        else
            return null;
    }

    public BookInfo update(BookInfo bookInfo) {
        int result = 0;
        try {
            String sql = "update book_info set book_name=?,author=?,isbn=?,publisher=? where book_id=?";
            PreparedStatement stat = this.conn.prepareStatement(sql);
            stat.setString(1, bookInfo.getBookName());
            stat.setString(2, bookInfo.getAuthor());
            stat.setString(3, bookInfo.getIsbn());
            stat.setString(4, bookInfo.getPublisher());
            stat.setInt(5, bookInfo.getBookId());
            result = stat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result > 0)
            return bookInfo;
        else
            return null;
    }

    public Boolean delete(int booId) {
        Boolean success = false;
        try {
            String sql = "delete from book_info where book_id=?";
            PreparedStatement stat = this.conn.prepareStatement(sql);
            stat.setInt(1, booId);
            int result = stat.executeUpdate();
            if (result > 0)
                success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}
