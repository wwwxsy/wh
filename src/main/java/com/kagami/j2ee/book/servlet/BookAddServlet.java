package com.kagami.j2ee.book.servlet;

import com.kagami.j2ee.book.entity.BookInfo;
import com.kagami.j2ee.book.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "bookAddServlet", value = "/book/add")
public class BookAddServlet extends HttpServlet {

    private BookService bookService = new BookService();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BookInfo bookInfo = new BookInfo();
        bookInfo.setBookName(request.getParameter("book_name") == null ? "" : request.getParameter("book_name"));
        bookInfo.setAuthor(request.getParameter("author") == null ? "" : request.getParameter("author"));
        bookInfo.setPublisher(request.getParameter("publisher") == null ? "" : request.getParameter("publisher"));
        bookInfo.setIsbn(request.getParameter("isbn") == null ? "" : request.getParameter("isbn"));
        BookInfo result = this.bookService.addBookInfo(bookInfo);
        if (result == null)
            System.out.println("添加书籍信息失败！");
        response.sendRedirect("list");
    }

    public void destroy() {
    }
}
