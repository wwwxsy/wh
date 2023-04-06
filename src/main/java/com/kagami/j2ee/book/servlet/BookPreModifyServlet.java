package com.kagami.j2ee.book.servlet;

import com.kagami.j2ee.book.entity.BookInfo;
import com.kagami.j2ee.book.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "bookPreModifyServlet", value = "/book/premodify")
public class BookPreModifyServlet extends HttpServlet {

    private BookService bookService = new BookService();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String bookId = request.getParameter("book_id");
        BookInfo bookInfo = this.bookService.getBookInfo(bookId == null ? 0 : Integer.parseInt(bookId));
        request.getSession().setAttribute("bookInfo", bookInfo);
        request.getRequestDispatcher("bookmodify.jsp").forward(request,response);
    }

    public void destroy() {
    }
}
