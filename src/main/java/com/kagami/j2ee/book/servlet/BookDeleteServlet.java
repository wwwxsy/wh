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

@WebServlet(name = "bookDeleteServlet", value = "/book/delete")
public class BookDeleteServlet extends HttpServlet {

    private BookService bookService = new BookService();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String bookId = request.getParameter("book_id");
        Boolean result = this.bookService.deleteBookInfo(bookId == null ? 0 : Integer.parseInt(bookId));
        if (!result)
            System.out.println("删除书籍信息失败！");
        response.sendRedirect("list");
    }

    public void destroy() {
    }
}
