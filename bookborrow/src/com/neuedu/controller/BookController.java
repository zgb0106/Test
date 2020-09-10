package com.neuedu.controller;

import com.neuedu.po.Book;
import com.neuedu.service.BookService;
import com.neuedu.service.impl.BookServiceImpl;
import com.neuedu.utils.ConstantUtil;

import java.util.List;

public class BookController {
    private BookService bs = new BookServiceImpl();
    public String add(Book book) {
        boolean flag = bs.add(book);
        if (flag) {
            return ConstantUtil.BOOK_ADD_SUCCESS;
        }
        return ConstantUtil.BOOK_ADD_FAIL;
    }

    public String delete(int bookId) {
        boolean flag = bs.delete(bookId);
        if (flag) {
            return ConstantUtil.BOOK_DELETE_SUCCESS;
        }
        return ConstantUtil.BOOK_DELETE_FAIL;
    }

    public Book changeBook(int bookId) {
        return bs.changeBook(bookId);
    }

    public Book viewBookInfo(int bookId) {
        return bs.viewBookInfo(bookId);
    }

    public String changeBookName(Book book, String bookName) {
        boolean flag = bs.changeBookName(book,bookName);
        if (flag) {
            return ConstantUtil.BOOK_CHANGE_SUCCESS;
        }
        return ConstantUtil.BOOK_CHANGE_FATL2;
    }

    public String changeBookAuthor(Book book, String bookAuthor) {
        boolean flag = bs.changeBookAuthor(book,bookAuthor);
        if (flag) {
            return ConstantUtil.BOOK_CHANGE_SUCCESS;
        }
        return ConstantUtil.BOOK_CHANGE_FATL2;
    }

    public String changeBookDesc(Book book, String bookDesc) {
        boolean flag = bs.changeBookDesc(book,bookDesc);
        if (flag) {
            return ConstantUtil.BOOK_CHANGE_SUCCESS;
        }
        return ConstantUtil.BOOK_CHANGE_FATL2;
    }

    public String changeBookStock(Book book, int bookStock) {
        boolean flag = bs.changeBookStock(book,bookStock);
        if (flag) {
            return ConstantUtil.BOOK_CHANGE_SUCCESS;
        }
        return ConstantUtil.BOOK_CHANGE_FATL2;
    }

    public List<Book> viewBook() {
        return bs.viewBook();
    }
}
