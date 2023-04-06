package com.kagami.j2ee.book.servlet;

import com.kagami.j2ee.book.entity.BookInfo;
import com.kagami.j2ee.book.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "bookListServlet", value = "/book/list")
public class BookListServlet extends HttpServlet {

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
        List<BookInfo> bookInfos = this.bookService.getBookInfos(bookInfo);
        request.getSession().setAttribute("searchCondition", bookInfo);
        request.getSession().setAttribute("bookInfos", bookInfos);
        request.getRequestDispatcher("booklist.jsp").forward(request,response);
    }

    public void destroy() {
    }
}
