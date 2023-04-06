package com.kagami.j2ee.book.service;

import com.kagami.j2ee.book.dao.BookDao;
import com.kagami.j2ee.book.entity.BookInfo;

import java.util.List;

public class BookService {

    private BookDao bookDao;

    public BookService() {
        this.bookDao = new BookDao();
    }

    public List<BookInfo> getBookInfos(BookInfo bookInfo) {
        // TODO Add your bussiness
        return this.bookDao.list(bookInfo);
    }

    public BookInfo getBookInfo(int bookId) {
        // TODO Add your bussiness
        return this.bookDao.get(bookId);
    }

    public BookInfo addBookInfo(BookInfo bookInfo) {
        // TODO Add your bussiness
        return this.bookDao.insert(bookInfo);
    }

    public BookInfo modifyBookInfo(BookInfo bookInfo) {
        // TODO Add your bussiness
        return this.bookDao.update(bookInfo);
    }

    public Boolean deleteBookInfo(int booId) {
        // TODO Add your bussiness
        return this.bookDao.delete(booId);
    }
}
